package com.alephreach.repository;

import com.alephreach.Repository.PopularMovieRepository;
import com.alephreach.model.PopularMovie;
import io.reactivex.Observable;

public interface PopularMovieRemote  {

    Observable<PopularMovie> getPopularMovie();
}
