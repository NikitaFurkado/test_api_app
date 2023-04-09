package com.example.pdfbrowser.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.pdfbrowser.R
import com.example.pdfbrowser.adapter.RecyclerAdapter
import com.example.pdfbrowser.api.Product
import com.example.pdfbrowser.api.ProductApi
import com.example.pdfbrowser.api.ProductItem
import com.example.pdfbrowser.api.ProductService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private lateinit var product: Product

    @SuppressLint("RestrictedApi")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        apiCall()

        return view
    }

    private fun apiCall() {
        val apiCall = ProductService.getInstance().create(ProductApi::class.java)
        apiCall.getProducts().enqueue(object: Callback<Product> {
            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                product = response.body()!!
                setRecyclerView(view!!)
            }

            override fun onFailure(call: Call<Product>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun setRecyclerView(view: View) {
        val rvAdapter = RecyclerAdapter(product)
        val linearLayoutManager = LinearLayoutManager(activity)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        DividerItemDecoration(activity, DividerItemDecoration.HORIZONTAL)

        recyclerView.adapter = rvAdapter
        recyclerView.layoutManager = linearLayoutManager

    }
}