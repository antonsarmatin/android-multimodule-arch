package tech.inno.dion.integration.api

import com.example.core.presentation.feature.FeatureDependencies

interface IntegrationDependencies : FeatureDependencies {

    fun appVersion(): String

}