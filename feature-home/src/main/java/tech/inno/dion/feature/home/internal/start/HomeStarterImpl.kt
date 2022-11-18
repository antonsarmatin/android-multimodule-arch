package tech.inno.dion.feature.home.internal.start

import cafe.adriel.voyager.navigator.tab.Tab
import com.example.core.presentation.di.PerFeature
import tech.inno.dion.feature.home.api.HomeStarter
import tech.inno.dion.feature.home.internal.ui.tab.HomeTab
import com.example.core.presentation.navigation.tab.TabBadgeProvider
import javax.inject.Inject

@PerFeature
internal class HomeStarterImpl @Inject constructor(
    private val tabBadgeProvider: TabBadgeProvider
) : HomeStarter {
    override fun homeTab(): Tab = HomeTab
}