package com.shivam.composeinstagramclone.auth.domain

import com.google.common.truth.Truth.assertThat
import com.shivam.composeinstagramclone.auth.data.dto.CreateUserDto
import org.junit.Test

class AuthValidatorTest {

    @Test
    fun validateCreateUserRequest_allFieldsEmpty_returnsFalse() {
        val createUserDto = CreateUserDto(
            email = "",
            fullName = "",
            username = "",
            password = ""
        )
        val result = AuthValidator.validateCreateUserRequest(createUserDto)
        assertThat(result.successful).isFalse()
    }

    @Test
    fun validateCreateUserRequest_oneFieldEmpty_returnsFalse() {
        val createUserDto = CreateUserDto(
            email = "mshivam019@gmail.com",
            fullName = "Shivam Mishra",
            username = "mshivam019",
            password = "12345678"
        )
        val result = AuthValidator.validateCreateUserRequest(createUserDto)
        assertThat(result.successful).isFalse()
    }

    @Test
    fun validateCreateUserRequest_invalidEmail_returnsFalse() {
        val createUserDto = CreateUserDto(
            email = "mshivam019@gmail.com",
            fullName = "Shivam Mishra",
            username = "mshivam019",
            password = "12345678"
        )
        val result = AuthValidator.validateCreateUserRequest(createUserDto)
        assertThat(result.successful).isFalse()
    }

    @Test
    fun validateCreateUserRequest_invalidPasswordLength_returnsFalse() {
        val createUserDto = CreateUserDto(
            email = "mshivam019@gmail.com",
            fullName = "Shivam Mishra",
            username = "mshivam019",
            password = "12345678"
        )
        val result = AuthValidator.validateCreateUserRequest(createUserDto)
        assertThat(result.successful).isFalse()
    }

    @Test
    fun validateCreateUserRequest_allFieldsValid_returnsTrue() {
        val createUserDto = CreateUserDto(
            email = "mshivam019@gmail.com",
            fullName = "Shivam Mishra",
            username = "mshivam019",
            password = "12345678"
        )
        val result = AuthValidator.validateCreateUserRequest(createUserDto)
        assertThat(result.successful).isTrue()
    }
}