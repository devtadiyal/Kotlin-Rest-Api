package com.example.medcords.repository

import com.example.medcords.model.ApiResponse
import com.example.medcords.model.RequestModel
import com.example.medcords.network.Api
import org.kodein.di.KodeinAware

class MainRepository(private var api:Api) {

    suspend fun getDetails(requestModel: RequestModel):ApiResponse{
        return api.getButtonDetails(requestModel)
    }

}