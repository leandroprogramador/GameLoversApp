package leandro.com.gameloversapp.Presentation.Main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import leandro.com.gameloversapp.Data.Game;
import leandro.com.gameloversapp.Presentation.Main.Adapters.MainTabAdapter;
import leandro.com.gameloversapp.R;

public class MainActivity extends AppCompatActivity implements MainContract.View, TabLayout.OnTabSelectedListener {

    private static final int NINTENDO_64 = 4;
    private static final int PS4 = 48;
    private static final int XBOX = 49;
    MainPresenter mainPresenter;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.pager)
    ViewPager viewPager;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    MainTabAdapter mainTabAdapter;
    GameFragment gameFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initPresenter();
    }

    private void initPresenter() {
        mainPresenter = new MainPresenter(this, MainActivity.this);
        mainPresenter.getGamesBylatform(NINTENDO_64);
        mainPresenter.getGamesBylatform(PS4);
        mainPresenter.getGamesBylatform(XBOX);


    }

    @Override
    public void setToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.app_name));

    }

    @Override
    public void setTabs() {
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.nintendo_64)));

        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.playstation_4)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.xbox)));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        mainTabAdapter = new MainTabAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setOffscreenPageLimit(tabLayout.getTabCount());
        viewPager.setAdapter(mainTabAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(this);


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
    public void fillRecyclerView(int platforms, List<Game> games) {


        switch (platforms) {
            case NINTENDO_64:
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        gameFragment = (GameFragment) viewPager.getAdapter().instantiateItem(viewPager, getResources().getInteger(R.integer.nintendo_fragment));
                        gameFragment.setAdapter(games);
                    }
                });
                break;
            case PS4:
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        gameFragment = (GameFragment) viewPager.getAdapter().instantiateItem(viewPager, getResources().getInteger(R.integer.ps4_fragment));
                        gameFragment.setAdapter(games);
                    }
                });
                break;
            case XBOX:
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        gameFragment = (GameFragment) viewPager.getAdapter().instantiateItem(viewPager, getResources().getInteger(R.integer.xbox_fragment));
                        gameFragment.setAdapter(games);
                    }
                });
                break;
        }

    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
