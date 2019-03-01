package com.avanzaxeniaclubid.acxi.irfanirawansukirman.mvvm.movie

import com.avanzaxeniaclubid.acxi.irfanirawansukirman.base.BaseViewModel
import com.avanzaxeniaclubid.acxi.irfanirawansukirman.data.source.AxciRepository
import javax.inject.Inject

class MovieVM @Inject constructor(private val axciRepository: AxciRepository) : BaseViewModel() {

    fun onGetMovieList() = axciRepository.getMovieList()

    override fun onCleared() {
        axciRepository.onClearDisposable()
        super.onCleared()
    }

}