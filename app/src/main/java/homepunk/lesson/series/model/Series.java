package homepunk.lesson.series.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(database = SeriesDatabase.class)
public class Series extends BaseModel implements Serializable, Comparable<Series>{
    public static final int GRID_TYPE = 0;
    public static final int BACKDROP_TYPE = 1;
    public static final int NULL_TYPE = -1;

    public static final String WIDTH_154 = "w154";
    public static final String WIDTH_342 = "w342";
    public static final String WIDTH_500 = "w500";
    public static final String WIDTH_780 = "w780";

    private static final String URL_IMAGE_TMDB_DEFAULT = "http://image.tmdb.org/t/p/";

    public static final String KEY_TITLE = "original_name";
    public static final String KEY_POSTER_PATH = "poster_path";
    public static final String KEY_BACKDROP_PATH = "backdrop_path";
    public static final String KEY_OVERVIEW = "overview";
    public static final String KEY_RATE = "vote_average";
    public static final String KEY_RELEASE_DATE = "release_date";
    public static final String KEY_SERIES_ID = "SeriesId";
    public static final String KEY_ID = "id";
    public static final String TABLE_TVSERIES = "tvseries";
    public static final String KEY_GENRE_IDS = "genre_ids";
    public static final String KEY_ORIGINAL_COUNTRY = "origin_country";
    public static final String KEY_RESULTS = "results";

    public static String[] projection = {
            KEY_ID,
            KEY_POSTER_PATH
    };

    @SerializedName(KEY_ID)
    @PrimaryKey
    @Expose
    private int id;

    @SerializedName(KEY_TITLE)
    @Column
    @Expose
    private String title;

    @SerializedName(KEY_OVERVIEW)
    private String overview;

    @SerializedName(KEY_RATE)
    @Expose
    private String rate;

    @SerializedName(KEY_POSTER_PATH)
    @Column
    @Expose
    private String posterPath;

    @SerializedName(KEY_BACKDROP_PATH)
    @Expose
    private String backdropPath;

    @Column
    private int viewType;

    @SerializedName(KEY_GENRE_IDS)
    private List<Integer> genreIds = new ArrayList<>();

    @SerializedName(KEY_ORIGINAL_COUNTRY)
    private List<String> countrys = new ArrayList<>();


    private boolean favorite;

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public List<String> getCountrys() {
        return countrys;
    }

    public void setCountrys(List<String> countrys) {
        this.countrys = countrys;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullPosterPath(String preferedWidth) {
        StringBuilder sb = new StringBuilder();
        sb.append(URL_IMAGE_TMDB_DEFAULT);
        sb.append(preferedWidth);
        sb.append(posterPath);

        return sb.toString();
    }

    public String getFullBackdropPath(String preferedWidth) {
        StringBuilder sb = new StringBuilder();
        sb.append(URL_IMAGE_TMDB_DEFAULT);
        sb.append(preferedWidth);
        sb.append(backdropPath);

        return sb.toString();
    }

    @Override
    public String toString() {
        return "[Series {title=" + getTitle() + ", id= " + getId() + "}]";
    }

    @Override
    public int compareTo(Series o) {
        return o.getRate().compareTo(getRate());
    }
}
