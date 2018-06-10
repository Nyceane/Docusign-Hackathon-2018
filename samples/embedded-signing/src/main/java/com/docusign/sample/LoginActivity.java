package com.docusign.sample;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import com.docusign.esign.model.LoginAccount;
import com.docusign.sample.service.DocuSignOAuthService;
import com.docusign.sample.utils.Config;
import com.pubnub.api.PNConfiguration;
import com.pubnub.api.PubNub;
import com.pubnub.api.callbacks.PNCallback;
import com.pubnub.api.callbacks.SubscribeCallback;
import com.pubnub.api.enums.PNStatusCategory;
import com.pubnub.api.models.consumer.PNPublishResult;
import com.pubnub.api.models.consumer.PNStatus;
import com.pubnub.api.models.consumer.pubsub.PNMessageResult;
import com.pubnub.api.models.consumer.pubsub.PNPresenceEventResult;


public class LoginActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private static final String TAG = LoginActivity.class.getSimpleName();
    private static final int LOAD_LOGIN_ACCOUNT = 1;

    private final BroadcastReceiver mAccessTokenReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Retrieve AccessToken and call helper method to get user account information
            String accessToken = intent.getStringExtra(DocuSignOAuthService.EXTRA_ACCESS_TOKEN);
            String accessTokenError = intent.getStringExtra(DocuSignOAuthService.EXTRA_ACCESS_TOKEN_ERROR);

            retrieveLoginAccount(accessToken, accessTokenError);
        }
    };
    private WebView mWebView;
    private ProgressDialog mProgressDialog;

    private int pageState = 0;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.btnWrong).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                switch(pageState)
                {
                    case 1:
                        tts.stop();
                        tts.speak("It's the lower right corner of the screen", TextToSpeech.QUEUE_ADD, null);
                        break;
                    case 2:
                        tts.stop();
                        tts.speak("Signing is in center left fo the screen", TextToSpeech.QUEUE_ADD, null);
                        break;
                    case 3:
                        tts.stop();
                        tts.speak("You can finish at upper right of the screen", TextToSpeech.QUEUE_ADD, null);
                        break;


                }
            }
        });


        mWebView = (WebView) findViewById(R.id.login_webView);
        setUpWebView();

    }

    public void onResume() {
        super.onResume();

        IntentFilter accessTokenFilter = new IntentFilter(DocuSignOAuthService.ACTION_ACCESS_TOKEN);
        LocalBroadcastManager.getInstance(this).registerReceiver(mAccessTokenReceiver, accessTokenFilter);
        tts = new TextToSpeech(this, this);
        tts.setLanguage(Locale.US);
    }

    public void onStop() {
        tts.stop();
        tts = null;
        super.onStop();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mAccessTokenReceiver);
    }

    /**
     * Sets up the webview with DocuSign OAuth UI, in order to get an access token.
     */
    @SuppressWarnings("SetJavaScriptEnabled")
    private void setUpWebView() {
        mWebView.setWebViewClient(new DSOAuthWebViewClient());

        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        mWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        mWebView.getSettings().setUserAgentString("Mozilla/5.0 (Linux; U; Android 2.2; nl-nl; Desire_A8181 Build/FRF91) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1");
        mWebView.getSettings().setSaveFormData(false);
        mWebView.getSettings().setSavePassword(false);

        mWebView.setScrollBarStyle(WebView.SCROLLBARS_INSIDE_OVERLAY);

        CookieSyncManager.createInstance(this);
        clearCookies();

        String url = DocuSignOAuthService.getLoginUrl();
        // load the url in the web view
        mWebView.loadUrl("https://demo.docusign.net/signing/emails/v2-c57fa52518ed420fbe4b523fd949bae5c85e118d0c3b4ea6b80f197a5e42a2f6efbe211c768446b9a0a2b0cd012b247c");
    }

    /**
     * Calls the Authentication Helper method to get user account information
     * @param accessToken the DocuSign OAuth token to use to make the API call.
     * @param error The error message, if any
     */
    private void retrieveLoginAccount(String accessToken, String error) {
        if (error != null) {
            handleError("", error);
        } else {
            SampleApp.getInstance().setAccessToken(accessToken);

            // Call helper function to retrieve User information
            loginLoader();
        }
    }

    /**
     * starts the Send-or-Sign activity using the selected DocuSign login account
     * @param loginAccount the DocuSign login account to be used for the rest of the app pages
     */
    public void displayLoginSignOrSendActivity(final LoginAccount loginAccount) {
        // store loginAccount to be shared across the application
        SampleApp.getInstance().setLoginAccount(loginAccount);

        // Open SignOrSendActivity
        startActivity(new Intent(this, SignOrSendActivity.class));
        finish();
    }

    protected void clearCookies() {
        CookieManager cookieManager = CookieManager.getInstance();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            cookieManager.removeAllCookies(null);
        } else {
            cookieManager.removeAllCookie();
        }
    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) {

        if (url != null && url.startsWith(Config.PARAMETER_CALLBACK)) {
            // handle DocuSign Oauth callback (after the user puts in the email and password)

            // parse the callback uri query parameters
            String data = Uri.parse(url).getQuery();
            if (data == null) {
                data = Uri.parse(url).getFragment();
            }
            HashMap<String, String> values = new HashMap<>();
            String[] parts = data.split("&");
            for (String part : parts) {
                String[] pieces = part.split("=");
                values.put(pieces[0], pieces.length == 1 ? "" : pieces[1]);
            }
            String code = values.get(Config.PARAMETER_CODE);
            String error = values.get(Config.PARAMETER_ERROR);
            String errorDescription = values.get(Config.PARAMETER_ERROR_DETAILS);

            if (error != null) {
                handleError(error, errorDescription);
            } else if (code != null) {
                handleCode(code);
            } else {
                handleError("AccessToken Error", "Network Error");
            }

            return true;
        } /*else if (url != null && url.contains(Config.PARAMETER_CHANGE_PASSWORD)) {
            // Handle DocuSign Oauth change-password
            //TODO Change Password
        } else {
            // Handle DocuSign Oauth forgot-password
            // TODO Forgot password
        }*/

        if (url != null && url.startsWith("http://")) {
            view.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            return true;
        } else {
            return false;
        }
    }

    private void handleCode(String authCode) {
        // Call AccessToken API
        Intent intent = new Intent(this, DocuSignOAuthService.class);
        intent.putExtra(DocuSignOAuthService.EXTRA_CODE, authCode);
        startService(intent);
    }

    private void handleError(String error, String errorDescription) {
        Toast.makeText(LoginActivity.this, error + "\n" + errorDescription, Toast.LENGTH_LONG).show();
    }

    private void loginLoader() {
        getSupportLoaderManager().initLoader(LOAD_LOGIN_ACCOUNT, null,
                new LoaderManager.LoaderCallbacks<List<LoginAccount>>() {

                    @Override
                    public Loader<List<LoginAccount>> onCreateLoader(int id, Bundle args) {
                        String accessToken = SampleApp.getInstance().getAccessToken();
                        // get the list of DocuSign accounts using an AsyncTaskLoader
                        return new LoginAccountLoader(LoginActivity.this, accessToken);
                    }

                    @Override
                    public void onLoadFinished(Loader<List<LoginAccount>> loader, List<LoginAccount> loginAccounts) {
                        hideLoading();
                        if (loginAccounts != null && loginAccounts.size() > 0) {
                            // a user can have multiple accounts. in that case we just get the first in the list
                            displayLoginSignOrSendActivity(loginAccounts.get(0));
                        } else {
                            handleError("this use is not part of any DocuSign acounts. Please contact your admin.", "");
                        }
                    }

                    @Override
                    public void onLoaderReset(Loader<List<LoginAccount>> loader) {
                        // no op //
                    }
                }).forceLoad();
    }

    @Override
    public void onInit(int i) {

    }

    static class LoginAccountLoader extends AsyncTaskLoader<List<LoginAccount>> {
        private String token;

        private LoginAccountLoader(Context context, String accessToken) {
            super(context);
            token = accessToken;
        }

        @Override
        public List<LoginAccount> loadInBackground() {
            List<LoginAccount> accounts = new ArrayList<>();
            try {
                // call the DocuSign login API through the helper method
                accounts = SampleApp.getInstance().getAuthHelper().loginWithOauthToken(token);
            } catch (Exception e) {
                Log.d(TAG, e.getMessage());
            }
            return accounts;
        }
    }

    /**
     * The web view for DocuSign OAuth flow
     */

    private class DSOAuthWebViewClient extends WebViewClient {

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            showLoading(getString(R.string.loading));
            Log.e("start", "start");
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            hideLoading();
            /** on Android N, if request is not called, Global login is not rendered for some reason
             * (i.e. if compiled on api 24 & run on a Android N device) **/
            view.requestLayout();
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return LoginActivity.this.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            hideLoading();
            try {
                handleError(getString(R.string.webView_page_load_error), description);
                if (errorCode == ERROR_HOST_LOOKUP || errorCode == ERROR_BAD_URL) {
                    handleError("", description);
                }
            } catch (Exception e) {
                handleError(getString(R.string.webView_page_load_error), e.getMessage());
            }
        }

        @Override
        public void onLoadResource(WebView  view, String  url){
            Log.e("onload", url);

            if(url.contains("https://demo.docusign.net/Signing/conversations/commenthistory/?ti="))
            {
                tts.stop();
                tts.speak("Your document is ready to sign, step 1, it says Dear Parents, I need your consent for the school trip that's coming up to Alcatraz Island, would you please sign this to confirm your child's attendance, Best, Peter Ma, 3rd grade teacher.  Press continue at lower right corner of the screen.", TextToSpeech.QUEUE_ADD, null);
                pageState = 1;
            }
            else if(pageState == 1 &&url.contains("https://demo.docusign.net/Signing/DocuSignXML.aspx?auditView="))
            {
                tts.stop();
                tts.speak("Excellent, Step 2, Sign your name at the center left of the screen", TextToSpeech.QUEUE_ADD, null);
                pageState = 2;
            }
            else if(pageState == 2 && url.contains("https://demo.docusign.net/Signing/tabs?ti="))
            {
                tts.stop();
                tts.speak("Signed, now Step 3, please press the finish button at the upper right corner of the screen to send back the copy", TextToSpeech.QUEUE_ADD, null);
                pageState = 3;
            }

            else if(pageState == 3 && url.contains("https://demo.docusign.net/Signing/envelope_actions/"))
            {
                tts.stop();
                tts.speak("You are all done, the document has been DocuSigned and sent back to Peter Ma, 3rd grade teacher", TextToSpeech.QUEUE_ADD, null);
                pageState = 4;
            }
        }
    }

    private void showLoading(String message) {
        if (mProgressDialog == null || !mProgressDialog.isShowing()) {
            mProgressDialog = ProgressDialog.show(this, null, message);
            mProgressDialog.setCanceledOnTouchOutside(false);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progress));
        }
    }

    private void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()
                && !isFinishing()) {
            mProgressDialog.dismiss();
        }
    }

}
