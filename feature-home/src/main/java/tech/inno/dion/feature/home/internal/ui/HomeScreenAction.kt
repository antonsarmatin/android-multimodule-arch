package tech.inno.dion.feature.home.internal.ui

sealed class HomeScreenAction {
    data class Input(val value: String) : HomeScreenAction()
    object GoToDetailsClick : HomeScreenAction()
}