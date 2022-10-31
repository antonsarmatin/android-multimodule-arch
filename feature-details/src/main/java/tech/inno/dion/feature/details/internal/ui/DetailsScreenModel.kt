package tech.inno.dion.feature.details.internal.ui

import cafe.adriel.voyager.core.model.ScreenModel
import com.example.core.network.NetworkClient
import com.example.core.presentation.di.ScreenModelFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class DetailsScreenModel @AssistedInject constructor(
    @Assisted val assistedData: String,
    private val networkClient: NetworkClient,
) : ScreenModel {

    val networkData: String = networkClient.call()

    @AssistedFactory
    interface Factory : ScreenModelFactory {
        fun create(assistedData: String): DetailsScreenModel
    }

}