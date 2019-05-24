package com.zomato_demo.NetworkManager;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.zomato_demo.common.Const;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class NetworkGenerator {
    //customize it to generic more working in progress...

    private static Retrofit retrofit = null;

    public NetworkGenerator() {

    }

    public static Retrofit getClient() {
        //monitor,recall,retry mechanism and sample headers added

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(
                        new Interceptor() {
                            @Override
                            public Response intercept(Chain chain) throws IOException {
                                Request request = chain.request().newBuilder()
                                        .addHeader("Accept: application/json", "user-key: b04cd820e58cc9dd8e850f84354d6c4c")
//                                        .addHeader("Authorization", Credentials.basic(BASEAUTH_USERNAME, BASEAUTH_PASSWORD))
                                        .build();
                                return chain.proceed(request);
                            }
                        }).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }

    private static String auth = "";

    public static Retrofit getAuthClient(Context context) {
        //only for auth apis
//        try {
//            TokenModel tokenModel = new Gson().fromJson(new PreferenceManager(context).getTokenData(), TokenModel.class);
//            if (tokenModel != null) {
//                auth = "Bearer ".concat(tokenModel.getResponse().getAccess_token());
////                Log.d(TAG, "getAuthClient: auth=" + auth);
//            }
//
//        } catch (JsonSyntaxException e) {
//            e.printStackTrace();
//        }

        OkHttpClient defaultHttpClient = new OkHttpClient.Builder()
                .addInterceptor(
                        new Interceptor() {
                            @Override
                            public Response intercept(Chain chain) throws IOException {
                                Request request = chain.request().newBuilder()
                                        .addHeader("Accept","application/json")
                                        .addHeader("user-key","b04cd820e58cc9dd8e850f84354d6c4c")
                                        .build();
                                return chain.proceed(request);
                            }
                        }).build();


        retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(defaultHttpClient)
                .build();

        return retrofit;
    }

}
