package com.example.androiddemo.network


import com.example.aviatickets.model.entity.Offer
import retrofit2.Call
import retrofit2.http.GET

interface OfferService {
    @GET("offer_list")
    fun fetchPersonList(): Call<List<Offer>>
}