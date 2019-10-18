package com.alephreach.model;

import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("poster_path")
    private String mPostPath;

    public String getPostPath() {
        return mPostPath;
    }

    public Boolean getAdult() {
        return isAdult;
    }

    public String getOverview() {
        return mOverview;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    @SerializedName("adult") // should be boolean
    private Boolean isAdult;

    @SerializedName("overview")
    private String mOverview;

    @SerializedName("release_id")
    private String mReleaseDate;
}
