package com.example.multimodule.routing

import tech.inno.dion.feature.home.api.NavigateToDetails

interface DetailsRouting : NavigateToDetails, Routing {

    override fun openDetails(data: String) {
        navigateToDetails(data)
    }

    fun navigateToDetails(data: String)

}