package com.myapp.kundli.redbubbletest.network

import com.myapp.kundli.redbubbletest.model.Home
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface Api {

    companion object {
        const val BASE_URL = "https://take-home-test.herokuapp.com/bff/workDetails/"
    }

    @GET("326210.json")
    suspend fun getHome(): Home
}