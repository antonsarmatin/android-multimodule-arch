package tech.inno.dion.feature.home.internal.ui.tab

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.core.presentation.navigation.tab.BadgeTab
import com.example.core.presentation.navigation.tab.TabBadgeProvider
import tech.inno.dion.feature.home.internal.di.HomeComponentHolder
import tech.inno.dion.feature.home.internal.ui.screen.HomeScreen

internal object HomeTab : BadgeTab {

    @Composable
    override fun Content() {
        Navigator(screen = HomeScreen)
    }

    override val badgeProvider: TabBadgeProvider
        get() = HomeComponentHolder.getComponent().tabBadgeProvider

    override val options: TabOptions
        @Composable
        get() {
            val icon = rememberVectorPainter(Icons.Default.Home)
            return remember {
                TabOptions(
                    index = 0u,
                    title = "Home",
                    icon = icon
                )
            }
        }
}

