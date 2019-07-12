package com.responsi.mvp.service;

import com.responsi.mvp.model.People;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    @GET("people")
    Call<People> callPeople(@Query("results") String results,
                            @Query("nat") String nat);
}
