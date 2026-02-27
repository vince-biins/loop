package com.project.loop.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.project.loop.base.navigation.AuthRoute
import com.project.loop.presentation.auth.SignInScreen
import com.project.loop.presentation.auth.SignUpScreen

@Composable
fun NavAuth(modifier: Modifier = Modifier, onSignInClick: () -> Unit, onSignUpClick: () -> Unit) {
    val backStack = rememberNavBackStack(AuthRoute.SignIn)
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider{
            entry<AuthRoute.SignIn> { SignInScreen(
                onSignInClick =  onSignInClick,
                onNavigateToSignUp = { backStack.add(AuthRoute.SignUp) }
            ) }
            entry<AuthRoute.SignUp> { SignUpScreen(
                onSignUpClick = onSignUpClick,
                onNavigateBackToSignIn = { backStack.removeLastOrNull() }
            ) }
        }
    )
}