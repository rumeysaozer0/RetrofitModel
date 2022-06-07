package com.rumeysaozer.retrofitmodel.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rumeysaozer.retrofitmodel.adapter.CartXAdapter
import com.rumeysaozer.retrofitmodel.databinding.FragmentCartBinding
import com.rumeysaozer.retrofitmodel.model.CartX
import com.rumeysaozer.retrofitmodel.viewmodel.MainViewModel


class CartFragment : Fragment() {
    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!
    private var viewModel = MainViewModel()
    private var cart : ArrayList<CartX>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getDataFromApi()
        binding.recyclerView2.layoutManager = LinearLayoutManager(requireContext())
        observeLiveData()

    }
    fun observeLiveData(){
        viewModel.cart.observe(viewLifecycleOwner, Observer {
            it?.let{
                cart = ArrayList(it.carts)
                val adapter = CartXAdapter(cart!!)
                binding.recyclerView2.adapter = adapter

            }
        })
    }


}