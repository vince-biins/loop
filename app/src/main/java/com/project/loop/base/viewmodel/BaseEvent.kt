package com.project.loop.base.viewmodel

sealed class BaseEvent {
    object OnBackPressed : BaseEvent()
    object OnRetry : BaseEvent()
    object OnRefresh : BaseEvent()
}