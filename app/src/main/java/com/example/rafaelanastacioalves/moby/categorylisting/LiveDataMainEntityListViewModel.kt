package com.example.rafaelanastacioalves.moby.categorylisting;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer
import com.example.rafaelanastacioalves.moby.base.BaseViewModel

import com.example.rafaelanastacioalves.moby.retrofit.APIClient;
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;
import javax.inject.Inject

class LiveDataMainEntityListViewModel : BaseViewModel() {

    @Inject
    lateinit var apiClient: APIClient

    val mainEntityList = MutableLiveData<List<String>>()

    private lateinit var subscription: Disposable

    init {
        loadData()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    fun loadData() {
        Timber.i("LiveDataMainEntityListViewModel loadData");

        if(mainEntityList.getValue() != null){
            return;
        }

        subscription = apiClient.getCategoriesList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({result -> mainEntityList.value = result})

    }

}
