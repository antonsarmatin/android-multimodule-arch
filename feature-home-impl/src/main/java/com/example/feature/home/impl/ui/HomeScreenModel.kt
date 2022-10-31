package com.example.feature.home.impl.ui

import cafe.adriel.voyager.hilt.ScreenModelFactory
import cafe.adriel.voyager.navigator.Navigator
import com.example.core.network.NetworkManager
import com.example.core.presentation.foundation.BaseScreenModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.update

class HomeScreenModel @AssistedInject constructor(
    @Assisted navigator: Navigator,
    private val networkManager: NetworkManager,
) : BaseScreenModel<HomeScreen.Action, HomeScreen.State>(
    navigator = navigator,
    initialState = HomeScreen.State(
        network = networkManager.getNetwork()
    )
) {

    @AssistedFactory
    interface Factory : ScreenModelFactory {
        fun create(navigator: Navigator): HomeScreenModel
    }

    override fun onAction(action: HomeScreen.Action) {
        when (action) {
            HomeScreen.Action.GoToDetails -> {
                //TODO push
            }
            is HomeScreen.Action.Input -> _state.update { it.copy(text = action.value) }
        }
    }
}