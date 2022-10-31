package tech.inno.dion.feature.details.api

import com.example.core.network.NetworkClient
import com.example.core.presentation.feature.FeatureDependencies

interface DetailsDependencies : FeatureDependencies {
    fun networkClient(): NetworkClient
}