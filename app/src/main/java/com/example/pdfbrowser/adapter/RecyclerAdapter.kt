package com.example.pdfbrowser.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pdfbrowser.R
import com.example.pdfbrowser.api.Product
import com.example.pdfbrowser.api.ProductItem
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class RecyclerAdapter(val product: Product) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return product.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product: ProductItem = product[position]
        holder.setData(product)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title_product = itemView.findViewById<TextView>(R.id.title_product)
        val id_product = itemView.findViewById<TextView>(R.id.id_product)
        val price_product = itemView.findViewById<TextView>(R.id.price_product)
        val description_product = itemView.findViewById<TextView>(R.id.description_product)
        val image_product = itemView.findViewById<ImageView>(R.id.image_product)
        val raiting_product = itemView.findViewById<TextView>(R.id.raiting_product)
        val catedory_product = itemView.findViewById<TextView>(R.id.category_product)

        fun setData(productItem: ProductItem) {
            itemView.apply {
                title_product.text = productItem.title
                id_product.text = productItem.id.toString()
                price_product.text = productItem.price.toString()
                description_product.text = productItem.description
                raiting_product.text = productItem.rating.toString()
                catedory_product.text = productItem.category

                val url = productItem.image
                Picasso.get().load(url).into(image_product)

            }
        }
    }
}