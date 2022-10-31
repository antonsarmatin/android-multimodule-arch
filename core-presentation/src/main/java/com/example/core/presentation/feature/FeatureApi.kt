package com.example.core.presentation.feature

//По идее, можно запихать прям в core модуль, т.к. не содержит именно presentation пренадлежности
//Хотя и 95% фичей UIные, но могут быть и не связанные с ui

interface FeatureComponentHolder<C : FeatureApi, D : FeatureDependencies> {
    fun init(dependencies: D)
    fun get(): C
    fun reset()
}


interface FeatureApi

/**
 * External dependencies for feature
 * Must be provided from outside of feature
 *
 * E.g. from root app module
 */
interface FeatureDependencies

/**
 * Marks as FeatureStarter
 */
interface FeatureStarter
