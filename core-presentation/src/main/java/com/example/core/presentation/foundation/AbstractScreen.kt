package com.example.core.presentation.foundation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow

abstract class BaseScreen<A : ScreenAction, E : ScreenEvent, S : ScreenState> : Screen {

    @Composable
    override fun Content() {
        val model = bindModel(LocalNavigator.currentOrThrow)
        val state by model.state.collectAsState()
        val event by model.event.collectAsState(initial = null)

        EventHandler(event = event)

        ScreenContent(
            state = state,
            onAction = model::onAction
        )
    }

    /**
     * Screen content based on given state
     */
    @Composable
    protected abstract fun ScreenContent(
        state: S,
        onAction: (A) -> Unit
    )

    @Composable
    protected abstract fun bindModel(navigator: Navigator): BaseScreenModel<A, E, S>

    /**
     * Event handler
     * Invoke [handleEvent] on new event
     */
    @Composable
    protected open fun EventHandler(event: E?){
        LaunchedEffect(key1 = event){
            event?.let { handleEvent(it) }
        }
    }

    /**
     * Place for some compose functions instead of UI & Event handling
     */
    @Composable
    protected open fun Side(){
        //Nothing
    }


    protected open suspend fun handleEvent(event: E){
        //Nothing
    }

}


