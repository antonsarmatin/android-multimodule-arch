package tech.inno.dion.feature.home.internal.ui

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.core.presentation.di.PerFeature
import com.example.core.presentation.navigation.tab.BadgeTab
import com.example.core.presentation.navigation.tab.TabBadgeOptions
import com.example.core.presentation.navigation.tab.TabBadgeProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

internal class HomeTab(
    tabBadgeProvider: TabBadgeProvider
) : BadgeTab {

    @Composable
    override fun Content() {
        Navigator(screen = HomeScreen)
    }

    //todo not serializable?
    override val badgeProvider: TabBadgeProvider = tabBadgeProvider

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


@PerFeature
class HomeTabBadgeProvider @Inject constructor(
    private val manager: HomeTabBadgeManager
) : TabBadgeProvider {

    override val badgeFlow: Flow<TabBadgeOptions> = manager.badgeFlow

}

class HomeTabBadgeManager {

    private val _badgeFlow = MutableStateFlow(TabBadgeOptions())
    val badgeFlow: Flow<TabBadgeOptions> = _badgeFlow

    fun setBadge(state: Boolean) = _badgeFlow.update {
        Log.d("BADGE","set: $state")
        it.copy(state = state)
    }

}

