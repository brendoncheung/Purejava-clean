package com.alephreach.repository;

import com.alephreach.model.PopularMovie;
import io.reactivex.Completable;
import io.reactivex.Observable;

public interface PopularMovieCache {

    Observable<PopularMovie> getPopularMovie();

    Completable bookmarkPopularMovie(String id);
    Completable unbookmarkPopularMovie(String id);
}
