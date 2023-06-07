package com.example.myapplication.mvcLiveData

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentEditScreenBinding
import com.example.myapplication.json.retrofit.AdapterRetrofit
import com.example.myapplication.json.retrofit.RetrofitAPI
import com.example.myapplication.json.retrofit.ShowProductDataActivity
import com.example.myapplication.json.retrofit.UserDataProduct
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EditScreenFragment : Fragment() {

    private val viewModelData by lazy {
         ViewModelProvider(requireActivity())[DataViewModel::class.java]
    }
    private lateinit var dataVM : DataViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentEditScreenBinding>(inflater,R.layout.fragment_edit_screen,container,false)
        dataVM = ViewModelProvider(this)[DataViewModel::class.java]
        binding.buttonSubmitUpdateData.setOnClickListener {

            val name = binding.edittextName.text.toString()
            val email = binding.edittextEmail.text.toString()
            val add = binding.edittextAdd.text.toString()
            val mobileNumber = binding.edittextMobileNumber.text.toString()
            val newApi = binding.edittextFindData.text.toString()
            viewModelData.enterData(name,email,add,mobileNumber,newApi)
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.home_fragment, HomeScreenLiveDataFragment())
            transaction?.commit()
        }
        viewModelData.data.observe(viewLifecycleOwner, Observer<UserInfoData> {
            binding.edittextName.setText(it.name)
            binding.edittextEmail.setText(it.email)
            binding.edittextAdd.setText(it.address)
            binding.edittextMobileNumber.setText(it.mobileNumber)
            binding.edittextFindData.setText(it.newsApi)
        })
        return binding.root
    }
}