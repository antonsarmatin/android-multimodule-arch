package tech.inno.dion.feature.home.internal.ui

import cafe.adriel.voyager.navigator.Navigator
import com.example.core.presentation.di.ScreenModelFactory
import com.example.core.presentation.foundation.BaseScreenModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.update
import tech.inno.dion.feature.home.api.NavigateToDetails

class HomeScreenModel @AssistedInject constructor(
    @Assisted navigator: Navigator,
    private val navigateToDetails: NavigateToDetails
) : BaseScreenModel<HomeScreen.Action, HomeScreen.State>(
    navigator = navigator,
    initialState = HomeScreen.State()
) {

    @AssistedFactory
    interface Factory : ScreenModelFactory {
        fun create(navigator: Navigator): HomeScreenModel
    }

    override fun onAction(action: HomeScreen.Action) {
        when (action) {
            HomeScreen.Action.GoToDetailsClick -> navigateToDetails.openDetails(state.value.input)
            is HomeScreen.Action.Input -> _state.update { it.copy(input = action.value) }
        }
    }
}