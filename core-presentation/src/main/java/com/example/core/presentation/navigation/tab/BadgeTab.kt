package com.example.core.presentation.navigation.tab

import cafe.adriel.voyager.navigator.tab.Tab

interface BadgeTab : Tab {

//    fun getProvider(): TabBadgeProvider
    val badgeProvider: TabBadgeProvider

}