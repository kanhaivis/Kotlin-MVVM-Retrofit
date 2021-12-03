package kk.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiCall {

    companion object {

        var BASE_URL = "https://randomuser.me/api/"

        fun create(): ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(ApiInterface::class.java)

        }
    }
}