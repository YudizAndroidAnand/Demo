package com.example.myapplication.json.retrofit
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.UserRawRetrofitBinding
import com.squareup.picasso.Picasso

class AdapterRetrofit(val context: Context, private var productList: MutableList<ProductData>, private val click : (productList:ProductData) -> Unit): RecyclerView.Adapter<AdapterRetrofit.MyViewHolder>() {

    class MyViewHolder(itemView: UserRawRetrofitBinding) : RecyclerView.ViewHolder(itemView.root) {

        fun bind(click: (productList: ProductData) -> Unit,position: Int){
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
        val bind = UserRawRetrofitBinding.inflate(itemView, parent, false)
        return MyViewHolder(bind)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

       holder.bind(click,position)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

}

