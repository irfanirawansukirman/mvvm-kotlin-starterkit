package com.myapp.irfanirawansukirman.data.source

import com.myapp.irfanirawansukirman.base.BaseResponse
import com.google.gson.Gson
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Created by irfanirawansukirman on 26/01/18.
 */

abstract class ApiCallback<M> : SingleObserver<M> {

    abstract fun onApiSucess(data: M)
    abstract fun onApiError(code: Int, errorMessage: String)
    abstract fun onAddSubscribe(disposable: Disposable)
    abstract fun onCompleted()

    override fun onError(e: Throwable) {
        onCompleted()
        e.printStackTrace()
        when (e) {
            is HttpException -> {
                val code = e.code()
                var msg = e.message()
                var baseDao: BaseResponse<M>? = null
                try {
                    val body = e.response().errorBody()
                    baseDao = Gson().fromJson<BaseResponse<M>>(body!!.string(), BaseResponse::class.java)
                } catch (exception: Exception) {
                    onApiError(code, exception.message!!)
                }

                when (code) {
                    504 -> {
                        msg = baseDao?.message ?: "Error Response"
                    }
                    502, 404 -> {
                        msg = baseDao?.message ?: "Error Connect or Resource Not Found"
                    }
                    400 -> {
                        msg = baseDao?.message ?: "Bad Request"
                    }
                    401 -> {
                        msg = baseDao?.message ?: "Not Authorized"
                    }
                }

                onApiError(code, msg)
            }

            is UnknownHostException -> onApiError(-1, "Telah terjadi kesalahan ketika koneksi ke server: ${e.message}")
            is SocketTimeoutException -> onApiError(-1, "Telah terjadi kesalahan ketika koneksi ke server: ${e.message}")
            else -> onApiError(-1, e.message ?: "Unknown error occured")
        }
    }

    override fun onSubscribe(d: Disposable) {
        onAddSubscribe(d)
    }

    override fun onSuccess(t: M) {
        onCompleted()

        if (t == null) {
            onApiError(200, "Data is empty")
        } else {
            onApiSucess(t)
        }
    }
}
