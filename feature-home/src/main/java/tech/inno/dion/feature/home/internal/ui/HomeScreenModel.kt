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
) : BaseScreenModel<HomeScreenAction, HomeScreenState>(
    navigator = navigator,
    initialState = HomeScreenState()
) {

    @AssistedFactory
    interface Factory : ScreenModelFactory {
        fun create(navigator: Navigator): HomeScreenModel
    }

    override fun onAction(action: HomeScreenAction) {
        when (action) {
            HomeScreenAction.GoToDetailsClick -> navigateToDetails.openDetails(state.value.input)
            is HomeScreenAction.Input -> _state.update { it.copy(input = action.value) }
        }
    }
}