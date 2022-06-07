package com.rumeysaozer.retrofitmodel.model




data class CartX(
    val discountedTotal: Int,
    val id: Int,
    val products: List<Product>,
    val total: Int,
    val totalProducts: Int,
    val totalQuantity: Int,
    val userId: Int
)