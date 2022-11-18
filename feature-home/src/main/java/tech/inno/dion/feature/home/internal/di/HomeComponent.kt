package tech.inno.dion.feature.home.internal.di

import dagger.Component
import com.example.core.presentation.di.PerFeature
import com.example.core.presentation.navigation.tab.TabBadgeProvider
import tech.inno.dion.feature.home.api.HomeApi
import tech.inno.dion.feature.home.api.HomeDependencies
import tech.inno.dion.feature.home.internal.ui.screen.HomeScreenModel

@Component(
    dependencies = [HomeDependencies::class],
    modules = [HomeModule::class]
)
@PerFeature
internal interface HomeComponent : HomeApi {

    companion object {
        fun initAndGet(homeDependencies: HomeDependencies): HomeComponent {
            return DaggerHomeComponent.builder()
                .homeDependencies(homeDependencies)
                .build()
        }
    }

    val tabBadgeProvider: TabBadgeProvider
    val homeScreenModelFactory: HomeScreenModel.Factory

}