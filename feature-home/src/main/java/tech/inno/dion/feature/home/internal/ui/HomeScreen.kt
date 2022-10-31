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

object HomeScreen : StateScreen<HomeScreenAction, HomeScreenState>() {

    @Composable
    override fun ScreenContent(state: HomeScreenState, onAction: (HomeScreenAction) -> Unit) {
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
                onValueChange = { onAction(HomeScreenAction.Input(it)) }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { onAction(HomeScreenAction.GoToDetailsClick) },
                enabled = state.input.isNotBlank()
            ) {
                Text(text = "Go to Details")
            }
        }
    }

    @Composable
    override fun bindModel(navigator: Navigator): BaseScreenModel<HomeScreenAction, HomeScreenState> {
        return getScreenModel<HomeScreenModel, HomeScreenModel.Factory>(
            provider = HomeComponentHolder.getComponent().screenModelProvider
        ) { factory -> factory.create(navigator) }
    }

}



