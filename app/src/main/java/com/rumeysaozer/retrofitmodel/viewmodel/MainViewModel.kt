package com.rumeysaozer.retrofitmodel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rumeysaozer.retrofitmodel.model.Cart
import com.rumeysaozer.retrofitmodel.model.CartX
import com.rumeysaozer.retrofitmodel.model.Product
import com.rumeysaozer.retrofitmodel.service.CartAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class MainViewModel: ViewModel() {
    private val cartAPIService = CartAPIService()
    private val disposable = CompositeDisposable()
    val cart = MutableLiveData<Cart>()
    fun getDataFromApi(){
        disposable.add(
            cartAPIService.getCarts()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Cart>(){
                    override fun onSuccess(t: Cart) {
                        cart.value = t
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                })
        )
    }
}