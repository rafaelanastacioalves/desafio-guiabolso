package com.example.rafaelanastacioalves.moby.jokeshowing

import android.arch.lifecycle.MutableLiveData
import com.example.rafaelanastacioalves.moby.base.BaseViewModel

import com.example.rafaelanastacioalves.moby.domain.model.Joke
import com.example.rafaelanastacioalves.moby.retrofit.APIClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject

class JokeShowingViewModel : BaseViewModel() {

    val jokeDetails = MutableLiveData<Joke>()

    @Inject
    lateinit var apiClient: APIClient

    private lateinit var subscription: Disposable

    fun loadData(categoryName: String?) {
        if (categoryName == null) {
            return
        }
        val call = apiClient.getRandomJokeForCategory(categoryName)

        subscription = apiClient.getRandomJokeForCategory(categoryName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({response -> jokeDetails.value = response})
    }
}

