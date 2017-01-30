package homepunk.lesson.first.view.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import homepunk.lesson.first.contollers.R;
import homepunk.lesson.first.interfaces.Presenter;
import homepunk.lesson.first.presenter.main.MainFragmentPresenter;

public class MainFragment extends Fragment implements homepunk.lesson.first.interfaces.View.MainFragmentView {
    @Bind(R.id.movies_rv) RecyclerView recycler;
    private Presenter topRatingModule;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, root);

        topRatingModule = new MainFragmentPresenter(this);
        topRatingModule.updateContent();

        return root;
    }

    @Override
    public RecyclerView getRecycleView() {
        return recycler;
    }
}

