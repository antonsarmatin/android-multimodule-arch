package tech.inno.dion.feature.home.api

import cafe.adriel.voyager.core.screen.Screen
import com.example.core.presentation.feature.FeatureStarter

interface HomeStarter : FeatureStarter {
    fun startHome(): Screen
}