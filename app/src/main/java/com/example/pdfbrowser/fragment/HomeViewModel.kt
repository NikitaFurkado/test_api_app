package com.example.pdfbrowser.fragment

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pdfbrowser.api.ProductApi
import com.example.pdfbrowser.api.ProductItem
import com.example.pdfbrowser.api.ProductService
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class HomeViewModel : ViewModel() {


    lateinit var productDataList: MutableLiveData<List<ProductItem>>

    init {
        productDataList = MutableLiveData()
    }

    fun getLiveProductData(): MutableLiveData<List<ProductItem>> {
        return productDataList
    }
}