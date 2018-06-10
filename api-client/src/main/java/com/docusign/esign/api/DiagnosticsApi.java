package com.docusign.esign.api;

import com.docusign.esign.model.ApiRequestLogsResult;
import com.docusign.esign.model.DiagnosticsSettingsInformation;
import com.docusign.esign.model.ResourceInformation;
import com.docusign.esign.model.ServiceInformation;

import okhttp3.ResponseBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DiagnosticsApi {

    /**
     * Deletes the request log files.
     * Deletes the request log files.
     *
     * @return Call<Void>
     */

    @DELETE("v2/diagnostics/request_logs")
    Call<Void> deleteRequestLogs();


    /**
     * Gets a request logging log file.
     * Retrieves information for a single log entry.\n\n**Request**\nThe `requestLogfId` property can be retrieved by getting the list of log entries. The Content-Transfer-Encoding header can be set to base64 to retrieve the API request/response as base 64 string. Otherwise the bytes of the request/response are returned.\n\n**Response**\nIf the Content-Transfer-Encoding header was set to base64, the log is returned as a base64 string.
     *
     * @param requestLogId (required)
     * @return Call<ResponseBody>
     */

    @GET("v2/diagnostics/request_logs/{requestLogId}")
    Call<ResponseBody> getRequestLog(
            @Path("requestLogId") String requestLogId
    );


    /**
     * Gets the API request logging settings.
     * Retrieves the current API request logging setting for the user and remaining log entries.\n\n**Response**\nThe response includes the current API request logging setting for the user, along with the maximum log entries and remaining log entries.
     *
     * @return Call<DiagnosticsSettingsInformation>
     */

    @GET("v2/diagnostics/settings")
    Call<DiagnosticsSettingsInformation> getRequestLogSettings();


    /**
     * Lists resources for REST version specified
     * Retrieves the base resources available for the DocuSign REST APIs.\n\nYou do not need an integrator key to view the REST API versions and resources.\n\nExample: https://demo.docusign.net/restapi/v2 lists all of the base resources available in version 2 of the REST API on the DocuSign Demo system.\n\nTo view descriptions and samples of the service operations for all versions, remove the version number and add /help to the URL.\n\nExample: https://demo.docusign.net/restapi/help lists the REST API operations on the DocuSign Demo system with XML and JSON request and response samples.
     *
     * @return Call<ResourceInformation>
     */

    @GET("v2")
    Call<ResourceInformation> getResources();


    /**
     * Retrieves the available REST API versions.
     * Retrieves the available REST API versions.\n\nDocuSign Production system: https://www.docusign.net/restapi/service_information\nDocuSign Demo system: https://demo.docusign.net/restapi/service_information\n\nYou do not need an integrator key to view the REST API versions and resources.
     *
     * @return Call<ServiceInformation>
     */

    @GET("service_information")
    Call<ServiceInformation> getService();


    /**
     * Gets the API request logging log files.
     * Retrieves a list of log entries as a JSON or xml object or as a zip file containing the entries.\n\nIf the Accept header is set to application/zip, the response is a zip file containing individual text files, each representing an API request.\n\nIf the Accept header is set to `application/json` or `application/xml`, the response returns list of log entries in either JSON or XML. An example JSON response body is shown below.
     *
     * @param encoding (optional)
     * @return Call<ApiRequestLogsResult>
     */

    @GET("v2/diagnostics/request_logs")
    Call<ApiRequestLogsResult> listRequestLogs(
            @Query("encoding") String encoding
    );


    /**
     * Enables or disables API request logging for troubleshooting.
     * Enables or disables API request logging for troubleshooting.\n\nWhen enabled (`apiRequestLogging` is set to true), REST API requests and responses for the user are added to a log. A log can have up to 50 requests/responses and the current number of log entries can be determined by getting the settings. Logging is automatically disabled when the log limit of 50 is reached.\n\nYou can call [ML:GetRequestLog] or [ML:GetRequestLogs] to download the log files (individually or as a zip file). Call [ML:DeleteRequestLogs] to clear the log by deleting current entries.\n\nPrivate information, such as passwords and integrator key information, which is normally located in the call header is omitted from the request/response log.\n\n###### Note: API request logging only captures requests from the authenticated user. Any call that does not authenticate the user and resolve a userId isn&#39;t logged. Meaning that login_information, NewAccounts, or other distributor-credential calls are not logged.\n
     *
     * @param diagnosticsSettingsInformation (optional)
     * @return Call<DiagnosticsSettingsInformation>
     */

    @PUT("v2/diagnostics/settings")
    Call<DiagnosticsSettingsInformation> updateRequestLogSettings(
            @Body DiagnosticsSettingsInformation diagnosticsSettingsInformation
    );


}
