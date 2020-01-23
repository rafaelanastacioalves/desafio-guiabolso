package com.example.rafaelanastacioalves.moby.jokeshowing

import android.arch.lifecycle.MutableLiveData
import com.example.rafaelanastacioalves.moby.base.BaseViewModel

import com.example.rafaelanastacioalves.moby.domain.model.Joke
import com.example.rafaelanastacioalves.moby.retrofit.APIClient

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject

class JokeShowingViewModel : BaseViewModel() {

    val jokeDetails = MutableLiveData<Joke>()

    @Inject
    lateinit var apiClient: APIClient


    fun loadData(categoryName: String?) {
        if (categoryName == null) {
            return
        }
        val call = apiClient.getRandomJokeForCategory(categoryName)


        call.enqueue(object : Callback<Joke> {
            override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                if (response.isSuccessful) {
                    Timber.i("response Successful")
                    jokeDetails.postValue(response.body())

                } else {
                    Timber.e(response.message())
                }
            }

            override fun onFailure(call: Call<Joke>, t: Throwable) {
                //TODO add more error management
                t.printStackTrace()
            }

        })
    }
}

