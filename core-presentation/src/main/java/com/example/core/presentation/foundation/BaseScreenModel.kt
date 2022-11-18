package com.example.core.presentation.foundation

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.navigator.Navigator
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow

interface ScreenAction
interface ScreenState
interface ScreenEvent

abstract class BaseScreenModel<A : ScreenAction, E : ScreenEvent, S: ScreenState>(
    protected val navigator: Navigator,
    initialState: S
)  : ScreenModel {

    protected val _state: MutableStateFlow<S> = MutableStateFlow(initialState)
    val state: StateFlow<S>
        get() = _state

    protected val _event = Channel<E>()
    val event = _event.receiveAsFlow()

    abstract fun onAction(action: A)

}