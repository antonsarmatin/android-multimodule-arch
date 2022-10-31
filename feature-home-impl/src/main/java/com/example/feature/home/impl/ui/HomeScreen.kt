package com.example.feature.home.impl.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.hilt.getScreenModel
import cafe.adriel.voyager.navigator.Navigator
import com.example.core.presentation.foundation.BaseScreenModel
import com.example.core.presentation.foundation.StateScreen

object HomeScreen : StateScreen<HomeScreen.Action, HomeScreen.State>() {

    @Composable
    override fun ScreenContent(state: State, onAction: (Action) -> Unit) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = state.network)
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = state.text,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {
                    onAction(Action.Input(it))
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { onAction(Action.GoToDetails) }
            ) {
                Text("Go to Details")
            }
        }
    }

    @Composable
    override fun bindModel(navigator: Navigator): BaseScreenModel<Action, State> =
        getScreenModel<HomeScreenModel, HomeScreenModel.Factory> { factory ->
            factory.create(navigator)
        }

    sealed class Action {
        data class Input(val value: String) : Action()
        object GoToDetails : Action()
    }

    data class State(
        val text: String = "",
        val network: String = "",
        val loading: Boolean = false
    )

}

