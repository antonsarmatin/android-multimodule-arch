package tech.inno.dion.feature.details.internal.di

import dagger.Component
import com.example.core.presentation.di.PerFeature
import tech.inno.dion.feature.details.api.DetailsApi
import tech.inno.dion.feature.details.api.DetailsDependencies
import tech.inno.dion.feature.details.internal.ui.DetailsScreenModel

@Component(
    dependencies = [DetailsDependencies::class],
    modules = [DetailsModule::class]
)
@PerFeature
internal interface DetailsComponent : DetailsApi {

    companion object {
        //Можно и через Component.Factory, но тогда протечет более явно в ComponentHolder
        fun initAndGet(detailsDependencies: DetailsDependencies): DetailsComponent {
            return DaggerDetailsComponent.builder()
                .detailsDependencies(detailsDependencies)
                .build()
        }
    }

    val detailsScreenModelFactory: DetailsScreenModel.Factory

}