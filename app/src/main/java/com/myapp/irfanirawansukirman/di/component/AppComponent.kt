package com.myapp.irfanirawansukirman.di.component

import com.myapp.irfanirawansukirman.MyApp
import com.myapp.irfanirawansukirman.di.builder.ActivityBuilder
import com.myapp.irfanirawansukirman.di.module.*
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class, ActivityBuilder::class, AppModule::class]
)
interface AppComponent : AndroidInjector<MyApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MyApp>() {

    }

}