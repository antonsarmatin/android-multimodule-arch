package com.example.core.presentation.di

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen



/**
 * Provide a [ScreenModel] using a custom [ScreenModelFactory].
 * The [ScreenModelFactory] is provided by ScreenModelProvidersComponent from Dagger.
 *
 * @param factory A function that receives a [ScreenModelFactory] and returns a [ScreenModel] created by the custom factory
 * @return A new instance of [ScreenModel] or the same instance remembered by the composition
 */
@Composable
inline fun <reified T : ScreenModel, reified F : ScreenModelFactory> Screen.getScreenModel(
    provider: ScreenModelProvidersComponent,
    noinline factory: (F) -> T
): T {
    return rememberScreenModel {
        val screenModelFactories = provider.screenModelFactories()
        val screenModelFactory =
            screenModelFactories[F::class.java]?.get() ?: error("Multibinding error")

        factory.invoke(screenModelFactory as F)
    }
}

@Composable
inline fun <reified T : ScreenModel> Screen.getScreenModel(
    noinline provider: () -> T,
): T {
    return rememberScreenModel(factory = provider)
}