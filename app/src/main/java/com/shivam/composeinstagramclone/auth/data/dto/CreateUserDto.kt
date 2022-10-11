package com.shivam.composeinstagramclone.auth.data.dto

import com.google.firebase.firestore.FieldValue


data class CreateUserDto(
    val uid: String = "",
    val username: String,
    val password: String,
    val email: String,
    val fullName: String,
    val imageUrl: String = "",
    val createdDate: FieldValue? = null,
)
