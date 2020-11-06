package com.tugrulbo.retrofitv2.RestApi;

import com.tugrulbo.retrofitv2.Models.*;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends BaseManager {

    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance(){
        return ourInstance;
    }

    public Call<List<Todos>> getAllInfo(){
        Call<List<Todos>> call = getRestApiClient().callPosts();
        return call;

    }
}
