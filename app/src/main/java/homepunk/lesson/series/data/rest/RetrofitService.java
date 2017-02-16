package homepunk.lesson.series.data.rest;

import homepunk.lesson.series.model.Series;
import homepunk.lesson.series.model.SeriesResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {
        @GET("tv/{id}")
        Call<Series> loadTVSeriesDetails(@Path("id") int id,
                                         @Query("language") String language,
                                         @Query("api_key") String apiKey);

        @GET("tv/on_the_air")
        Call<SeriesResponse> loadOnAirSeries(@Query("page") int page,
                                             @Query("language") String language,
                                             @Query("api_key") String apiKey);

        @GET("tv/top_rated")
        Call<SeriesResponse> loadTopRatedSeries(@Query("page") int page,
                                                @Query("language") String language,
                                                @Query("api_key") String apiKey);

        @GET("search/tv")
        Call<SeriesResponse> loadSearchResults(@Query("page") int page,
                                               @Query("query") String query,
                                               @Query("language") String language,
                                               @Query("api_key") String apiKey);
}