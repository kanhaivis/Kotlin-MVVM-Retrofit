package kk.network

import com.google.gson.JsonElement
import kk.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("?")
    fun getMovies(@Query("results") results: String): Call<UserResponse>
}