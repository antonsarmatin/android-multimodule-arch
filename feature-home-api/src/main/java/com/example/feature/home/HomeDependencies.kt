package com.example.feature.home

interface Deps

interface HomeDependencies : Deps{
    val dataManager: DataManager
    val userManager: UserManager
    val detailsStarter: DetailsStarter
}

interface DetailsStarter { // : FeatureStarter

    fun openDetails(id: String)

}

interface DataManager {

    fun getData() : String

}

interface UserManager {

    fun getName() : String

}


