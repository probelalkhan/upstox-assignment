package net.simplifiedcoding.upstoxassignment.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.simplifiedcoding.upstoxassignment.data.network.RemoteDataSource
import net.simplifiedcoding.upstoxassignment.data.network.UpstoxApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideUpstoxApi(
        remoteDataSource: RemoteDataSource
    ): UpstoxApi {
        return remoteDataSource.buildApi(UpstoxApi::class.java)
    }
}