package com.docusign.esign.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;


public class Folder implements Serializable {

    @SerializedName("errorDetails")
    private ErrorDetails errorDetails = null;

    @SerializedName("filter")
    private Filter filter = null;

    @SerializedName("folderId")
    private String folderId = null;

    @SerializedName("folders")
    private java.util.List<Folder> folders = new java.util.ArrayList<Folder>();

    @SerializedName("name")
    private String name = null;

    @SerializedName("ownerEmail")
    private String ownerEmail = null;

    @SerializedName("ownerUserId")
    private String ownerUserId = null;

    @SerializedName("ownerUserName")
    private String ownerUserName = null;

    @SerializedName("parentFolderId")
    private String parentFolderId = null;

    @SerializedName("parentFolderUri")
    private String parentFolderUri = null;

    @SerializedName("type")
    private String type = null;

    @SerializedName("uri")
    private String uri = null;


    /**
     **/
    @ApiModelProperty(value = "")
    public ErrorDetails getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(ErrorDetails errorDetails) {
        this.errorDetails = errorDetails;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }


    /**
     *
     **/
    @ApiModelProperty(value = "")
    public String getFolderId() {
        return folderId;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }


    /**
     * A collection of folder objects returned in a response.
     **/
    @ApiModelProperty(value = "A collection of folder objects returned in a response.")
    public java.util.List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(java.util.List<Folder> folders) {
        this.folders = folders;
    }


    /**
     *
     **/
    @ApiModelProperty(value = "")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /**
     *
     **/
    @ApiModelProperty(value = "")
    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }


    /**
     *
     **/
    @ApiModelProperty(value = "")
    public String getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(String ownerUserId) {
        this.ownerUserId = ownerUserId;
    }


    /**
     *
     **/
    @ApiModelProperty(value = "")
    public String getOwnerUserName() {
        return ownerUserName;
    }

    public void setOwnerUserName(String ownerUserName) {
        this.ownerUserName = ownerUserName;
    }


    /**
     *
     **/
    @ApiModelProperty(value = "")
    public String getParentFolderId() {
        return parentFolderId;
    }

    public void setParentFolderId(String parentFolderId) {
        this.parentFolderId = parentFolderId;
    }


    /**
     *
     **/
    @ApiModelProperty(value = "")
    public String getParentFolderUri() {
        return parentFolderUri;
    }

    public void setParentFolderUri(String parentFolderUri) {
        this.parentFolderUri = parentFolderUri;
    }


    /**
     *
     **/
    @ApiModelProperty(value = "")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    /**
     *
     **/
    @ApiModelProperty(value = "")
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Folder folder = (Folder) o;
        return Objects.equals(errorDetails, folder.errorDetails) &&
                Objects.equals(filter, folder.filter) &&
                Objects.equals(folderId, folder.folderId) &&
                Objects.equals(folders, folder.folders) &&
                Objects.equals(name, folder.name) &&
                Objects.equals(ownerEmail, folder.ownerEmail) &&
                Objects.equals(ownerUserId, folder.ownerUserId) &&
                Objects.equals(ownerUserName, folder.ownerUserName) &&
                Objects.equals(parentFolderId, folder.parentFolderId) &&
                Objects.equals(parentFolderUri, folder.parentFolderUri) &&
                Objects.equals(type, folder.type) &&
                Objects.equals(uri, folder.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorDetails, filter, folderId, folders, name, ownerEmail, ownerUserId, ownerUserName, parentFolderId, parentFolderUri, type, uri);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Folder {\n");

        sb.append("    errorDetails: ").append(toIndentedString(errorDetails)).append("\n");
        sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
        sb.append("    folderId: ").append(toIndentedString(folderId)).append("\n");
        sb.append("    folders: ").append(toIndentedString(folders)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    ownerEmail: ").append(toIndentedString(ownerEmail)).append("\n");
        sb.append("    ownerUserId: ").append(toIndentedString(ownerUserId)).append("\n");
        sb.append("    ownerUserName: ").append(toIndentedString(ownerUserName)).append("\n");
        sb.append("    parentFolderId: ").append(toIndentedString(parentFolderId)).append("\n");
        sb.append("    parentFolderUri: ").append(toIndentedString(parentFolderUri)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
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
