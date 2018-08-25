package leandro.com.gameloversapp.Presentation.Detalhes;

import java.util.List;

import leandro.com.gameloversapp.Data.Game;

public interface DetalhesContract {

    public interface View{
        void setToolbar();
        void showProgress();
        void hideProgress();
        void fillView(Game game);
        void fillGenres(String genres);
        void fillPlatforms(String platforms);
        void showError(String error);
    }

    public interface Presenter{
        void getGameDescription(int id);
        void getGameGenres(String genres);
        void getGamePlatforms(String platforms);
    }

}
