package com.zomato_demo.common;


import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.zomato_demo.R;


import androidx.databinding.BindingAdapter;

import java.util.Currency;

public class AppUtils {

    @BindingAdapter({"imageUrl"})
    public static void imageUrl(ImageView view, String imageUrl) {
        try {
            if (imageUrl != null) {
                RequestOptions requestOptions = new RequestOptions();
                Glide.with(view.getContext()).setDefaultRequestOptions(requestOptions).load(imageUrl).apply(requestOptions.placeholder(R.drawable.ic_launcher_background)).into(view);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //use this below method for store and wallpaper since the image sizes are different
    @BindingAdapter({"imageUrlWp"})
    public static void imageUrlWp(ImageView view, String imageUrl) {
        try {
            if (imageUrl != null) {
                RequestOptions requestOptions = new RequestOptions();
                Glide.with(view.getContext()).setDefaultRequestOptions(requestOptions).load(imageUrl).into(view);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @BindingAdapter({"imageBWUrl"})
    public static void imageBWUrl(ImageView view, String imageUrl) {
        try {
            if (imageUrl != null) {
                RequestOptions requestOptions = new RequestOptions();
                Glide.with(view.getContext()).setDefaultRequestOptions(requestOptions).load(imageUrl).apply(requestOptions.placeholder(R.drawable.ic_launcher_background)).into(view);
                ColorMatrix matrix = new ColorMatrix();
                matrix.setSaturation(0);

                ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
                view.setColorFilter(filter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BindingAdapter({"constraint"})
    public static void setFont(TextView textView, String color) {
        if (color!=null&&!color.matches("null")){
            textView.setTextColor(Color.parseColor("#"+color));
        }

    }

    @SuppressLint("SetTextI18n")
    @BindingAdapter({"CheckAndset","currency"})
    public static void setText(TextView textView, int text,String currency) {
        if (currency!=null&&!currency.matches("null")) {
            switch (text) {
                case 1:
                    textView.setText(currency);
                    break;
                case 2:
                    textView.setText(currency + currency);
                    break;
                case 3:
                    textView.setText(currency + currency + currency);
                    break;
                case 4:
                    textView.setText(currency + currency + currency + currency);
                    break;
                case 5:
                    textView.setText(currency + currency + currency + currency + currency);
                    break;
                default:
                    textView.setText("");
                    break;

            }
        }

    }

    public static boolean isNetworkAvailable(Context context) {

        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (NetworkInfo state : info) {
                    if (state.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }

                }
//                for (int i = 0; i < info.length; i++)
//                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
//                        return true;
//                    }
            }

        }

        return false;
    }






}
