package tech.inno.dion.feature.home.internal.di

import com.example.core.presentation.feature.FeatureComponentHolder
import tech.inno.dion.feature.home.api.HomeApi
import tech.inno.dion.feature.home.api.HomeDependencies

object HomeComponentHolder : FeatureComponentHolder<HomeApi, HomeDependencies> {

    private var homeComponent: HomeComponent? = null

    override fun init(dependencies: HomeDependencies) {
        if(homeComponent == null){
            synchronized(HomeComponentHolder::class.java) {
                if(homeComponent == null) {
                    homeComponent = HomeComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): HomeApi = getComponent()

    internal fun getComponent(): HomeComponent {
        checkNotNull(homeComponent) { "Home component was not initialized" }
        return homeComponent!!
    }

    override fun reset() {
        homeComponent = null
    }
}