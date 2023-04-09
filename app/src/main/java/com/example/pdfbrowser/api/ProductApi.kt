package com.example.pdfbrowser.api

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ProductApi {

    @GET("products")
    fun getProducts() : retrofit2.Call<Product>
}