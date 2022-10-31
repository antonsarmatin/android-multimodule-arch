package com.example.multimodule

import android.app.Application
import android.content.Context
import com.example.multimodule.di.AppComponent
import com.example.multimodule.di.DaggerAppComponent

class App : Application() {


    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        AppComponent.init(
            DaggerAppComponent.builder()
                .build()
        )
        AppComponent.get().inject(this)
    }

    companion object {
        @Volatile
        lateinit var appContext: Context
            private set
    }

}