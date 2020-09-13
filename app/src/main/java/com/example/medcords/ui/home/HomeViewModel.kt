package com.example.medcords.ui.home

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation
import com.example.medcords.R
import com.example.medcords.model.ApiResponse
import com.example.medcords.model.RequestModel
import com.example.medcords.repository.MainRepository
import kotlinx.coroutines.launch

class HomeViewModel(private var repository: MainRepository) : ViewModel() {
    //mutable live data object
    var res = MutableLiveData<ApiResponse>()

    //click operations of buttons
    fun buttonAClick() { setResponse("B1") }
    fun buttonBClick() { setResponse("B2") }
    fun buttonCClick() { setResponse("B3") }
    fun buttonDClick() { setResponse("B4") }

    //set response to livedata
    fun setResponse(str:String) {
        //suspend funtion inside viewmmodelscope
        viewModelScope.launch {
            //sending request to repository
            var rqstModel = RequestModel()
            rqstModel.bname = str
            //getting api response and pass to view using livedata
            var getResult = repository.getDetails(rqstModel)
            res.postValue(getResult)
            //println("RESPONSE " + getResult.data.rstr)
        }
    }
    //get response livedata in view using this method
    fun getResponse():MutableLiveData<ApiResponse>{
        return res
    }
}