package com.example.core.presentation.navigation.tab

import kotlinx.coroutines.flow.Flow

interface TabBadgeProvider {

    val badgeFlow: Flow<TabBadgeOptions>

}