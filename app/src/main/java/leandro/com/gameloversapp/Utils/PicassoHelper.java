package leandro.com.gameloversapp.Utils;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import leandro.com.gameloversapp.R;

public class PicassoHelper {

    public static void getImage(String url, ImageView imageView){
            if (url != null ) {
                Picasso.get().load("http:" + url).into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                    }

                    @Override
                    public void onError(Exception e) {
                        imageView.setImageResource(R.drawable.image_error);
                    }
                });
            } else {
                imageView.setImageResource(R.drawable.image_error);
            }

    }
}
