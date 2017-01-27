package homepunk.lesson.first.presenter.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import homepunk.lesson.first.database.Constants;
import homepunk.lesson.first.model.network.TVListFetchrModel;
import homepunk.lesson.first.presenter.Presenter;
import homepunk.lesson.first.presenter.common.RecycleViewPresenter;
import homepunk.lesson.first.view.main.MainFragment;


public class MainFragmentPresenter implements Presenter{
    private Context context;
    private MainFragment view;
    private RecyclerView recyclerView;
    private RecycleViewPresenter rvPresenter;

    public MainFragmentPresenter(MainFragment f) {
        this.view = f;
        this.context = view.getContext();
        this.rvPresenter = new RecycleViewPresenter(view);
    }

    @Override
    public void addView(ViewGroup view) {
        this.recyclerView = (RecyclerView) view;
    }

    @Override
    public void attachAllViews() {
        rvPresenter.attachRecycleView(recyclerView);
    }

    @Override
    public void updateContent() {
        TVListFetchrModel task = new TVListFetchrModel(this);
        task.setExecuteRef(Constants.TV_REFENECE + Constants.TV_TOP20 + Constants.LANGUAGE_EN + Constants.API_KEY);
        rvPresenter.updateContent(task);
    }

    @Override
    public Context getContext() {
        return context;
    }
}