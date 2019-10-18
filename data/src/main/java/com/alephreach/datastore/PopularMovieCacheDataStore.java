package com.alephreach.datastore;

import com.alephreach.Repository.PopularMovieRepository;
import com.alephreach.model.PopularMovie;
import com.alephreach.repository.PopularMovieCache;
import io.reactivex.Completable;
import io.reactivex.Observable;

public class PopularMovieCacheDataStore implements PopularMovieRepository {

    private final PopularMovieCache mPopularMovieCache;

    public PopularMovieCacheDataStore(PopularMovieCache popularMovieCache) {
        mPopularMovieCache = popularMovieCache;
    }

    @Override
    public Observable<PopularMovie> getPopularMovie() {
        return mPopularMovieCache.getPopularMovie();
    }

    @Override
    public Completable bookmarkPopularMovie(String id) {
        return mPopularMovieCache.bookmarkPopularMovie(id);
    }

    @Override
    public Completable unbookmarkPopularMovie(String id) {
        return mPopularMovieCache.unbookmarkPopularMovie(id);
    }
}
