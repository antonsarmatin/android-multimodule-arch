package tech.inno.dion.feature.details.internal.di

import dagger.Binds
import dagger.Module
import com.example.core.presentation.di.PerFeature
import tech.inno.dion.feature.details.api.DetailsStarter
import tech.inno.dion.feature.details.internal.start.DetailsStarterImpl

@Module
internal abstract class DetailsModule {

    @Binds
    @PerFeature
    abstract fun bindStarter(impl: DetailsStarterImpl) : DetailsStarter

}