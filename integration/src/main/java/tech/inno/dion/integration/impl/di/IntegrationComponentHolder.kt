package tech.inno.dion.integration.impl.di

import com.example.core.presentation.feature.FeatureComponentHolder
import tech.inno.dion.integration.api.IntegrationApi
import tech.inno.dion.integration.api.IntegrationDependencies

object IntegrationComponentHolder : FeatureComponentHolder<IntegrationApi, IntegrationDependencies> {

    private var integrationComponent: IntegrationComponent? = null

    override fun init(dependencies: IntegrationDependencies) {
        if(integrationComponent == null){
            synchronized(IntegrationComponentHolder::class.java){
                if(integrationComponent == null){
                    integrationComponent = IntegrationComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): IntegrationApi = getComponent()

    internal fun getComponent() : IntegrationComponent {
        checkNotNull(integrationComponent) { "Home component was not initialized" }
        return integrationComponent!!
    }

    override fun reset() {
        integrationComponent = null
    }
}