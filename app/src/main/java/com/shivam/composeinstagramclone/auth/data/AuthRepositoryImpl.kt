package com.shivam.composeinstagramclone.auth.data

import android.net.Uri
import com.google.firebase.auth.FirebaseUser
import com.shivam.composeinstagramclone.auth.data.dto.CreateUserDto
import com.shivam.composeinstagramclone.auth.domain.AuthRepository
import com.shivam.composeinstagramclone.auth.domain.Authenticator
import javax.inject.Inject


class AuthRepositoryImpl @Inject constructor(
    private val authenticator: Authenticator
): AuthRepository {
    override suspend fun createUserWithEmailAndPassword(
        email: String,
        password: String
    ): FirebaseUser? {
        return authenticator.createUserWithEmailAndPassword(email, password)
    }

    override suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): FirebaseUser? {
        return authenticator.signInWithEmailAndPassword(email, password)
    }

    override suspend fun checkUsernameAvailability(username: String): Boolean {
        return authenticator.checkUsernameAvailability(username)
    }

    override suspend fun signOut(): FirebaseUser? {
        return authenticator.signOut()
    }

    override suspend fun getUser(): FirebaseUser? {
        return authenticator.getUser()
    }

    override suspend fun sendPasswordResetEmail(email: String): Boolean {
        authenticator.sendPasswordResetEmail(email)
        return true
    }

    override suspend fun verifyPasswordResetCode(code: String) {
        return authenticator.verifyPasswordResetCode(code)
    }

    override suspend fun saveUserProfile(createUserDto: CreateUserDto): Boolean {
        authenticator.saveUserProfile(createUserDto)
        return true
    }

    override suspend fun uploadProfileImage(imageUri: Uri): String {
        return authenticator.uploadUserProfile(imageUri)
    }
}