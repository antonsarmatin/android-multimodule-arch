package tech.inno.dion.feature.details.internal.ui

import com.example.core.presentation.foundation.ScreenState

data class DetailsScreenState(
    val info: String = "",
    val networkData: String = "",
) : ScreenState
