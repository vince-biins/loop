package com.project.loop.base.viewmodel

import com.project.loop.base.exception.LoopException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import retrofit2.HttpException
import java.io.IOException

abstract class MviViewModel<State : BaseState, Event : BaseEvent, Effect : BaseEffect>(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : BaseViewModel<State>(dispatcher) {


    private val _effectFlow = MutableSharedFlow<Effect>(
        replay = 0,
        extraBufferCapacity = 1
    )
    val effectFlow = _effectFlow.asSharedFlow()

    protected fun sendEffect(effect: Effect) {
        _effectFlow.tryEmit(effect)
    }

    abstract fun onEvent(event: Event)

    override fun handleError(throwable: Throwable) {
        super.handleError(throwable)

        val message = when (throwable) {
            is LoopException -> throwable.message ?: "Something went wrong"
            is IOException -> "Check your internet connection"
            is HttpException -> "Server error: ${throwable.code()}"
            is NullPointerException -> "Unexpected error occurred"
            else -> "Something went wrong"
        }

        sendEffect(createErrorEffect(message))
    }

    protected abstract fun createErrorEffect(message: String): Effect

}