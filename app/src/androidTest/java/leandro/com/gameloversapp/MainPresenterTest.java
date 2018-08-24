package leandro.com.gameloversapp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.view.View;

import org.junit.Test;

import leandro.com.gameloversapp.Presentation.Main.MainContract;
import leandro.com.gameloversapp.Presentation.Main.MainPresenter;

public class MainPresenterTest {

    @Test
    public void testPlatformZero(){
        Context context = InstrumentationRegistry.getTargetContext();
        MainContract.View mView = null;
        MainPresenter mainPresenter = new MainPresenter(mView, context);
        mainPresenter.getGamesBylatform(0);
    }
}
