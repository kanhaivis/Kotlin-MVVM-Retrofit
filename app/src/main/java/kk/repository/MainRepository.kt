package kk.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kk.database.MyDataBase
import kk.model.ResultData
import kk.model.UserResponse
import kk.mvp.MainView
import kk.network.ApiCall
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository(var _mainView: MainView?, var db: MyDataBase) {

    private val mutableResultData = MutableLiveData<List<ResultData>>()

    val resultData : LiveData<List<ResultData>>
    get() = mutableResultData

    fun onCallApi(count: String) {

        val apiInterface = ApiCall.create().getMovies(count)

        _mainView!!.onLoading()
        apiInterface.enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>?) {
                println("$response")
                mutableResultData.value =response!!.body()!!.results
                _mainView!!.onSuccess("success result size ${response!!.body()!!.results.size}")
                insertData(response!!.body()!!.results)
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                println("${t.message}")
                _mainView!!.onFailure("Failure")
            }
        })
    }

    private fun insertData(resltData: List<ResultData>) {
        GlobalScope.launch {
            db.resutDataDao().insertAll(resltData)
        }
    }


}