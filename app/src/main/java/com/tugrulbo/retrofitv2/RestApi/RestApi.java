package com.tugrulbo.retrofitv2.RestApi;

import com.tugrulbo.retrofitv2.Models.Todos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {

    @GET("/todos")
    Call<List<Todos>> callPosts();



}
