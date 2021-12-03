package kk.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kk.database.MyDataBase
import kk.database.entity.User
import kk.factory.MainFactory
import kk.model.ResultData
import kk.model.UserResponse
import kk.mvp.MainView
import kk.mvp.UserMainPresenter
import kk.mvvm.MainViewModel
import kk.network.ApiCall
import kk.repository.MainRepository
import kk.roommvvmratrofitdemo.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), MainView {

    private var msgTxt: TextView? = null
    private var submitTxt: TextView? = null
    private var progressBar: ProgressBar? = null

    /// MVP
    lateinit var mainPresenter: UserMainPresenter

    /// MVVM
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        msgTxt = findViewById(R.id.textView)
        submitTxt = findViewById(R.id.submit)
        progressBar = findViewById(R.id.progressBar)

        /// ROOM DATABASE
        val db = MyDataBase(this)

        val repository = MainRepository(this, db)
        mainViewModel = ViewModelProvider(this, MainFactory(repository)).get(MainViewModel::class.java)



        submitTxt!!.setOnClickListener {

            /// MVP design patterns
//           mainPresenter.onApiCall()

            /// MVVM design patterns
            mainViewModel.getDataResponse("10")
        }

        mainViewModel.resultDataList.observe(this, Observer {
            println("$it")
        })



    }


    override fun onLoading() {
        println("")
        progressBar!!.visibility = View.VISIBLE
    }

    override fun onSuccess(msg: String) {
        println("")
        progressBar!!.visibility = View.GONE
        msgTxt!!.text = msg
    }

    override fun onFailure(e: String) {
        println("")
    }

    override fun onSubmit() {

    }
}