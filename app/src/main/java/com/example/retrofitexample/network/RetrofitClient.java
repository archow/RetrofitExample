package com.example.retrofitexample.network;

import com.example.retrofitexample.util.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//We'll need a single instance of Retrofit
//let's make a Singleton
public class RetrofitClient {
    //have a private instance of an object
    private static Retrofit RETROFIT_INSTANCE = null;

    //have a public getter for that object
     public static Retrofit getRetrofitClient() {
        //here we check if our retrofit instance is null; if not, we return it
        //otherwise we create a new retrofit object, and return that
        if (RETROFIT_INSTANCE == null) {
            //we build retrofit object here and set it to RETROFIT_INSTANCE and return it
            RETROFIT_INSTANCE = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return RETROFIT_INSTANCE;
    }

    /**
    private var RETROFIT_INSTANCE: Retrofit? = null

    fun getRetrofitClient(): Retrofit {
        //elvis operator ?:
        //if variable is not null, return the variable,
        //otherwise execute the block of code after operator
        return RETROFIT_INSTANCE ?: synchronized(this) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            val client = OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()
            val currentInstance = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) //                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .build()
            RETROFIT_INSTANCE = currentInstance
            currentInstance
        }
    }
     */
}
