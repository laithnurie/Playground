package com.laithlab.playground.RetroExample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.laithlab.playground.R;
import com.laithlab.playground.RetroExample.retrofit.ImgurService;
import com.laithlab.playground.RetroExample.retrofit.SearchResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitActivity extends AppCompatActivity {

    private TextView searchResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_example);

        searchResult = (TextView) findViewById(R.id.txt_search_count);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.imgur.com/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        ImgurService imgurService = retrofit.create(ImgurService.class);

        Call<SearchResponse> responseCall = imgurService.search("cat");
        responseCall.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, final Response<SearchResponse> response) {
                Log.v("lnln", "success");
                if (response.body() != null) {
                    searchResult.setText(Integer.toString(response.body().getData().length));
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                Log.v("lnln", "fail");
            }
        });
    }
}
