package com.project.loop.base.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable


@Serializable
sealed class BaseRoute : NavKey {

    @Serializable
    data object Auth : BaseRoute()

    @Serializable
    data object Main : BaseRoute()

}


@Serializable
sealed class AuthRoute : NavKey {
    @Serializable
    data object SignIn : AuthRoute()

    @Serializable
    data object SignUp : AuthRoute()

}


@Serializable
sealed class MainRoute : NavKey {

    @Serializable
    data object Home : MainRoute()

    @Serializable
    data object Explore : MainRoute()

    @Serializable
    data object Profile : MainRoute()

    @Serializable
    data object Create : MainRoute()

    @Serializable
    data object Notification : MainRoute()
}

   
