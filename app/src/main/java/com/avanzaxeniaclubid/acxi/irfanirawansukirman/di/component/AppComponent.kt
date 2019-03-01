package com.avanzaxeniaclubid.acxi.irfanirawansukirman.di.component

import com.avanzaxeniaclubid.acxi.irfanirawansukirman.AxciApp
import com.avanzaxeniaclubid.acxi.irfanirawansukirman.di.builder.ActivityBuilder
import com.avanzaxeniaclubid.acxi.irfanirawansukirman.di.module.*
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class, ActivityBuilder::class, AppModule::class]
)
interface AppComponent : AndroidInjector<AxciApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<AxciApp>() {

    }

}