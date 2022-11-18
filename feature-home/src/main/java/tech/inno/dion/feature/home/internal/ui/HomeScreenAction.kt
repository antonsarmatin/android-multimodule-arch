package tech.inno.dion.feature.home.internal.ui

import com.example.core.presentation.foundation.ScreenAction

sealed class HomeScreenAction : ScreenAction{
    data class Input(val value: String) : HomeScreenAction()

    object EnableBadgeClick : HomeScreenAction()
    object DisableBadgeClick : HomeScreenAction()
    object GoToDetailsClick : HomeScreenAction()
}