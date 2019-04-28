package com.myapp.irfanirawansukirman.mvvm.movie

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.widget.Toast
import com.myapp.irfanirawansukirman.R
import com.myapp.irfanirawansukirman.base.BaseActivity
import com.google.gson.Gson

class MovieActivity : BaseActivity<MovieVM>() {

    override fun onGetViewModel(): Class<MovieVM> = MovieVM::class.java

    override fun onBindLayout() = R.layout.movie_activity

    override fun onBindToolbarId() = DEFAULT_TOOLBAR_EMPTY

    override fun onStartJobs(savedInstanceState: Bundle?) {

    }

    override fun onObserverVM(viewModel: MovieVM?) {
        viewModel?.apply {
            onGetMovieList().observe(this@MovieActivity, Observer {
                Toast.makeText(this@MovieActivity, Gson().toJson(it), Toast.LENGTH_SHORT).show()
            })
        }
    }

}
