package com.myapp.irfanirawansukirman.di.builder

import com.myapp.irfanirawansukirman.mvvm.movie.MovieActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindNewsActivity(): MovieActivity

}