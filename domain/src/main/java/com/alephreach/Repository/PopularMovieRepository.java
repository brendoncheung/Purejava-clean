package com.alephreach.Repository;


import com.alephreach.model.PopularMovie;
import io.reactivex.Completable;
import io.reactivex.Observable;

public interface PopularMovieRepository {

    Observable<PopularMovie> getPopularMovie();
    Completable bookmarkPopularMovie(String id);
    Completable unbookmarkPopularMovie(String id);
}
