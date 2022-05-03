package com.example.project_thegame.network;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ServiceInterceptor {
    @NonNull
    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {

        Request request = chain.request();
        String token = PreferencesProvider.providePreferences().getString("token","");

        if(request.header("No-Authentication") == null){
            request = request.newBuilder()
                    .addHeader("Authorization", token)
                    .build();
        }
        return chain.proceed(request);
    }
}
