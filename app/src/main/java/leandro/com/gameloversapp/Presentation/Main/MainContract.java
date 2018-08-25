package leandro.com.gameloversapp.Presentation.Main;

import java.util.List;

import leandro.com.gameloversapp.Data.Game;

public interface MainContract {

    interface View{
        void setToolbar();
        void setTabs();
        void showProgress();
        void hideProgress();
        void fillRecyclerView(int platforms, List<Game> games);
        void showError(String error);
    }

    interface Presenter{
        List<Game> getGamesByPlatform(int platform);
    }
}
