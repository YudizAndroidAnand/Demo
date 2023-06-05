package com.example.myapplication.json.retrofit
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.squareup.picasso.Picasso

class AdapterRetrofit(val context: Context, private var productlist: MutableList<ProductData>): RecyclerView.Adapter<AdapterRetrofit.MyViewHolder>() {
    private var onClickListener: OnClickListener? = null
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.textview_title)
        val price : TextView = itemView.findViewById(R.id.textview_product_price)
        val category : TextView = itemView.findViewById(R.id.textview_product_category)
        val image : ImageView = itemView.findViewById(R.id.imageview_product)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_raw_retrofit, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentPosition = productlist[position]
        holder.title.text = currentPosition.title
        val priceData = "${currentPosition.price.toString()}$"
        holder.price.text = priceData
        holder.category.text = currentPosition.category
        Picasso.get()
            .load(currentPosition.thumbnail)
            .placeholder(R.drawable.ic_image)
            .into(holder.image)
        holder.itemView.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(position, productlist )
            }
        }
    }
    override fun getItemCount(): Int {
        return productlist.size
    }
    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }
    interface OnClickListener {
        fun onClick(position: Int, productList: MutableList<ProductData>)
    }
}

