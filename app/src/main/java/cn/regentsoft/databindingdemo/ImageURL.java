package cn.regentsoft.databindingdemo;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/12/2 0002.
 *
 */
public class ImageURL {

    @BindingAdapter("loadImageUrl")
    public static void loadImage(ImageView imageView, int res) {
        imageView.setImageResource(res);
    }


}
