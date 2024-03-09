package com.example.aviatickets.model.service

import com.example.aviatickets.model.entity.Airline
import com.example.aviatickets.model.entity.Flight
import com.example.aviatickets.model.entity.Location
import com.example.aviatickets.model.entity.Offer
import com.example.aviatickets.model.network.ApiClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import java.util.UUID

object FakeService {
    @GET("offer_list")
    fun getOffers(): Call<List<Offer>>

    companion object {
        fun getClient(): Retrofit {
            return ApiClient.retrofit
        }
    }

}