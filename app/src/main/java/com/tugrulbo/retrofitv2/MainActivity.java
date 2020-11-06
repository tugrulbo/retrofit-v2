package com.tugrulbo.retrofitv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.tugrulbo.retrofitv2.Adapters.CustomAdapter;
import com.tugrulbo.retrofitv2.Models.Todos;
import com.tugrulbo.retrofitv2.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Todos> mList;

    ListView myListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initilize();
        myRequest();
    }

    public void initilize(){
        myListView = (ListView) findViewById(R.id.myListView);

    }

    public void myRequest(){

        mList = new ArrayList<>();
        Call<List<Todos>> listQueue = ManagerAll.getInstance().getAllInfo();
        listQueue.enqueue(new Callback<List<Todos>>() {
            @Override
            public void onResponse(Call<List<Todos>> call, Response<List<Todos>> response) {
                if(response.isSuccessful()){
                    mList = response.body();
                    CustomAdapter customAdapter = new CustomAdapter(mList,getApplicationContext());
                    myListView.setAdapter(customAdapter);

                }
            }

            @Override
            public void onFailure(Call<List<Todos>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}