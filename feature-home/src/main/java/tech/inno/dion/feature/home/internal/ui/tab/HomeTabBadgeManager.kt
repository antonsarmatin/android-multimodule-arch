package tech.inno.dion.feature.home.internal.ui.tab

import android.util.Log
import com.example.core.presentation.navigation.tab.TabBadgeOptions
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class HomeTabBadgeManager {

    private val _badgeFlow = MutableStateFlow(TabBadgeOptions())
    val badgeFlow: Flow<TabBadgeOptions> = _badgeFlow

    fun setBadge(state: Boolean) = _badgeFlow.update {
        Log.d("BADGE", "set: $state")
        it.copy(state = state)
    }

}