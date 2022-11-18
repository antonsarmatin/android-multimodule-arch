package tech.inno.dion.feature.home.api

import cafe.adriel.voyager.navigator.tab.Tab
import com.example.core.presentation.feature.FeatureStarter

interface HomeStarter : FeatureStarter {
    fun homeTab(): Tab
}