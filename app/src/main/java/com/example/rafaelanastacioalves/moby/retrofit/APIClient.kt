package com.example.rafaelanastacioalves.moby.retrofit;


import com.example.rafaelanastacioalves.moby.domain.model.Joke
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface APIClient {

    @GET("/jokes/categories")
    fun getCategoriesList(): Observable<List<String>>;

    @GET("/jokes/random")
    fun getRandomJokeForCategory(@Query("category") category: String): Observable<Joke>;

}
