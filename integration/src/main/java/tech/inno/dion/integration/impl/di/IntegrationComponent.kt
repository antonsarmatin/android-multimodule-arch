package tech.inno.dion.integration.impl.di

import com.example.core.presentation.di.PerFeature
import dagger.Component
import tech.inno.dion.integration.api.IntegrationApi
import tech.inno.dion.integration.api.IntegrationDependencies

@Component(
    dependencies = [IntegrationDependencies::class],
    modules = [IntegrationModule::class]
)
@PerFeature
internal abstract class IntegrationComponent : IntegrationApi {

    companion object {
        fun initAndGet(integrationDependencies: IntegrationDependencies): IntegrationComponent {
            return DaggerIntegrationComponent.builder()
                .integrationDependencies(integrationDependencies)
                .build()
        }
    }

}