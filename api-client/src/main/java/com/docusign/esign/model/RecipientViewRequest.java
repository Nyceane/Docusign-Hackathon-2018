package com.docusign.esign.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;


public class RecipientViewRequest implements Serializable {

    @SerializedName("assertionId")
    private String assertionId = null;

    @SerializedName("authenticationInstant")
    private String authenticationInstant = null;

    @SerializedName("authenticationMethod")
    private String authenticationMethod = null;

    @SerializedName("clientUserId")
    private String clientUserId = null;

    @SerializedName("email")
    private String email = null;

    @SerializedName("pingFrequency")
    private String pingFrequency = null;

    @SerializedName("pingUrl")
    private String pingUrl = null;

    @SerializedName("recipientId")
    private String recipientId = null;

    @SerializedName("returnUrl")
    private String returnUrl = null;

    @SerializedName("securityDomain")
    private String securityDomain = null;

    @SerializedName("userId")
    private String userId = null;

    @SerializedName("userName")
    private String userName = null;

    @SerializedName("xFrameOptions")
    private String xFrameOptions = null;

    @SerializedName("xFrameOptionsAllowFromUrl")
    private String xFrameOptionsAllowFromUrl = null;


    /**
     * A unique identifier of the authentication event executed by the client application.
     **/
    @ApiModelProperty(value = "A unique identifier of the authentication event executed by the client application.")
    public String getAssertionId() {
        return assertionId;
    }

    public void setAssertionId(String assertionId) {
        this.assertionId = assertionId;
    }


    /**
     * A sender generated value that indicates the date/time that the signer was authenticated.
     **/
    @ApiModelProperty(value = "A sender generated value that indicates the date/time that the signer was authenticated.")
    public String getAuthenticationInstant() {
        return authenticationInstant;
    }

    public void setAuthenticationInstant(String authenticationInstant) {
        this.authenticationInstant = authenticationInstant;
    }


    /**
     * A sender created value that indicates the convention used to authenticate the signer. This information is included in the Certificate of Completion.
     **/
    @ApiModelProperty(value = "A sender created value that indicates the convention used to authenticate the signer. This information is included in the Certificate of Completion.")
    public String getAuthenticationMethod() {
        return authenticationMethod;
    }

    public void setAuthenticationMethod(String authenticationMethod) {
        this.authenticationMethod = authenticationMethod;
    }


    /**
     * A sender created value that shows the recipient is embedded (captive). \n\nMaximum length: 100 characters.
     **/
    @ApiModelProperty(value = "A sender created value that shows the recipient is embedded (captive). \n\nMaximum length: 100 characters.")
    public String getClientUserId() {
        return clientUserId;
    }

    public void setClientUserId(String clientUserId) {
        this.clientUserId = clientUserId;
    }


    /**
     * Specifies the email of the recipient. You can use either email and userName or userId to identify the recipient.
     **/
    @ApiModelProperty(value = "Specifies the email of the recipient. You can use either email and userName or userId to identify the recipient.")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Only used if pingUrl is specified. This is the interval, in seconds, between pings on the pingUrl.  The default is 300 seconds. Valid values are 60-1200 seconds.
     **/
    @ApiModelProperty(value = "Only used if pingUrl is specified. This is the interval, in seconds, between pings on the pingUrl.  The default is 300 seconds. Valid values are 60-1200 seconds.")
    public String getPingFrequency() {
        return pingFrequency;
    }

    public void setPingFrequency(String pingFrequency) {
        this.pingFrequency = pingFrequency;
    }


    /**
     * A client Url to be pinged by the DocuSign Signing experience to indicate to the client that Signing is active. An HTTP Get is executed against the client. The response from the client is ignored. The intent is for the client to reset it's session timer when the request is received.
     **/
    @ApiModelProperty(value = "A client Url to be pinged by the DocuSign Signing experience to indicate to the client that Signing is active. An HTTP Get is executed against the client. The response from the client is ignored. The intent is for the client to reset it's session timer when the request is received.")
    public String getPingUrl() {
        return pingUrl;
    }

    public void setPingUrl(String pingUrl) {
        this.pingUrl = pingUrl;
    }


    /**
     * Unique for the recipient. It is used by the tab element to indicate which recipient is to sign the Document.
     **/
    @ApiModelProperty(value = "Unique for the recipient. It is used by the tab element to indicate which recipient is to sign the Document.")
    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }


    /**
     * The url the recipient is redirected to after the signing session has ended. DocuSign redirects to the url and includes an event parameter that can be used by your application. Possible event parameter values: \n\n* cancel (recipient canceled the signing operation)\n* decline (recipient declined to sign)\n* exception (an exception occurred)\n* fax_pending (recipient has a fax pending)\n* session_timeout (session timed out)\n* signing_complete (signer completed the signing ceremony)\n* ttl_expired (the TTL, time to live, timer expired)\n* viewing_complete (recipient completed viewing the envelope)\n\n###### Note: Include https:// in the URL or the redirect might not succeed on some browsers.
     **/
    @ApiModelProperty(value = "The url the recipient is redirected to after the signing session has ended. DocuSign redirects to the url and includes an event parameter that can be used by your application. Possible event parameter values: \n\n* cancel (recipient canceled the signing operation)\n* decline (recipient declined to sign)\n* exception (an exception occurred)\n* fax_pending (recipient has a fax pending)\n* session_timeout (session timed out)\n* signing_complete (signer completed the signing ceremony)\n* ttl_expired (the TTL, time to live, timer expired)\n* viewing_complete (recipient completed viewing the envelope)\n\n###### Note: Include https:// in the URL or the redirect might not succeed on some browsers. ")
    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }


    /**
     * The domain in which the user authenticated.
     **/
    @ApiModelProperty(value = "The domain in which the user authenticated.")
    public String getSecurityDomain() {
        return securityDomain;
    }

    public void setSecurityDomain(String securityDomain) {
        this.securityDomain = securityDomain;
    }


    /**
     * Specifies the user ID of the recipient. You can use with user ID or email and user name to identify the recipient. If user ID is used and a client user ID is provided, the value in the `userId` property must match a recipient ID (which can be retrieved with a GET recipients call) for the envelope. If a user ID is used and a clientUser ID is not provided, the user ID match the user ID of the authenticating user.
     **/
    @ApiModelProperty(value = "Specifies the user ID of the recipient. You can use with user ID or email and user name to identify the recipient. If user ID is used and a client user ID is provided, the value in the `userId` property must match a recipient ID (which can be retrieved with a GET recipients call) for the envelope. If a user ID is used and a clientUser ID is not provided, the user ID match the user ID of the authenticating user.")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    /**
     * Specifies the username of the recipient. You can use either email and userName or userId to identify the recipient.
     **/
    @ApiModelProperty(value = "Specifies the username of the recipient. You can use either email and userName or userId to identify the recipient.")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    /**
     *
     **/
    @ApiModelProperty(value = "")
    public String getXFrameOptions() {
        return xFrameOptions;
    }

    public void setXFrameOptions(String xFrameOptions) {
        this.xFrameOptions = xFrameOptions;
    }


    /**
     *
     **/
    @ApiModelProperty(value = "")
    public String getXFrameOptionsAllowFromUrl() {
        return xFrameOptionsAllowFromUrl;
    }

    public void setXFrameOptionsAllowFromUrl(String xFrameOptionsAllowFromUrl) {
        this.xFrameOptionsAllowFromUrl = xFrameOptionsAllowFromUrl;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RecipientViewRequest recipientViewRequest = (RecipientViewRequest) o;
        return Objects.equals(assertionId, recipientViewRequest.assertionId) &&
                Objects.equals(authenticationInstant, recipientViewRequest.authenticationInstant) &&
                Objects.equals(authenticationMethod, recipientViewRequest.authenticationMethod) &&
                Objects.equals(clientUserId, recipientViewRequest.clientUserId) &&
                Objects.equals(email, recipientViewRequest.email) &&
                Objects.equals(pingFrequency, recipientViewRequest.pingFrequency) &&
                Objects.equals(pingUrl, recipientViewRequest.pingUrl) &&
                Objects.equals(recipientId, recipientViewRequest.recipientId) &&
                Objects.equals(returnUrl, recipientViewRequest.returnUrl) &&
                Objects.equals(securityDomain, recipientViewRequest.securityDomain) &&
                Objects.equals(userId, recipientViewRequest.userId) &&
                Objects.equals(userName, recipientViewRequest.userName) &&
                Objects.equals(xFrameOptions, recipientViewRequest.xFrameOptions) &&
                Objects.equals(xFrameOptionsAllowFromUrl, recipientViewRequest.xFrameOptionsAllowFromUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assertionId, authenticationInstant, authenticationMethod, clientUserId, email, pingFrequency, pingUrl, recipientId, returnUrl, securityDomain, userId, userName, xFrameOptions, xFrameOptionsAllowFromUrl);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RecipientViewRequest {\n");

        sb.append("    assertionId: ").append(toIndentedString(assertionId)).append("\n");
        sb.append("    authenticationInstant: ").append(toIndentedString(authenticationInstant)).append("\n");
        sb.append("    authenticationMethod: ").append(toIndentedString(authenticationMethod)).append("\n");
        sb.append("    clientUserId: ").append(toIndentedString(clientUserId)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    pingFrequency: ").append(toIndentedString(pingFrequency)).append("\n");
        sb.append("    pingUrl: ").append(toIndentedString(pingUrl)).append("\n");
        sb.append("    recipientId: ").append(toIndentedString(recipientId)).append("\n");
        sb.append("    returnUrl: ").append(toIndentedString(returnUrl)).append("\n");
        sb.append("    securityDomain: ").append(toIndentedString(securityDomain)).append("\n");
        sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
        sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
        sb.append("    xFrameOptions: ").append(toIndentedString(xFrameOptions)).append("\n");
        sb.append("    xFrameOptionsAllowFromUrl: ").append(toIndentedString(xFrameOptionsAllowFromUrl)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
