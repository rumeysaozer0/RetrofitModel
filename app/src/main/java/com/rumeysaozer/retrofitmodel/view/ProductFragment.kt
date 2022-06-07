package com.rumeysaozer.retrofitmodel.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rumeysaozer.retrofitmodel.adapter.ProductAdapter
import com.rumeysaozer.retrofitmodel.databinding.FragmentProductBinding
import com.rumeysaozer.retrofitmodel.model.CartX
import com.rumeysaozer.retrofitmodel.model.Product
import com.rumeysaozer.retrofitmodel.viewmodel.MainViewModel


class ProductFragment : Fragment() {
    private var _binding: FragmentProductBinding? = null
    private val binding get() = _binding!!
    private var viewModel = MainViewModel()
    val productList: ArrayList<Product> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getDataFromApi()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        getProduct()
    }
    fun getProduct(){
        viewModel.cart.observe(viewLifecycleOwner, Observer {
            it?.let{
                for(cart in it.carts ){
                    for(product in cart.products){
                        productList.add(product)
                        val adapter = ProductAdapter(productList!!)
                        binding.recyclerView.adapter = adapter
                    }
                }







            }
        })
    }


}