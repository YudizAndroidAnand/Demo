package com.example.myapplication.Json.retrofit
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
        val price : TextView = itemView.findViewById(R.id.textview_price)
        val category : TextView = itemView.findViewById(R.id.textview_category)
        val image : ImageView = itemView.findViewById(R.id.imageview_product)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_raw_retrofit, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentPosition = productlist[position]
        holder.title.text = currentPosition.title
        holder.price.text = currentPosition.price.toString()
        holder.category.text = currentPosition.category
        Picasso.get()
            .load(currentPosition.thumbnail)
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
    // onClickListener Interface
    interface OnClickListener {
        fun onClick(position: Int,productlist: MutableList<ProductData>)
    }

    companion object
}

