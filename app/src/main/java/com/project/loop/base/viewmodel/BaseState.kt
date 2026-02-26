package com.project.loop.base.viewmodel

abstract class BaseState(
    open val isLoading: Boolean = false,
    open val errorMessage: String? = null
)