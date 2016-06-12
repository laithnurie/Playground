package com.laithlab.playground.RetroExample.retrofit;


import com.google.gson.annotations.SerializedName;

public class SearchResponse {

    private String status;

    @SerializedName("data")
    private SearchResultItem[] data;

    private String success;

    public String getStatus() {
        return status;
    }

    public SearchResultItem[] getData() {
        return data;
    }

    public String getSuccess() {
        return success;
    }

    @Override
    public String toString() {
        return "ClassPojo [status = " + status + ", data = " + data + ", success = " + success + "]";
    }
}
