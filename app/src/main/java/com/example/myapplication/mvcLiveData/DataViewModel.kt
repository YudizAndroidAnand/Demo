package com.example.myapplication.mvcLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel : ViewModel() {
      var data = MutableLiveData<UserInfoData>()

    fun enterData(userName:String,userEmail:String,userAddress: String,userMobileNumber:String,userNewsApi:String){
        data.value = UserInfoData(userName, userEmail, userAddress, userMobileNumber,userNewsApi)
    }
}