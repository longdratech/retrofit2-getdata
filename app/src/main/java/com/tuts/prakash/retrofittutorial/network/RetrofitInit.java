package com.tuts.prakash.retrofittutorial.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by praka on 12/24/2017.
 */

public class RetrofitInit {

    private static Retrofit retrofit = null;

    private RetrofitInit() {

    }

    // ngươi dùng gọi phương thức này sẽ khởi tạo 2 thằng trên và trả về
    // interface request
    public static ApiRequest initApi() {
        if (retrofit == null) {
            retrofit = getInstance();
        }
        return retrofit.create(ApiRequest.class);
    }

    private static Retrofit getInstance() {

        // escaping character : `i\'am`
        Gson gson = new GsonBuilder()
                .setLenient()
                .disableHtmlEscaping()
                .create();

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .protocols(Arrays.asList(Protocol.HTTP_1_1))
                .build();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://api-project-nodejs.herokuapp.com/")
                .build();
        return retrofit;
    }

}