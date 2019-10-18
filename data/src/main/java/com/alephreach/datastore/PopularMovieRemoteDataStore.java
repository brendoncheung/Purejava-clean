package com.alephreach.datastore;

import com.alephreach.Repository.PopularMovieRepository;
import com.alephreach.model.PopularMovie;
import com.alephreach.repository.PopularMovieRemote;
import io.reactivex.Completable;
import io.reactivex.Observable;

import javax.naming.OperationNotSupportedException;

public class PopularMovieRemoteDataStore implements PopularMovieRepository {

    private PopularMovieRemote mPopularMovieRemote;

    public PopularMovieRemoteDataStore(PopularMovieRemote popularMovieRemote) {
        mPopularMovieRemote = popularMovieRemote;
    }

    @Override
    public Observable<PopularMovie> getPopularMovie() {
        return mPopularMovieRemote.getPopularMovie();
    }

    @Override
    public Completable bookmarkPopularMovie(String id) {
        throw new UnsupportedOperationException("bookmarking feature not supported");
    }

    @Override
    public Completable unbookmarkPopularMovie(String id) {
        throw new UnsupportedOperationException("bookmarking feature not supported");
    }


}
