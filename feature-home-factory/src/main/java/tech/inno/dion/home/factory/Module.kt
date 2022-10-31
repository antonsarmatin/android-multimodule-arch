package tech.inno.dion.home.factory

import com.example.feature.home.HomeFeatureApi
import com.example.feature.home.impl.HomeFeatureImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class Module {

    @Provides
    @ActivityScoped
    fun provideFeature(): HomeFeatureApi = HomeFeatureImpl()

}