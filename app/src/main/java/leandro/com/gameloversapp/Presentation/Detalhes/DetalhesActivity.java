package leandro.com.gameloversapp.Presentation.Detalhes;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import leandro.com.gameloversapp.Data.Game;
import leandro.com.gameloversapp.Data.Genres;
import leandro.com.gameloversapp.Data.Platform;
import leandro.com.gameloversapp.R;
import leandro.com.gameloversapp.Utils.PicassoHelper;

public class DetalhesActivity extends AppCompatActivity implements DetalhesContract.View{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.txtGenre)
    TextView txtGenre;
    @BindView(R.id.txtPlatforms)
    TextView txtPlatforms;
    @BindView(R.id.txtDescription)
    TextView txtDescription;
    @BindView(R.id.imgCover)
    ImageView imgCover;

    DetalhesPresenter detalhesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        ButterKnife.bind(this);
        initPresenter();
    }

    private void initPresenter() {
        detalhesPresenter = new DetalhesPresenter(this, DetalhesActivity.this);
        int id = getIntent().getIntExtra(getString(R.string.game_id), 0);
        detalhesPresenter.getGameDescription(id);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void setToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void fillView(Game game) {
        txtTitle.setText(game.getName());
        txtDescription.setText(game.getSummary());
        PicassoHelper.getImage(game.getCover().getBigCover(),imgCover);
        detalhesPresenter.getGameGenres(Genres.getGenres(game.getGenres()));
        detalhesPresenter.getGamePlatforms(Platform.getPlatforms(game.getPlatforms()));
    }

    @Override
    public void fillGenres(String genres) {
        txtGenre.setText(String.format("Genre: %s", genres));
    }

    @Override
    public void fillPlatforms(String platforms) {
        txtPlatforms.setText(String.format("Platforms: %s", platforms));
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
