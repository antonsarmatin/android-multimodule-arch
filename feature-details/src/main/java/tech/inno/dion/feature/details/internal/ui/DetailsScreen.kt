package tech.inno.dion.feature.details.internal.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.example.core.presentation.di.getScreenModel
import tech.inno.dion.feature.details.internal.di.DetailsComponentHolder

data class DetailsScreen(
    private val info: String
) : Screen {

    init {
        DetailsComponentHolder.getComponent().injectDetailsScreen(this)
    }

    @Composable
    override fun Content() {
        val model = getScreenModel<DetailsScreenModel, DetailsScreenModel.Factory>(
            provider = DetailsComponentHolder.getComponent().screenModelProvider
        ) { factory ->
            factory.create("Assisted: $info")
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Info:")
            Text(model.assistedData)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Network:")
            Text(model.networkData)
        }
    }
}

