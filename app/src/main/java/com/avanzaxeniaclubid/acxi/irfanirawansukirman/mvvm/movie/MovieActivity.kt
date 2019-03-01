package com.avanzaxeniaclubid.acxi.irfanirawansukirman.mvvm.movie

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.util.Log
import com.avanzaxeniaclubid.acxi.irfanirawansukirman.R
import com.avanzaxeniaclubid.acxi.irfanirawansukirman.base.BaseActivity
import com.google.gson.Gson
import id.ac.unpad.profolio.util.ext.showToast

class MovieActivity : BaseActivity<MovieVM>() {

    override fun onGetViewModel(): Class<MovieVM> = MovieVM::class.java

    override fun onBindLayout() = R.layout.news_activity

    override fun onBindToolbarId() = DEFAULT_TOOLBAR_EMPTY

    override fun onStartJobs(savedInstanceState: Bundle?) {

    }

    override fun onObserverVM(viewModel: MovieVM?) {
        viewModel?.apply {
            onGetMovieList().observe(this@MovieActivity, Observer {
                showToast(Gson().toJson(it))
//                if (it != null) {
//                }
            })
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}
