package leandro.com.gameloversapp.Utils;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PicassoHelper {

    public static void getImage(String url, ImageView imageView, int placeholder){
            if (url != null || url.isEmpty()) {
                Picasso.get().load("http:" + url).into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                    }

                    @Override
                    public void onError(Exception e) {
                        imageView.setImageResource(placeholder);
                    }
                });
            } else {
                imageView.setImageResource(placeholder);
            }

    }
}
