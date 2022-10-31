package tech.inno.dion.feature.home.internal.start

import cafe.adriel.voyager.core.screen.Screen
import com.example.core.presentation.di.PerFeature
import tech.inno.dion.feature.home.api.HomeStarter
import tech.inno.dion.feature.home.internal.ui.HomeScreen
import javax.inject.Inject

@PerFeature
internal class HomeStarterImpl @Inject constructor() : HomeStarter {

    override fun startHome(): Screen = HomeScreen

}