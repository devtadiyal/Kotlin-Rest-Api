package com.example.medcords.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medcords.model.ApiResponse
import com.example.medcords.model.RequestModel
import com.example.medcords.repository.MainRepository
import kotlinx.coroutines.launch

class MainViewModel(private var repository: MainRepository) : ViewModel() {
     var apiResponse = MutableLiveData<ApiResponse>()
     lateinit var str : String

     //suspend funtion inside coroutine block
     init {
        viewModelScope.launch {
             //sending request to repository
             var rqstModel = RequestModel()
             rqstModel.bname = "B1"
             //getting api response and pass to view using livedata
             var getResult = repository.getDetails(rqstModel)
             apiResponse.postValue(getResult)
        }
     }

}