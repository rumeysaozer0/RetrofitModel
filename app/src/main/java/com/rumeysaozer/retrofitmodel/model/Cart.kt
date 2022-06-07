package com.rumeysaozer.retrofitmodel.model



data class Cart(
    val carts: List<CartX>,
    val limit: Int,
    val skip: Int,
    val total: Int
)