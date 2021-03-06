package com.docusign.esign.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * A complex element that contains input information related to a recipient ID check. It can include the following information.\n\naddressInformationInput: Used to set recipient address information and consists of:\n\n* addressInformation: consists of six elements, with stree2 and zipPlus4 being optional. The elements are: street1, street2, city, state, zip, zipPlus4. The maximum length of each element is: street1/street2 = 150 characters, city = 50 characters, state = 2 characters, and zip/zipPlus4 = 20 characters.\n* displayLevelCode: Specifies the display level for the recipient. Values are: ReadOnly, Editable, or DoNotDisplay.\n* receiveInResponse: A Boolean element that specifies if the information needs to be returned in the response.\n\ndobInformationInput: Used to set recipient date of birth information and consists of:\n\n* dateOfBirth: Specifies the recipient\u2019s date, month and year of birth.\n* displayLevelCode: Specifies the display level for the recipient. Values are: ReadOnly, Editable, or DoNotDisplay.\n* receiveInResponse: A Boolean element that specifies if the information needs to be returned in the response.\n\nssn4InformationInput: Used to set the last four digits of the recipient\u2019s SSN information and consists of:\n\n* ssn4: Specifies the last four digits of the recipient\u2019s SSN.\n* displayLevelCode: Specifies the display level for the recipient. Values are: ReadOnly, Editable, or DoNotDisplay.\n* receiveInResponse: A Boolean element that specifies if the information needs to be returned in the response.\n\nssn9InformationInput: Used to set the recipient\u2019s SSN information. Note that the ssn9 information can never be returned in the response. The ssn9 input consists of: \n* ssn9: Specifies the recipient\u2019s SSN.\n* displayLevelCode: Specifies the display level for the recipient. Values are: ReadOnly, Editable, or DoNotDisplay.
 **/
@ApiModel(description = "A complex element that contains input information related to a recipient ID check. It can include the following information.\n\naddressInformationInput: Used to set recipient address information and consists of:\n\n* addressInformation: consists of six elements, with stree2 and zipPlus4 being optional. The elements are: street1, street2, city, state, zip, zipPlus4. The maximum length of each element is: street1/street2 = 150 characters, city = 50 characters, state = 2 characters, and zip/zipPlus4 = 20 characters.\n* displayLevelCode: Specifies the display level for the recipient. Values are: ReadOnly, Editable, or DoNotDisplay.\n* receiveInResponse: A Boolean element that specifies if the information needs to be returned in the response.\n\ndobInformationInput: Used to set recipient date of birth information and consists of:\n\n* dateOfBirth: Specifies the recipient\u2019s date, month and year of birth.\n* displayLevelCode: Specifies the display level for the recipient. Values are: ReadOnly, Editable, or DoNotDisplay.\n* receiveInResponse: A Boolean element that specifies if the information needs to be returned in the response.\n\nssn4InformationInput: Used to set the last four digits of the recipient\u2019s SSN information and consists of:\n\n* ssn4: Specifies the last four digits of the recipient\u2019s SSN.\n* displayLevelCode: Specifies the display level for the recipient. Values are: ReadOnly, Editable, or DoNotDisplay.\n* receiveInResponse: A Boolean element that specifies if the information needs to be returned in the response.\n\nssn9InformationInput: Used to set the recipient\u2019s SSN information. Note that the ssn9 information can never be returned in the response. The ssn9 input consists of: \n* ssn9: Specifies the recipient\u2019s SSN.\n* displayLevelCode: Specifies the display level for the recipient. Values are: ReadOnly, Editable, or DoNotDisplay.")
public class IdCheckInformationInput implements Serializable {

    @SerializedName("addressInformationInput")
    private AddressInformationInput addressInformationInput = null;

    @SerializedName("dobInformationInput")
    private DobInformationInput dobInformationInput = null;

    @SerializedName("ssn4InformationInput")
    private Ssn4InformationInput ssn4InformationInput = null;

    @SerializedName("ssn9InformationInput")
    private Ssn9InformationInput ssn9InformationInput = null;


    /**
     **/
    @ApiModelProperty(value = "")
    public AddressInformationInput getAddressInformationInput() {
        return addressInformationInput;
    }

    public void setAddressInformationInput(AddressInformationInput addressInformationInput) {
        this.addressInformationInput = addressInformationInput;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public DobInformationInput getDobInformationInput() {
        return dobInformationInput;
    }

    public void setDobInformationInput(DobInformationInput dobInformationInput) {
        this.dobInformationInput = dobInformationInput;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public Ssn4InformationInput getSsn4InformationInput() {
        return ssn4InformationInput;
    }

    public void setSsn4InformationInput(Ssn4InformationInput ssn4InformationInput) {
        this.ssn4InformationInput = ssn4InformationInput;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public Ssn9InformationInput getSsn9InformationInput() {
        return ssn9InformationInput;
    }

    public void setSsn9InformationInput(Ssn9InformationInput ssn9InformationInput) {
        this.ssn9InformationInput = ssn9InformationInput;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IdCheckInformationInput idCheckInformationInput = (IdCheckInformationInput) o;
        return Objects.equals(addressInformationInput, idCheckInformationInput.addressInformationInput) &&
                Objects.equals(dobInformationInput, idCheckInformationInput.dobInformationInput) &&
                Objects.equals(ssn4InformationInput, idCheckInformationInput.ssn4InformationInput) &&
                Objects.equals(ssn9InformationInput, idCheckInformationInput.ssn9InformationInput);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressInformationInput, dobInformationInput, ssn4InformationInput, ssn9InformationInput);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class IdCheckInformationInput {\n");

        sb.append("    addressInformationInput: ").append(toIndentedString(addressInformationInput)).append("\n");
        sb.append("    dobInformationInput: ").append(toIndentedString(dobInformationInput)).append("\n");
        sb.append("    ssn4InformationInput: ").append(toIndentedString(ssn4InformationInput)).append("\n");
        sb.append("    ssn9InformationInput: ").append(toIndentedString(ssn9InformationInput)).append("\n");
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
