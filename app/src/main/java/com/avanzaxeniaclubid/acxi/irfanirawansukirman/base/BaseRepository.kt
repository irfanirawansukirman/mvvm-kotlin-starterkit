package com.avanzaxeniaclubid.acxi.irfanirawansukirman.base

import io.reactivex.disposables.CompositeDisposable

abstract class BaseRepository {

    var rxDisposable: CompositeDisposable? = null

    abstract fun onClearDisposable()

}
