package com.example.viewmodelandlivedatademo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyViewModal extends ViewModel {

    private Api api;
    Retrofit retrofit;

    private MutableLiveData<List<Items>> datalist;

    public LiveData<List<Items>> getUser() {


            datalist = new MutableLiveData<List<Items>>();

            loadData();



        return datalist;
    }

    public void loadData() {

            retrofit = new Retrofit.Builder()
                    .baseUrl(Api.BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        

        api = retrofit.create(Api.class);
        Log.d("api", "loadData: "+api);

        Call<DataList> call = api.getuser();

        call.enqueue(new Callback<DataList>() {

            @Override
            public void onResponse(Call<DataList> call, Response<DataList> response) {
                DataList dataList = response.body();
                List<Items> items = dataList.getData();
                for (int i = 0; i < items.size(); i++) {
                    Items items1 = items.get(i);
                    String name = items1.getName();
                    Log.d("API", "name on hitting API" + name);


                }
                datalist.setValue(dataList.getData());


            }

            @Override
            public void onFailure(Call<DataList> call, Throwable t) {
                Log.d("Exception", "onFailure: " + t.getMessage());

            }
        });

    }


}
