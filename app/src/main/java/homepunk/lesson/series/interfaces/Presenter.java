package homepunk.lesson.series.interfaces;

import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;

import homepunk.lesson.series.model.Series;

public interface Presenter {

    interface MainActivityPresenter {
        void setView(View.MainActivityView view);

        void onSpinnerItemClicked();

        Fragment onTabSelected(@IdRes int tabId);

        void onNavigationItemSelected(int id);
    }

    interface MainFragmentPresenter {
        void setView(View.MainFragmentView view);

        void getOnAirSeries();

        void onSeriesSelected(int id);
    }

    interface SearchFragmentPresenter {
        void setView(View.SearchFragmentView view);

        void getRecommendedSeries();

        void onSearchViewClicked();

    }

    interface DetailedFragmentPresenter {
        void setView(View.DetailedFragmentView view);

        void getSeriesDescriptionById(int id);
    }

    interface TopRatedFragmentPresenter {
        void setView(View.HotUpdatesFragmentView view);

        void getHotUpdates();
    }

    interface Fab {
        void setMainFabClickListener(FloatingActionButton fab);

        void setFabsClickListeners(FloatingActionButton fab, FloatingActionButton fab1,
                                   FloatingActionButton fab2);

        void loadFabAnimation();
    }

    interface Observer {

        void update(Series tvSeries);
    }

}
