package tech.inno.dion.integration.api

import com.example.core.network.NetworkClient
import com.example.core.presentation.feature.FeatureApi

interface IntegrationApi : FeatureApi {

    val networkClient: NetworkClient

}