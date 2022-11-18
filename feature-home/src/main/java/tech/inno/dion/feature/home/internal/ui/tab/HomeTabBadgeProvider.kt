package tech.inno.dion.feature.home.internal.ui.tab

import com.example.core.presentation.di.PerFeature
import com.example.core.presentation.navigation.tab.TabBadgeOptions
import com.example.core.presentation.navigation.tab.TabBadgeProvider
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@PerFeature
class HomeTabBadgeProvider @Inject constructor(
    private val manager: HomeTabBadgeManager
) : TabBadgeProvider {

    override val badgeFlow: Flow<TabBadgeOptions> = manager.badgeFlow
}