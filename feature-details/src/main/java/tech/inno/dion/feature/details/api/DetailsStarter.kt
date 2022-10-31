package tech.inno.dion.feature.details.api

import cafe.adriel.voyager.core.screen.Screen
import com.example.core.presentation.feature.FeatureStarter

interface DetailsStarter : FeatureStarter {
    fun startDetails(info: String): Screen
}