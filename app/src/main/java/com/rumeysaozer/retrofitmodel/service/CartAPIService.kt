package com.rumeysaozer.retrofitmodel.service

import com.rumeysaozer.retrofitmodel.model.Cart
import com.rumeysaozer.retrofitmodel.model.CartX
import com.rumeysaozer.retrofitmodel.model.Product
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CartAPIService {
    private val BASE_URL = "https://dummyjson.com/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(CartAPI::class.java)
    fun getCarts(): Single<Cart> {
        return api.getCart()
    }

}