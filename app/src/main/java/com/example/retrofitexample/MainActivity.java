package com.example.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.retrofitexample.model.GithubResponse;
import com.example.retrofitexample.model.Item;
import com.example.retrofitexample.network.GithubApiService;
import com.example.retrofitexample.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Let's FINALLY make a network call
        //first we initialize and define our retrofit object
        Retrofit myRetrofitClient = RetrofitClient.getRetrofitClient();
        //next we'll create our Api Service to make the network call
        GithubApiService apiService = myRetrofitClient.create(GithubApiService.class);

        //now we finally make the network call, and thanks to the following method, it will
        //be done in a background thread, and the result will be returned back to the view
        apiService.getGithubResponse("johnnyboy", "repositories")
                .enqueue(new Callback<GithubResponse>() {
                    @Override
                    public void onResponse(Call<GithubResponse> call, Response<GithubResponse> response) {
                        if (response.isSuccessful()) {
                            GithubResponse myResponse = response.body();
                            List<Item> myItems = null;
                            if (myResponse != null) {
                                myItems = myResponse.getItems();
                            }
                            if (myItems != null) {
                                for (int i=0; i<myResponse.getItems().size(); i++) {
                                    Item currentUser = myItems.get(i);
                                    Log.d("current_user_login", currentUser.getLogin());
                                }
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<GithubResponse> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "We failed", Toast.LENGTH_LONG)
                                .show();
                    }
                });
    }
}