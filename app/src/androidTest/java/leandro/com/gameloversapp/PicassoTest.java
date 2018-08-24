package leandro.com.gameloversapp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.widget.ImageView;

import org.junit.Test;

import leandro.com.gameloversapp.Utils.PicassoHelper;

public class PicassoTest {

    @Test
    public void testNullUrl(){
        Context context = InstrumentationRegistry.getTargetContext();
        ImageView imageView = new ImageView(context);
        PicassoHelper.getImage(null,imageView, R.drawable.image_error);
    }

    @Test
    public void testEmptyUrl(){
        Context context = InstrumentationRegistry.getTargetContext();
        ImageView imageView = new ImageView(context);
        PicassoHelper.getImage("",imageView, R.drawable.image_error);
    }
}
