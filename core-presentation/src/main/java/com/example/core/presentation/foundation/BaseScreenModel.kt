package com.example.core.presentation.foundation

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.navigator.Navigator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseScreenModel<A, S>(
    val navigator: Navigator, //Не обязательно, больше чтоб не забыть :-)
    val initialState: S
) : ScreenModel {

    protected val _state: MutableStateFlow<S> = MutableStateFlow(initialState)
    val state: StateFlow<S>
        get() = _state

    abstract fun onAction(action: A)

}