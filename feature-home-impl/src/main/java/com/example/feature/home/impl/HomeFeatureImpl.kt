package com.example.feature.home.impl

import cafe.adriel.voyager.core.screen.Screen
import com.example.feature.home.HomeFeatureApi
import com.example.feature.home.impl.ui.HomeScreen

class HomeFeatureImpl : HomeFeatureApi {

    override fun getHomeScreen(): Screen = HomeScreen

}