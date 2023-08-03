package com.example.sampleapplication.api;

import com.example.sampleapplication.App.IApp;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {




        private static Retrofit retrofitCore2Service;
        private static Retrofit retrofitPlanService;
        //private static PlanAPIs PlanAPIs;
        //    private static CoreAPIs coreAPIs;
        private static CoreAPI coreAPIs2;

        private static final String URL_CORE_2 = "https://bioiot.bioenabletech.com/";


        private static String new_url;
        private static IApp app;

        public static CoreAPI forCore() {

            if(retrofitCore2Service == null) retrofitCore2Service = createClient(URL_CORE_2);
            if(coreAPIs2==null)coreAPIs2 = retrofitCore2Service.create(CoreAPI.class);
            return coreAPIs2;
        }




        private static Retrofit createClient(String baseUrl){
            return new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(new OkHttpClient.Builder()
                            .addInterceptor(new LoggingInterceptor())
                            .connectTimeout(5, TimeUnit.MINUTES)
                            .readTimeout(5,TimeUnit.MINUTES)
                            .writeTimeout(5,TimeUnit.MINUTES)
                            .build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }


}

