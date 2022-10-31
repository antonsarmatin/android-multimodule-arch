package com.example.feature.home

import cafe.adriel.voyager.core.screen.Screen
import com.example.core.presentation.feature.FeatureApi

interface HomeFeatureApi : FeatureApi {

    fun getHomeScreen() : Screen

}