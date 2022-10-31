package com.example.multimodule.di

import com.example.multimodule.App
import com.example.multimodule.MainActivity
import dagger.Component
import dagger.internal.Preconditions
import javax.inject.Singleton

@Component(
    modules = [
        AppModule::class
    ]
)
@Singleton
abstract class AppComponent {

    abstract fun inject(app: App)
    abstract fun inject(mainActivity: MainActivity)

    companion object {

        @Volatile
        private var instance: AppComponent? = null

        fun get(): AppComponent {
            return Preconditions.checkNotNull(instance, "AppComponent was not initialized")!!
        }

        fun init(component: AppComponent) {
            require(instance == null) { "AppComponent is already initialized." }
            instance = component
        }

    }

}