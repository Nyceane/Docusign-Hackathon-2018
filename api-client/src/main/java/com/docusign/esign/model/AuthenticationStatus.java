package com.docusign.esign.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * Contains information about the authentication status.
 **/
@ApiModel(description = "Contains information about the authentication status.")
public class AuthenticationStatus implements Serializable {

    @SerializedName("accessCodeResult")
    private EventResult accessCodeResult = null;

    @SerializedName("ageVerifyResult")
    private EventResult ageVerifyResult = null;

    @SerializedName("anySocialIDResult")
    private EventResult anySocialIDResult = null;

    @SerializedName("facebookResult")
    private EventResult facebookResult = null;

    @SerializedName("googleResult")
    private EventResult googleResult = null;

    @SerializedName("idLookupResult")
    private EventResult idLookupResult = null;

    @SerializedName("idQuestionsResult")
    private EventResult idQuestionsResult = null;

    @SerializedName("linkedinResult")
    private EventResult linkedinResult = null;

    @SerializedName("liveIDResult")
    private EventResult liveIDResult = null;

    @SerializedName("ofacResult")
    private EventResult ofacResult = null;

    @SerializedName("openIDResult")
    private EventResult openIDResult = null;

    @SerializedName("phoneAuthResult")
    private EventResult phoneAuthResult = null;

    @SerializedName("salesforceResult")
    private EventResult salesforceResult = null;

    @SerializedName("smsAuthResult")
    private EventResult smsAuthResult = null;

    @SerializedName("sTANPinResult")
    private EventResult sTANPinResult = null;

    @SerializedName("twitterResult")
    private EventResult twitterResult = null;

    @SerializedName("yahooResult")
    private EventResult yahooResult = null;


    /**
     **/
    @ApiModelProperty(value = "")
    public EventResult getAccessCodeResult() {
        return accessCodeResult;
    }

    public void setAccessCodeResult(EventResult accessCodeResult) {
        this.accessCodeResult = accessCodeResult;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public EventResult getAgeVerifyResult() {
        return ageVerifyResult;
    }

    public void setAgeVerifyResult(EventResult ageVerifyResult) {
        this.ageVerifyResult = ageVerifyResult;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public EventResult getAnySocialIDResult() {
        return anySocialIDResult;
    }

    public void setAnySocialIDResult(EventResult anySocialIDResult) {
        this.anySocialIDResult = anySocialIDResult;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public EventResult getFacebookResult() {
        return facebookResult;
    }

    public void setFacebookResult(EventResult facebookResult) {
        this.facebookResult = facebookResult;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public EventResult getGoogleResult() {
        return googleResult;
    }

    public void setGoogleResult(EventResult googleResult) {
        this.googleResult = googleResult;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public EventResult getIdLookupResult() {
        return idLookupResult;
    }

    public void setIdLookupResult(EventResult idLookupResult) {
        this.idLookupResult = idLookupResult;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public EventResult getIdQuestionsResult() {
        return idQuestionsResult;
    }

    public void setIdQuestionsResult(EventResult idQuestionsResult) {
        this.idQuestionsResult = idQuestionsResult;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public EventResult getLinkedinResult() {
        return linkedinResult;
    }

    public void setLinkedinResult(EventResult linkedinResult) {
        this.linkedinResult = linkedinResult;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public EventResult getLiveIDResult() {
        return liveIDResult;
    }

    public void setLiveIDResult(EventResult liveIDResult) {
        this.liveIDResult = liveIDResult;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public EventResult getOfacResult() {
        return ofacResult;
    }

    public void setOfacResult(EventResult ofacResult) {
        this.ofacResult = ofacResult;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public EventResult getOpenIDResult() {
        return openIDResult;
    }

    public void setOpenIDResult(EventResult openIDResult) {
        this.openIDResult = openIDResult;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public EventResult getPhoneAuthResult() {
        return phoneAuthResult;
    }

    public void setPhoneAuthResult(EventResult phoneAuthResult) {
        this.phoneAuthResult = phoneAuthResult;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public EventResult getSalesforceResult() {
        return salesforceResult;
    }

    public void setSalesforceResult(EventResult salesforceResult) {
        this.salesforceResult = salesforceResult;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public EventResult getSmsAuthResult() {
        return smsAuthResult;
    }

    public void setSmsAuthResult(EventResult smsAuthResult) {
        this.smsAuthResult = smsAuthResult;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public EventResult getSTANPinResult() {
        return sTANPinResult;
    }

    public void setSTANPinResult(EventResult sTANPinResult) {
        this.sTANPinResult = sTANPinResult;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public EventResult getTwitterResult() {
        return twitterResult;
    }

    public void setTwitterResult(EventResult twitterResult) {
        this.twitterResult = twitterResult;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public EventResult getYahooResult() {
        return yahooResult;
    }

    public void setYahooResult(EventResult yahooResult) {
        this.yahooResult = yahooResult;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AuthenticationStatus authenticationStatus = (AuthenticationStatus) o;
        return Objects.equals(accessCodeResult, authenticationStatus.accessCodeResult) &&
                Objects.equals(ageVerifyResult, authenticationStatus.ageVerifyResult) &&
                Objects.equals(anySocialIDResult, authenticationStatus.anySocialIDResult) &&
                Objects.equals(facebookResult, authenticationStatus.facebookResult) &&
                Objects.equals(googleResult, authenticationStatus.googleResult) &&
                Objects.equals(idLookupResult, authenticationStatus.idLookupResult) &&
                Objects.equals(idQuestionsResult, authenticationStatus.idQuestionsResult) &&
                Objects.equals(linkedinResult, authenticationStatus.linkedinResult) &&
                Objects.equals(liveIDResult, authenticationStatus.liveIDResult) &&
                Objects.equals(ofacResult, authenticationStatus.ofacResult) &&
                Objects.equals(openIDResult, authenticationStatus.openIDResult) &&
                Objects.equals(phoneAuthResult, authenticationStatus.phoneAuthResult) &&
                Objects.equals(salesforceResult, authenticationStatus.salesforceResult) &&
                Objects.equals(smsAuthResult, authenticationStatus.smsAuthResult) &&
                Objects.equals(sTANPinResult, authenticationStatus.sTANPinResult) &&
                Objects.equals(twitterResult, authenticationStatus.twitterResult) &&
                Objects.equals(yahooResult, authenticationStatus.yahooResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessCodeResult, ageVerifyResult, anySocialIDResult, facebookResult, googleResult, idLookupResult, idQuestionsResult, linkedinResult, liveIDResult, ofacResult, openIDResult, phoneAuthResult, salesforceResult, smsAuthResult, sTANPinResult, twitterResult, yahooResult);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AuthenticationStatus {\n");

        sb.append("    accessCodeResult: ").append(toIndentedString(accessCodeResult)).append("\n");
        sb.append("    ageVerifyResult: ").append(toIndentedString(ageVerifyResult)).append("\n");
        sb.append("    anySocialIDResult: ").append(toIndentedString(anySocialIDResult)).append("\n");
        sb.append("    facebookResult: ").append(toIndentedString(facebookResult)).append("\n");
        sb.append("    googleResult: ").append(toIndentedString(googleResult)).append("\n");
        sb.append("    idLookupResult: ").append(toIndentedString(idLookupResult)).append("\n");
        sb.append("    idQuestionsResult: ").append(toIndentedString(idQuestionsResult)).append("\n");
        sb.append("    linkedinResult: ").append(toIndentedString(linkedinResult)).append("\n");
        sb.append("    liveIDResult: ").append(toIndentedString(liveIDResult)).append("\n");
        sb.append("    ofacResult: ").append(toIndentedString(ofacResult)).append("\n");
        sb.append("    openIDResult: ").append(toIndentedString(openIDResult)).append("\n");
        sb.append("    phoneAuthResult: ").append(toIndentedString(phoneAuthResult)).append("\n");
        sb.append("    salesforceResult: ").append(toIndentedString(salesforceResult)).append("\n");
        sb.append("    smsAuthResult: ").append(toIndentedString(smsAuthResult)).append("\n");
        sb.append("    sTANPinResult: ").append(toIndentedString(sTANPinResult)).append("\n");
        sb.append("    twitterResult: ").append(toIndentedString(twitterResult)).append("\n");
        sb.append("    yahooResult: ").append(toIndentedString(yahooResult)).append("\n");
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
