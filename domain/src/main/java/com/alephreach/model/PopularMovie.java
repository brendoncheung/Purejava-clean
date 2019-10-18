package com.alephreach.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PopularMovie {

    @SerializedName("page")
    private int mPage;

    @SerializedName("results")
    private List<Movie> mPopularMovies;

    public int getPage() {
        return mPage;
    }

    public List<Movie> getPopularMovies() {
        return mPopularMovies;
    }
}
