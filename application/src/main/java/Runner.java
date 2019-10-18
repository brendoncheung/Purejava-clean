import com.alephreach.model.Movie;
import com.alephreach.model.PopularMovie;
import com.alephreach.service.MovieApiService;
import com.alephreach.service.MovieApiServiceFactory;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.observers.BlockingObserver;
import io.reactivex.internal.subscribers.BlockingSubscriber;
import io.reactivex.schedulers.Schedulers;

public class Runner {

    public static void main(String[] args) {
        MovieApiService m = MovieApiServiceFactory.newInstance(true);

        //BlockingScheduler scheduler = new BlockingScheduler();

        Observer<PopularMovie> observer = new Observer<PopularMovie>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSub");

            }

            @Override
            public void onNext(PopularMovie popularMovie) {
                System.out.println("onNext");
                for (Movie movie : popularMovie.getPopularMovies()) {
                    System.out.println(movie.getOverview());
                    System.out.println("\n");
                }
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError");

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");

            }
        };

        System.out.println(m.toString());

        m.getPopularMovie(MovieApiServiceFactory.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(observer);
        try {
            Thread.currentThread().sleep(5000);
        } catch (Exception e) {

        }


//        scheduler.execute(() -> {
//
//            m.getPopularMovie(MovieApiServiceFactory.API_KEY)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(scheduler)
//                    .doAfterNext( () -> scheduler.shutdown())
//                    .subscribe(observer);
//        });

        System.out.println("\n");
    }

}
