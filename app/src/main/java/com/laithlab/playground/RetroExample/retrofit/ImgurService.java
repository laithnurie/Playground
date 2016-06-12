package com.laithlab.playground.RetroExample.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;


public interface ImgurService {
    @Headers({
            "Authorization: Client-ID c9378391e3c8d3f"
    })
    @GET("gallery/search")
    Call<SearchResponse> search(@Query("q") String searchQuery);
}
