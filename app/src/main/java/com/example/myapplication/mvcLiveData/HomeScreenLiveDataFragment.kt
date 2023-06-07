package com.example.myapplication.mvcLiveData

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomeScreenLiveDataBinding
import com.example.myapplication.json.retrofit.RetrofitAPI
import com.example.myapplication.json.retrofit.UserDataProduct
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class HomeScreenLiveDataFragment : Fragment() {
    private val viewModelData by lazy {
        ViewModelProvider(requireActivity())[DataViewModel::class.java]
    }
    private lateinit var binding: FragmentHomeScreenLiveDataBinding
    private lateinit var newsApi : String
    private lateinit var call : Response<NewRes>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

         binding  = DataBindingUtil.inflate<FragmentHomeScreenLiveDataBinding>(inflater,R.layout.fragment_home_screen_live_data,container,false)

        binding.buttonEdit.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.home_fragment, EditScreenFragment())
            transaction?.commit()
        }
        viewModelData.data.observe(viewLifecycleOwner){
            binding.textviewName.text = it.name
            binding.textviewEmail.text = it.email
            binding.textviewAdd.text = it.address
            binding.textviewMobileNumber.text = it.mobileNumber
            newsApi = it.newsApi
        }

        return binding.root
    }
    private fun getData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/everything?q=Yudiz&limit=10&apiKey=a4ed7f051ca3457b89ebd06d2083b973")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
        GlobalScope.launch {
             call = retrofit.getNews(newsApi)
        }
        call.enqueue(object : Callback<NewRes> {
            override fun onResponse(call: Call<NewRes>, response: Response<NewRes>)
            {
                val myAdapter = InfoAdapter(response.body()!!.articles)
                binding.recyclerviewNews.adapter = myAdapter
            }
            override fun onFailure(call: Call<NewRes>, t: Throwable) {
                Toast.makeText(context, "Fail to get the data..", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

}

