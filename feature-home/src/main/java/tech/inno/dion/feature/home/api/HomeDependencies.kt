package tech.inno.dion.feature.home.api

import com.example.core.presentation.feature.FeatureDependencies

interface HomeDependencies : FeatureDependencies {
    fun navigateToDetails(): NavigateToDetails
}


//Зависимость для открытия другой фичи
interface NavigateToDetails {
    fun openDetails(data: String)
}
