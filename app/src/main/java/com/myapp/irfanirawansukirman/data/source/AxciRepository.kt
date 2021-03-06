package com.myapp.irfanirawansukirman.data.source

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.myapp.irfanirawansukirman.base.BaseRepository
import com.myapp.irfanirawansukirman.base.BaseResponse
import com.myapp.irfanirawansukirman.data.model.Movie
import com.myapp.irfanirawansukirman.data.source.remote.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AxciRepository @Inject constructor(private val apiService: ApiService) : BaseRepository() {

    init {
        rxDisposable = CompositeDisposable()
    }

    fun getMovieList(): MutableLiveData<List<Movie>> {
        val movieLiveData = MutableLiveData<List<Movie>>()

        apiService
            .getMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ApiCallback<BaseResponse<List<Movie>>>() {
                override fun onApiSucess(data: BaseResponse<List<Movie>>) {
                    movieLiveData.postValue(data.results)
                }

                override fun onApiError(code: Int, errorMessage: String) {
                    Log.e(AxciRepository::class.java.simpleName, "$code $errorMessage")
                }

                override fun onAddSubscribe(disposable: Disposable) {
                    rxDisposable?.add(disposable)
                }

                override fun onCompleted() {

                }
            })

        return movieLiveData
    }

    override fun onClearDisposable() {
        rxDisposable?.clear()
    }

}