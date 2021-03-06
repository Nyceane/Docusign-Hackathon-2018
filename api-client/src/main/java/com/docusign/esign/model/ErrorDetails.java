package com.docusign.esign.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * This object describes errors that occur. It is only valid for responses, and ignored in requests.
 **/
@ApiModel(description = "This object describes errors that occur. It is only valid for responses, and ignored in requests.")
public class ErrorDetails implements Serializable {

    @SerializedName("errorCode")
    private String errorCode = null;

    @SerializedName("message")
    private String message = null;


    /**
     * An error code associated with the error.
     **/
    @ApiModelProperty(value = "An error code associated with the error.")
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }


    /**
     * A short error message.
     **/
    @ApiModelProperty(value = "A short error message.")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ErrorDetails errorDetails = (ErrorDetails) o;
        return Objects.equals(errorCode, errorDetails.errorCode) &&
                Objects.equals(message, errorDetails.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorCode, message);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ErrorDetails {\n");

        sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
