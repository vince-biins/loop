package com.project.loop.base.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class BaseViewModel<State : BaseState>(
    protected val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    protected abstract val initialState: State

    protected val _uiState: MutableStateFlow<State> by lazy { MutableStateFlow(initialState) }
    val uiState: StateFlow<State> = _uiState.asStateFlow()

    protected fun launchIO(block: suspend () -> Unit) {
        viewModelScope.launch(dispatcher) {
            try {
                block()
            } catch (e: Exception) {
                handleError(e)
            }
        }
    }

    protected fun launchSafe(
        onLoading: ((Boolean) -> Unit)? = null,
        block: suspend () -> Unit
    ) {
        viewModelScope.launch(dispatcher) {
            try {
                onLoading?.invoke(true)
                block()
            } catch (throwable: Throwable) {
                handleError(throwable)
            } finally {
                onLoading?.invoke(false)
            }
        }
    }

    protected fun setState(reducer: State.() -> State) {
        _uiState.update { it.reducer() }
    }
    protected open fun handleError(throwable: Throwable) {
        throwable.printStackTrace()
    }

}