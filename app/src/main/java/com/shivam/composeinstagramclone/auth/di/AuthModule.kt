package com.shivam.composeinstagramclone.auth.di

import com.shivam.composeinstagramclone.auth.data.AuthRepositoryImpl
import com.shivam.composeinstagramclone.auth.data.FirebaseAuthenticator
import com.shivam.composeinstagramclone.auth.domain.AuthRepository
import com.shivam.composeinstagramclone.auth.domain.Authenticator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton



@InstallIn(SingletonComponent::class)
@Module
object AuthModule {

    @Singleton
    @Provides
    fun provideAuthenticator(): Authenticator {
        return FirebaseAuthenticator()
    }

    @Singleton
    @Provides
    fun provideAuthRepository(authenticator: Authenticator): AuthRepository {
        return AuthRepositoryImpl(authenticator)
    }
}