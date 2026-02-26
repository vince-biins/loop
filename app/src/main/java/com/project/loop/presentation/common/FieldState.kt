package com.project.loop.presentation.common

data class FieldState(
    val value: String = "",
    val errorMessage: String? = null,
    val onValueChange: (String) -> Unit = {}
)