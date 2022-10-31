package com.example.multimodule.di

import android.content.Context
import com.example.core.network.NetworkClient
import com.example.multimodule.App
import com.example.multimodule.routing.AppRouter
import com.example.multimodule.BuildConfig
import dagger.Module
import dagger.Provides
import tech.inno.dion.feature.details.api.DetailsApi
import tech.inno.dion.feature.details.api.DetailsDependencies
import tech.inno.dion.feature.details.internal.di.DetailsComponentHolder
import tech.inno.dion.feature.home.api.NavigateToDetails
import tech.inno.dion.feature.home.api.HomeApi
import tech.inno.dion.feature.home.api.HomeDependencies
import tech.inno.dion.feature.home.internal.di.HomeComponentHolder
import tech.inno.dion.integration.api.IntegrationApi
import tech.inno.dion.integration.api.IntegrationDependencies
import tech.inno.dion.integration.impl.di.IntegrationComponentHolder
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideContext(): Context {
        return App.appContext
    }

    @Singleton
    @Provides
    fun provideAppRouter(
        detailsApi: DetailsApi
    ): AppRouter = AppRouter(
        detailsApi
    )

    //Can be placed in feature-specific modules
    //region integration
    @Singleton
    @Provides
    fun provideIntegrationDependencies(): IntegrationDependencies {
        return object : IntegrationDependencies {
            override fun appVersion(): String = BuildConfig.VERSION_NAME
        }
    }

    @Provides
    fun provideFeatureIntegration(dependencies: IntegrationDependencies): IntegrationApi {
        IntegrationComponentHolder.init(dependencies)
        return IntegrationComponentHolder.get()
    }

    //endregion

    //region details
    @Singleton
    @Provides
    fun provideDetailsDependencies(
        integrationApi: IntegrationApi
    ): DetailsDependencies {
        return object : DetailsDependencies {
            override fun networkClient(): NetworkClient = integrationApi.networkClient
        }
    }

    @Provides
    fun provideFeatureDetails(dependencies: DetailsDependencies): DetailsApi {
        DetailsComponentHolder.init(dependencies)
        return DetailsComponentHolder.get()
    }
    //endregion

    //region home
    @Singleton
    @Provides
    fun provideHomeDependencies(
        appRouter: AppRouter
    ): HomeDependencies {
        return object : HomeDependencies {
            override fun navigateToDetails(): NavigateToDetails = appRouter
        }
    }

    @Provides
    fun provideFeatureHome(dependencies: HomeDependencies): HomeApi {
        HomeComponentHolder.init(dependencies)
        return HomeComponentHolder.get()
    }
    //endregion
}