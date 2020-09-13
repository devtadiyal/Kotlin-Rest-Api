package com.example.medcords.network

import com.example.medcords.model.ApiResponse
import com.example.medcords.model.RequestModel
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {
    // https://webserver-dev1.medcords.com/mhc/test_handle_click
    //@FormUrlEncoded
    @POST("test_handle_click")
    suspend fun getButtonDetails(@Body resquestModel: RequestModel):ApiResponse

    companion object {
        operator fun invoke()/*(
            networkConnectionInterceptor: Interceptor
        )*/: Api {

           /* val okHttpClient =
                OkHttpClient.Builder().addInterceptor(networkConnectionInterceptor).build()*/

            return Retrofit.Builder()
               // .client(okHttpClient)
                .baseUrl("https://webserver-dev1.medcords.com/mhc/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api::class.java)
        }
    }
}