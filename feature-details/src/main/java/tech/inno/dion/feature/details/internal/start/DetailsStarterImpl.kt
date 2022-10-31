package tech.inno.dion.feature.details.internal.start

import cafe.adriel.voyager.core.screen.Screen
import com.example.core.presentation.di.PerFeature
import tech.inno.dion.feature.details.api.DetailsStarter
import tech.inno.dion.feature.details.internal.ui.DetailsScreen
import javax.inject.Inject

@PerFeature
internal class DetailsStarterImpl @Inject constructor() : DetailsStarter {

    override fun startDetails(info: String): Screen = DetailsScreen(info)

}