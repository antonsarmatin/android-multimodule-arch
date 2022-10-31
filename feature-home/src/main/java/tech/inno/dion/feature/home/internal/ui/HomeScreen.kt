package tech.inno.dion.feature.home.internal.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator
import com.example.core.presentation.di.getScreenModel
import com.example.core.presentation.foundation.BaseScreenModel
import com.example.core.presentation.foundation.StateScreen
import tech.inno.dion.feature.home.internal.di.HomeComponentHolder

object HomeScreen : StateScreen<HomeScreen.Action, HomeScreen.State>() {


    init {
        HomeComponentHolder.getComponent().injectHomeScreen(this)
    }

    @Composable
    override fun ScreenContent(state: State, onAction: (Action) -> Unit) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.input,
                onValueChange = { onAction(Action.Input(it)) }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { onAction(Action.GoToDetailsClick) },
                enabled = state.input.isNotBlank()
            ) {
                Text(text = "Go to Details")
            }
        }
    }

    @Composable
    override fun bindModel(navigator: Navigator): BaseScreenModel<Action, State> {
        return getScreenModel<HomeScreenModel, HomeScreenModel.Factory>(
            provider = HomeComponentHolder.getComponent().screenModelProvider
        ) { factory -> factory.create(navigator) }
    }

    sealed class Action {
        data class Input(val value: String) : Action()
        object GoToDetailsClick : Action()
    }

    data class State(
        val input: String = "",
        val isLoading: Boolean = false
    )

}



