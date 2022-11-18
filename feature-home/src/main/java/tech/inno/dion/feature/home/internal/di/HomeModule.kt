package tech.inno.dion.feature.home.internal.di

import dagger.Binds
import dagger.Module
import com.example.core.presentation.di.PerFeature
import dagger.Provides
import tech.inno.dion.feature.home.api.HomeStarter
import tech.inno.dion.feature.home.internal.start.HomeStarterImpl
import tech.inno.dion.feature.home.internal.ui.tab.HomeTabBadgeManager
import tech.inno.dion.feature.home.internal.ui.tab.HomeTabBadgeProvider
import com.example.core.presentation.navigation.tab.TabBadgeProvider

@Module
internal abstract class HomeModule {

    @Binds
    @PerFeature
    abstract fun bindStarter(impl: HomeStarterImpl): HomeStarter

    @Binds
    @PerFeature
    abstract fun bindBadgeProvider(impl: HomeTabBadgeProvider): TabBadgeProvider

    companion object {

        @Provides
        @PerFeature
        fun provideBadgeManager() = HomeTabBadgeManager()
    }

}