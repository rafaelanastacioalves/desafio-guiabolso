package com.example.rafaelanastacioalves.moby.categorylisting;

import android.arch.lifecycle.MutableLiveData;
import com.example.rafaelanastacioalves.moby.base.BaseViewModel

import com.example.rafaelanastacioalves.moby.retrofit.APIClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;
import javax.inject.Inject

class LiveDataMainEntityListViewModel : BaseViewModel() {

    @Inject
    lateinit var apiClient: APIClient

    val mainEntityList = MutableLiveData<List<String>>()

    init {
        loadData()
    }
    fun loadData() {
        Timber.i("LiveDataMainEntityListViewModel loadData");

        if(mainEntityList.getValue() != null){
            return;
        }

        var call: Call<List<String>> = apiClient.getCategoriesList();
        call.enqueue(object : Callback<List<String>> {

            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                if (response.isSuccessful()) {
                    Timber.i("response Successful");
                    mainEntityList.setValue(response.body());
                }
            }

            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                t.printStackTrace();
            }
        })

    }
}
