package com.example.aviatickets.model.network

//import
import com.example.aviatickets.model.entity.Offer
import com.example.aviatickets.model.service.FakeService
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object ApiClient {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://my-json-server.typicode.com/estharossa/fake-api-demo/offer_list")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    /**
     * think about performing network request
     */

    val instance = retrofit.create(FakeService::class.java)




}



