package leandro.com.gameloversapp.Presentation.Main.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import leandro.com.gameloversapp.Presentation.Main.GameFragment;

public class MainTabAdapter extends FragmentStatePagerAdapter {
    int count;
    public MainTabAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.count = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        return new GameFragment();
    }

    @Override
    public int getCount() {
        return this.count;
    }
}
