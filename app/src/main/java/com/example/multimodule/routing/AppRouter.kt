package com.example.multimodule.routing

import cafe.adriel.voyager.navigator.Navigator
import tech.inno.dion.feature.details.api.DetailsApi


//Каждая фича будет просить реализовать свой "NavigateToDetails" для одного и того же экрана,
//Для того, чтобы не сорить в роутере, можно их объединить в отдельный интерфейс
class AppRouter(
    private val detailsApi: DetailsApi
) : DetailsRouting {

    private var navigator: Navigator? = null

    fun setNavigator(navigator: Navigator){
        this.navigator = navigator
    }

    //
    override fun navigateToDetails(data: String) {
        val screen = detailsApi.starter.startDetails(data)
        navigator?.push(screen)
    }
}

