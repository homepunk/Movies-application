package homepunk.lesson.first.network;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import homepunk.lesson.first.database.Constants;
import homepunk.lesson.first.model.TVSeries;

public class TVNetworkParser {
    private static final String KEY_RESULTS = "results";
    private static final String KEY_ORIGINAL_TITLE = "original_name";
    private static final String KEY_TITLE = "name";
    private static final String KEY_POSTER_PATH = "poster_path";
    private static final String KEY_BACKDROP_PATH = "backdrop_path";
    private static final String KEY_OVERVIEW = "overview";
    private static final String KEY_ID = "id";
    private static final String KEY_RATE = "vote_average";
    private static final String KEY_RELEASE_DATE = "release_date";

    public static List<TVSeries> getTVSeriesFromJson(String json) throws JSONException {
        JSONObject root = new JSONObject(json);
        JSONArray jsonFilmsArray = root.getJSONArray(KEY_RESULTS);

        List<TVSeries> filmsList = new ArrayList<>(Constants.FILM_COUNT);

        int length = root.length() < Constants.FILM_COUNT ? jsonFilmsArray.length() : Constants.FILM_COUNT;
        for (int i = 0; i < length; i++) {
            TVSeries film = new TVSeries();
            JSONObject jsonFilm = jsonFilmsArray.getJSONObject(i);
//            film.title = jsonFilm.getString(KEY_TITLE);
//            film.titleOriginal = jsonFilm.getString(KEY_ORIGINAL_TITLE);
            film.posterPath = jsonFilm.getString(KEY_POSTER_PATH);
//            film.overview = jsonFilm.getString(KEY_OVERVIEW);
            film.id = jsonFilm.getInt(KEY_ID);

            filmsList.add(film);
        }
        return filmsList;
    }

    public static List<TVSeries> getSearchedTVSeries(String json) throws JSONException {
        JSONObject root = new JSONObject(json);
        JSONArray jsonFilmsArray = root.getJSONArray(KEY_RESULTS);

        List<TVSeries> filmsList = new ArrayList<>(Constants.FILM_COUNT);

        int length = root.length() < Constants.FILM_COUNT ? jsonFilmsArray.length() : Constants.FILM_COUNT;
        for (int i = 0; i < length; i++) {
            TVSeries film = new TVSeries();
            JSONObject jsonFilm = jsonFilmsArray.getJSONObject(i);
//            film.title = jsonFilm.getString(KEY_TITLE);
//            film.titleOriginal = jsonFilm.getString(KEY_ORIGINAL_TITLE);
            film.posterPath = jsonFilm.getString(KEY_BACKDROP_PATH);
//            film.overview = jsonFilm.getString(KEY_OVERVIEW);
            film.id = jsonFilm.getInt(KEY_ID);

            filmsList.add(film);
        }
        return filmsList;
    }

    public static TVSeries getDetailedByJsonId(String json) throws JSONException {
        TVSeries tv = new TVSeries();
        JSONObject root = new JSONObject(json);
        tv.overview = root.getString(KEY_OVERVIEW);
        tv.id = root.getInt(KEY_ID);
        tv.posterPath = root.getString(KEY_POSTER_PATH);
        return tv;
    }

}