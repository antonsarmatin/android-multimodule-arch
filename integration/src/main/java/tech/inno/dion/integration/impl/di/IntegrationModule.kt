package tech.inno.dion.integration.impl.di

import com.example.core.presentation.di.PerFeature
import dagger.Module
import dagger.Provides
import com.example.core.network.NetworkClient
import kotlin.random.Random

@Module
internal class IntegrationModule {

    //Представим, что это ретрофит)
    @Provides
    @PerFeature
    fun provideNetworkClient(): NetworkClient {
        return object : NetworkClient {
            override fun call(): String {
                return Random.nextInt(from = 0, until = 512_000).toString()
            }
        }
    }

}