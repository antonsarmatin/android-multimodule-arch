package com.example.core.presentation.foundation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow

abstract class StateScreen<A, S> : Screen {

    @Composable
    override fun Content() {
        val model = bindModel(LocalNavigator.currentOrThrow)
        val state by model.state.collectAsState()

        ScreenContent(
            state = state,
            onAction = model::onAction
        )
    }

    @Composable
    abstract fun ScreenContent(
        state: S,
        onAction: (A) -> Unit
    )

    @Composable
    abstract fun bindModel(navigator: Navigator): BaseScreenModel<A, S>

}


