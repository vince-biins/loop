package com.project.loop.domain.model

sealed class SignInRequest {

    data class EmailPassword(
        val email: String,
        val password: String
    ) : SignInRequest()

    data class UsernamePassword(
        val username: String,
        val password: String
    ) : SignInRequest()

    data class MobilePassword(
        val mobileNumber: String,
        val password: String
    ) : SignInRequest()

    data class Facebook(
        val accessToken: String
    ) : SignInRequest()
}