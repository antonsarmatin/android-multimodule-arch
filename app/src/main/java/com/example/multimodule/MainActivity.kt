package com.example.multimodule

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.example.core.presentation.navigation.tab.BadgeTab
import com.example.core.presentation.navigation.tab.TabBadgeOptions
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
//                Navigator(
//                    screen = homeFeature.starter.startHome()
//                ) { navigator ->
//
//                    LaunchedEffect(key1 = navigator) {
//                        appRouter.setNavigator(navigator)
//                    }
//
//                    CurrentScreen()
//                }

                TabNavigator(homeFeature.starter.homeTab()) {
                    Scaffold(
                        content = {
                            CurrentTab()
                        },
                        bottomBar = {
                            BottomNavigation {
                                TabNavigationItem(homeFeature.starter.homeTab())
                            }
                        }
                    )
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
        icon = {
            Box {
                Icon(painter = tab.icon!!, contentDescription = tab.title)
                if (tab is BadgeTab) {
                    Log.d("BADGE", "Badge tab")
//                    val badge by tab.badgeProvider.badgeFlow.collectAsState(initial = TabBadgeOptions())
                    val badge by tab.badgeProvider.badgeFlow.collectAsState(initial = TabBadgeOptions())
                    //TODO ANIMATE
                    if (badge.state) {
                        Log.d("BADGE", "get: $badge.state")
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .clip(CircleShape)
                                .background(Color.Red)
                                .align(Alignment.TopEnd)
                        )
                    }

                }
            }

        }
    )
}