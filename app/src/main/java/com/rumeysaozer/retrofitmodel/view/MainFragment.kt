package com.rumeysaozer.retrofitmodel.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.rumeysaozer.retrofitmodel.R
import com.rumeysaozer.retrofitmodel.databinding.FragmentMainBinding
import com.rumeysaozer.retrofitmodel.viewmodel.MainViewModel


class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private var viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getDataFromApi()
        observeLiveData()
        binding.bCarts.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToCartFragment()
            findNavController().navigate(action)
        }
        binding.bProduct.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToProductFragment()
            findNavController().navigate(action)
        }
    }
    fun observeLiveData(){
        viewModel.cart.observe(viewLifecycleOwner, Observer { cart->
            cart?.let {
                binding.limit.text = it.limit.toString()
                binding.skip.text = it.skip.toString()
                binding.total.text = it.total.toString()
            }

        })
    }


}