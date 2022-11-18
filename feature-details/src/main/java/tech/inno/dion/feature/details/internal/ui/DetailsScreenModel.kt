package tech.inno.dion.feature.details.internal.ui

import cafe.adriel.voyager.navigator.Navigator
import com.example.core.network.NetworkClient
import com.example.core.presentation.di.ScreenModelFactory
import com.example.core.presentation.foundation.BaseScreenModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class DetailsScreenModel @AssistedInject constructor(
    @Assisted navigator: Navigator,
    @Assisted info: String,
    networkClient: NetworkClient,
) : BaseScreenModel<DetailsScreenAction, DetailsScreenEvent, DetailsScreenState>(
    navigator = navigator,
    initialState = DetailsScreenState(
        info = info,
        networkData = networkClient.call()
    )
) {

    @AssistedFactory
    interface Factory : ScreenModelFactory {
        fun create(
            navigator: Navigator,
            info: String
        ): DetailsScreenModel
    }


    override fun onAction(action: DetailsScreenAction) {

    }

}