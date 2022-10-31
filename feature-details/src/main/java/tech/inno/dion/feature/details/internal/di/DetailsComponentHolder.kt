package tech.inno.dion.feature.details.internal.di

import com.example.core.presentation.feature.FeatureComponentHolder
import tech.inno.dion.feature.details.api.DetailsApi
import tech.inno.dion.feature.details.api.DetailsDependencies

object DetailsComponentHolder : FeatureComponentHolder<DetailsApi, DetailsDependencies> {

    private var detailsComponent: DetailsComponent? = null

    override fun init(dependencies: DetailsDependencies) {
        if (detailsComponent == null) {
            synchronized(DetailsComponentHolder::class.java) {
                if (detailsComponent == null) {
                    detailsComponent = DetailsComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): DetailsApi = getComponent()

    internal fun getComponent(): DetailsComponent {
        checkNotNull(detailsComponent) { "DetailsComponent was not initialized!" }
        return detailsComponent!!
    }

    override fun reset() {
        detailsComponent = null
    }
}