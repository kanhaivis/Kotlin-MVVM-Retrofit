package kk.mvp

interface MainView {
    fun onLoading()
    fun onSuccess(msg: String)
    fun onFailure(e: String)
    fun onSubmit()
}