package com.example.multimodule

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import com.example.multimodule.di.AppComponent
import com.example.multimodule.routing.AppRouter
import com.example.multimodule.ui.theme.AppTheme
import tech.inno.dion.feature.home.api.HomeApi
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var homeFeature: HomeApi

    @Inject
    lateinit var appRouter: AppRouter

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppComponent.get().inject(this)
        setContent {
            AppTheme {
                Navigator(
                    screen = homeFeature.starter.startHome()
                ) { navigator ->

                    LaunchedEffect(key1 = navigator) {
                        appRouter.setNavigator(navigator)
                    }

                    CurrentScreen()
                }
            }
        }
    }
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    BottomNavigationItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        icon = { Icon(painter = tab.icon!!, contentDescription = tab.title) }
    )
}