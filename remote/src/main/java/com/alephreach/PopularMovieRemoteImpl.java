package com.alephreach;

import com.alephreach.model.PopularMovie;
import com.alephreach.repository.PopularMovieRemote;
import com.alephreach.service.MovieApiService;
import com.alephreach.service.MovieApiServiceFactory;
import io.reactivex.Observable;

public class PopularMovieRemoteImpl implements PopularMovieRemote {

    private final MovieApiService mMovieApiService;

    public PopularMovieRemoteImpl(MovieApiService service) {
        mMovieApiService = service;
    }

    @Override
    public Observable<PopularMovie> getPopularMovie() {
        return mMovieApiService.getPopularMovie(MovieApiServiceFactory.API_KEY);
    }
}

