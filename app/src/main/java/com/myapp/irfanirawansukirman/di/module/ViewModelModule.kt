package com.myapp.irfanirawansukirman.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.myapp.irfanirawansukirman.di.AppVMFactory
import com.myapp.irfanirawansukirman.di.ViewModelKey
import com.myapp.irfanirawansukirman.mvvm.movie.MovieVM
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
    abstract fun bindsViewModelFactory(viewModelFactory: AppVMFactory): ViewModelProvider.Factory

}