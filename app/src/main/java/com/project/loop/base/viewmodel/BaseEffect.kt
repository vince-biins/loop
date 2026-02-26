package com.project.loop.base.viewmodel

sealed class BaseEffect {
    data class ShowErrorMessage(val message: String) : BaseEffect()
    object NavigateBack : BaseEffect()
}