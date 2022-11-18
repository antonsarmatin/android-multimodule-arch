package tech.inno.dion.feature.home.internal.ui.screen

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
import com.example.core.presentation.foundation.BaseScreen
import tech.inno.dion.feature.home.internal.di.HomeComponentHolder

object HomeScreen : BaseScreen<HomeScreenAction, HomeScreenEvent, HomeScreenState>() {

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
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "Badge")
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Button(
                    modifier = Modifier.weight(1f),
                    onClick = { onAction(HomeScreenAction.EnableBadgeClick) },
                ) {
                    Text(text = "Enable")
                }
                Spacer(modifier = Modifier.width(4.dp))
                Button(
                    modifier = Modifier.weight(1f),
                    onClick = { onAction(HomeScreenAction.DisableBadgeClick) },
                ) {
                    Text(text = "Disable")
                }
            }
        }
    }

    @Composable
    override fun bindModel(navigator: Navigator): BaseScreenModel<HomeScreenAction, HomeScreenEvent, HomeScreenState> {
        return getScreenModel {
            HomeComponentHolder.getComponent().homeScreenModelFactory.create(navigator)
        }
    }

}



