package tech.inno.dion.feature.home.internal.ui.screen

import com.example.core.presentation.foundation.ScreenState

data class HomeScreenState(
    val input: String = "",
    val isLoading: Boolean = false
) : ScreenState