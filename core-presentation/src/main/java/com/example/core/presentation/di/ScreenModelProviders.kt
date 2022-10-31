package com.example.core.presentation.di

import cafe.adriel.voyager.core.model.ScreenModel
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.Multibinds
import javax.inject.Provider

/**
 * Dagger subcomponent that provide all [ScreenModel] and [ScreenModelFactory] in parent component
 */
@Subcomponent(modules = [ScreenModelProvidersModule::class])
interface ScreenModelProvidersComponent {
    fun screenModels(): Map<Class<out ScreenModel>, @JvmSuppressWildcards Provider<ScreenModel>>
    fun screenModelFactories(): Map<Class<out ScreenModelFactory>, @JvmSuppressWildcards Provider<ScreenModelFactory>>
}

/**
 * By default Dagger Multibindings are required to have at least one definition.
 * This module says to Dagger that a map with [ScreenModel] or [ScreenModelFactory] can be empty.
 */
@Module
abstract class ScreenModelProvidersModule {
    @Multibinds
    abstract fun screenModels(): Map<Class<out ScreenModel>, ScreenModel>
    @Multibinds
    abstract fun screenModelFactories(): Map<Class<out ScreenModelFactory>, ScreenModelFactory>
}