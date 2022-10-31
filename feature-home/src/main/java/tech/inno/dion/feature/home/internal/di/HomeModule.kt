package tech.inno.dion.feature.home.internal.di

import com.example.core.presentation.di.ScreenModelFactory
import com.example.core.presentation.di.ScreenModelFactoryKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.example.core.presentation.di.PerFeature
import tech.inno.dion.feature.home.api.HomeStarter
import tech.inno.dion.feature.home.internal.start.HomeStarterImpl
import tech.inno.dion.feature.home.internal.ui.HomeScreenModel

@Module
internal abstract class HomeModule {

    @Binds
    @PerFeature
    abstract fun bindStarter(impl: HomeStarterImpl): HomeStarter

    //region ScreenModel
    @Binds
    @IntoMap
    @ScreenModelFactoryKey(HomeScreenModel.Factory::class)
    abstract fun bindHomeScreenModelFactory(
        factory: HomeScreenModel.Factory
    ) : ScreenModelFactory
    //endregion


}