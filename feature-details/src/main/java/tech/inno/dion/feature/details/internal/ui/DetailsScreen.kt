package tech.inno.dion.feature.details.internal.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator
import com.example.core.presentation.di.getScreenModel
import com.example.core.presentation.foundation.BaseScreenModel
import com.example.core.presentation.foundation.BaseScreen
import tech.inno.dion.feature.details.internal.di.DetailsComponentHolder

data class DetailsScreen(
    private val info: String
) : BaseScreen<DetailsScreenAction, DetailsScreenEvent, DetailsScreenState>() {

    @Composable
    override fun ScreenContent(state: DetailsScreenState, onAction: (DetailsScreenAction) -> Unit) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Info:")
            Text(state.info)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Network:")
            Text(state.networkData)
        }
    }

    @Composable
    override fun bindModel(navigator: Navigator): BaseScreenModel<DetailsScreenAction, DetailsScreenEvent, DetailsScreenState> {
        return getScreenModel {
            DetailsComponentHolder.getComponent().detailsScreenModelFactory.create(navigator, info)
        }
    }
}
