package com.avanzaxeniaclubid.acxi.irfanirawansukirman.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.avanzaxeniaclubid.acxi.irfanirawansukirman.di.AxciVMFactory
import com.avanzaxeniaclubid.acxi.irfanirawansukirman.di.ViewModelKey
import com.avanzaxeniaclubid.acxi.irfanirawansukirman.mvvm.movie.MovieVM
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MovieVM::class)
    abstract fun bindNewsVM(movieVM: MovieVM): ViewModel

    @Binds
    abstract fun bindsViewModelFactory(viewModelFactory: AxciVMFactory): ViewModelProvider.Factory

}