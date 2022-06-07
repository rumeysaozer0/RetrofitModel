package com.rumeysaozer.retrofitmodel.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rumeysaozer.retrofitmodel.databinding.ProductItemBinding
import com.rumeysaozer.retrofitmodel.model.CartX

class CartXAdapter(val cartList : ArrayList<CartX> ) :RecyclerView.Adapter<CartXAdapter.CartHolder>() {
    class CartHolder( var binding : ProductItemBinding ): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartHolder {
        val binding = ProductItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CartHolder(binding)
    }

    override fun onBindViewHolder(holder: CartHolder, position: Int) {
        holder.binding.title.text = cartList[position].discountedTotal.toString()
    }

    override fun getItemCount(): Int {
        return cartList.size
    }
}