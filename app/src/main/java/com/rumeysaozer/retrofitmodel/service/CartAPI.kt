package com.rumeysaozer.retrofitmodel.service

import com.rumeysaozer.retrofitmodel.model.Cart
import com.rumeysaozer.retrofitmodel.model.CartX
import com.rumeysaozer.retrofitmodel.model.Product
import io.reactivex.Single
import retrofit2.http.GET

interface CartAPI {
@GET("carts")
fun getCart(): Single<Cart>

}