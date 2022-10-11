package com.shivam.composeinstagramclone.auth.domain

import android.net.Uri
import com.google.firebase.auth.FirebaseUser
import com.shivam.composeinstagramclone.auth.data.dto.CreateUserDto


interface Authenticator {
    suspend fun createUserWithEmailAndPassword(email:String , password:String) : FirebaseUser?

    suspend fun signInWithEmailAndPassword(email: String , password: String):FirebaseUser?

    suspend fun checkUsernameAvailability(username: String): Boolean

    suspend fun signOut() : FirebaseUser?

    suspend fun getUser() : FirebaseUser?

    suspend fun sendPasswordResetEmail(email :String)

    suspend fun verifyPasswordResetCode(code: String)

    suspend fun saveUserProfile(createUserDto: CreateUserDto)

    suspend fun uploadUserProfile(imageUri: Uri): String
}