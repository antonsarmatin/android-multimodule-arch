package tech.inno.dion.feature.details.internal.di

import com.example.core.presentation.di.ScreenModelProvidersComponent
import dagger.Component
import com.example.core.presentation.di.PerFeature
import tech.inno.dion.feature.details.api.DetailsApi
import tech.inno.dion.feature.details.api.DetailsDependencies
import tech.inno.dion.feature.details.internal.ui.DetailsScreen

@Component(
    dependencies = [DetailsDependencies::class],
    modules = [DetailsModule::class]
)
@PerFeature
internal abstract class DetailsComponent : DetailsApi {

    //Get screen model provider as child subcomponent
    internal abstract val screenModelProvider: ScreenModelProvidersComponent

    internal abstract fun injectDetailsScreen(detailsScreen: DetailsScreen)

    companion object {
        //Можно и через Component.Factory, но тогда протечет более явно в ComponentHolder
        fun initAndGet(detailsDependencies: DetailsDependencies): DetailsComponent {
            return DaggerDetailsComponent.builder()
                .detailsDependencies(detailsDependencies)
                .build()
        }
    }

}