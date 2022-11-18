package com.example.core.presentation.navigation.tab

import cafe.adriel.voyager.navigator.tab.Tab

interface BadgeTab : Tab {

    val badgeProvider: TabBadgeProvider

}