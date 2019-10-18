package com.alephreach.service;

import com.alephreach.model.PopularMovie;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {

    @GET("/3/movie/popular")
    Observable<PopularMovie> getPopularMovie(@Query("api_key") String key);

}
