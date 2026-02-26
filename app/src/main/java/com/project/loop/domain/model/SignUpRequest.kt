package com.project.loop.domain.model

sealed class SignUpRequest {

    data class EmailSignUp(
        val email: String,
        val password: String,
        val confirmPassword: String,
        val fullName: String? = null,
        val username: String? = null
    ) : SignUpRequest()

    data class MobileSignUp(
        val mobileNumber: String,
        val password: String,
        val confirmPassword: String,
        val fullName: String? = null,
        val username: String? = null
    ) : SignUpRequest()

    data class FacebookSignUp(
        val accessToken: String,
        val email: String? = null,
        val fullName: String? = null
    ) : SignUpRequest()
}