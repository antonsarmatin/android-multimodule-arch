package tech.inno.dion.feature.home.internal.di

import com.example.core.presentation.di.ScreenModelProvidersComponent
import dagger.Component
import com.example.core.presentation.di.PerFeature
import tech.inno.dion.feature.home.api.HomeApi
import tech.inno.dion.feature.home.api.HomeDependencies
import tech.inno.dion.feature.home.internal.ui.HomeScreen

@Component(
    dependencies = [HomeDependencies::class],
    modules = [HomeModule::class]
)
@PerFeature
internal abstract class HomeComponent : HomeApi {

    //Get screen model provider as child subcomponent
    internal abstract val screenModelProvider: ScreenModelProvidersComponent

    companion object {
        fun initAndGet(homeDependencies: HomeDependencies): HomeComponent {
            return DaggerHomeComponent.builder()
                .homeDependencies(homeDependencies)
                .build()
        }
    }

}