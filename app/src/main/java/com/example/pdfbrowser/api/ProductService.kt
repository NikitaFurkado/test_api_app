package com.example.pdfbrowser.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductService {

    companion object {

        fun getInstance(): Retrofit {

            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://fakestoreapi.com/")
                .build()
        }
    }
}