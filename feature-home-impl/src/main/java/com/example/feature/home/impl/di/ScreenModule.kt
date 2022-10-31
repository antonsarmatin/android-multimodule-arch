package com.example.feature.home.impl.di

import cafe.adriel.voyager.hilt.ScreenModelFactory
import cafe.adriel.voyager.hilt.ScreenModelFactoryKey
import com.example.feature.home.impl.ui.HomeScreenModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(ActivityComponent::class)
abstract class ScreenModule {

    @Binds
    @IntoMap
    @ScreenModelFactoryKey(HomeScreenModel.Factory::class)
    abstract fun bindHomeScreenModelFactory(
        detailScreenModelFactory: HomeScreenModel.Factory
    ) : ScreenModelFactory

}