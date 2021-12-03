package kk.mvp

import kk.database.MyDataBase
import kk.model.ResultData
import kk.model.UserResponse
import kk.network.ApiCall
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserMainPresenter(var _mainView: MainView?, var db: MyDataBase) : MainPresenter {

    override fun onApiCall() {

        val apiInterface = ApiCall.create().getMovies("2")

        _mainView!!.onLoading()
        apiInterface.enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>?) {
                println("$response")
                _mainView!!.onSuccess("success result size ${response!!.body()!!.results.size}")
                insertData(response!!.body()!!.results)
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                println("${t.message}")
                _mainView!!.onFailure("Failure")
            }
        })
    }

    override fun onInsertData() {
    }

    override fun onSelectAll() {
    }

    private fun insertData(resltData: List<ResultData>) {
        GlobalScope.launch {
            db.resutDataDao().insertAll(resltData)
        }
    }

     fun selectData() {


        GlobalScope.launch {
            var resultDatas = db.resutDataDao().getAll()
            println("${resultDatas.size}")
            /*resultDatas?.forEach {
                println(it)
            }*/

        }
    }



}