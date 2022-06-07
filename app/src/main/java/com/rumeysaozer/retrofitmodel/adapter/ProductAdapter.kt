package com.rumeysaozer.retrofitmodel.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rumeysaozer.retrofitmodel.databinding.ProductItemBinding
import com.rumeysaozer.retrofitmodel.model.CartX
import com.rumeysaozer.retrofitmodel.model.Product

class ProductAdapter(val productList : ArrayList<Product>):RecyclerView.Adapter<ProductAdapter.ProductHolder>() {
    class ProductHolder(var binding : ProductItemBinding ): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val binding = ProductItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
      holder.binding.title.text = productList[position].title
    }

    override fun getItemCount(): Int {
    return productList.size
    }
}