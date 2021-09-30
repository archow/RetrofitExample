package com.example.retrofitexample.network;

import com.example.retrofitexample.model.GithubResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//this interface works with the Retrofit object to make a network call
//it basically defines the rest of the url for the endpoints and network requests you will make
public interface GithubApiService {
    @GET("search/users")
    Call<GithubResponse> getGithubResponse(
            @Query("q") String queryParameter,
            @Query("sort") String sortParameter
    );
}
