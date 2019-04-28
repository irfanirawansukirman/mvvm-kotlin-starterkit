package com.myapp.irfanirawansukirman.mvvm.movie

import com.myapp.irfanirawansukirman.base.BaseViewModel
import com.myapp.irfanirawansukirman.data.source.AxciRepository
import javax.inject.Inject

class MovieVM @Inject constructor(private val axciRepository: AxciRepository) : BaseViewModel() {

    fun onGetMovieList() = axciRepository.getMovieList()

    override fun onCleared() {
        axciRepository.onClearDisposable()
        super.onCleared()
    }

}