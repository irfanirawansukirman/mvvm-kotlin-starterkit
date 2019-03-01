package com.avanzaxeniaclubid.acxi.irfanirawansukirman.di.builder

import com.avanzaxeniaclubid.acxi.irfanirawansukirman.mvvm.movie.MovieActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindNewsActivity(): MovieActivity

}