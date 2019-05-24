package com.zomato_demo.NetworkManager;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zomato_demo.Interfaces.DataCallBackListener;

import java.io.IOException;

import androidx.annotation.NonNull;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class BaseManager<E> implements Callback<E> {

    private Context context;

    public BaseManager(Context context) {
        this.context = context;
    }

    private DataCallBackListener<E> getDataCallBack;

    public synchronized Call<E> sendRequest(Call<E> call, DataCallBackListener<E> getDataCallBack) {
        this.getDataCallBack = getDataCallBack;
        Request request = call.request();
        Log.i(TAG, "sendRequest: url=" + request.url() + "  header=" + request.headers()+"    body="+bodyToString(request.body()));
        call.enqueue(this);
        return call;
    }


    @Override
    public void onResponse(@NonNull final Call<E> call, @NonNull Response<E> response) {

        try {
            getDataCallBack.onResponse(response.body());

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public void onFailure(@NonNull Call<E> call, @NonNull Throwable t) {
        //error response to handle
        try {
            Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            getDataCallBack.onError(t);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String bodyToString(final RequestBody request) {
        try {
            final RequestBody copy = request;
            final Buffer buffer = new Buffer();
            if (copy != null)
                copy.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }


}
