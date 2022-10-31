package tech.inno.dion.feature.details.internal.di

import com.example.core.presentation.di.ScreenModelFactory
import com.example.core.presentation.di.ScreenModelFactoryKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.example.core.presentation.di.PerFeature
import tech.inno.dion.feature.details.api.DetailsStarter
import tech.inno.dion.feature.details.internal.start.DetailsStarterImpl
import tech.inno.dion.feature.details.internal.ui.DetailsScreenModel

@Module
internal abstract class DetailsModule {

    @Binds
    @PerFeature
    abstract fun bindStarter(impl: DetailsStarterImpl) : DetailsStarter

}