package com.myapp.irfanirawansukirman.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.view.MenuItem
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
abstract class BaseActivity<VM : ViewModel> : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(onBindLayout())
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(onGetViewModel())

        onStartJobs(savedInstanceState)
        onObserverVM(viewModel)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = if (item?.itemId == android.R.id.home) {
        finish()
        true
    } else {
        false
    }

    abstract fun onGetViewModel(): Class<VM>
    abstract fun onStartJobs(savedInstanceState: Bundle?)
    abstract fun onObserverVM(viewModel: VM?)

    @LayoutRes
    abstract fun onBindLayout(): Int

    @IdRes
    abstract fun onBindToolbarId(): Int

    companion object {
        const val DEFAULT_TOOLBAR_EMPTY = 0
    }
}