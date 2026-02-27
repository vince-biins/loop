package com.project.loop.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.project.loop.base.navigation.BaseRoute
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@Composable
fun NavRoot(modifier: Modifier = Modifier) {

    val navKeyModule = SerializersModule {
        polymorphic(NavKey::class) {
            subclass(BaseRoute.Main::class, BaseRoute.Main.serializer())
            subclass(BaseRoute.Auth::class, BaseRoute.Auth.serializer())
        }
    }
    val backStack = rememberNavBackStack(configuration = SavedStateConfiguration {
        serializersModule = navKeyModule
    }, BaseRoute.Auth)
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<BaseRoute.Auth> { NavAuth(
                onSignInClick = { backStack.add(BaseRoute.Main) },
                onSignUpClick = { backStack.add(BaseRoute.Main) },
            ) }
            entry<BaseRoute.Main> { NavMain() }
        }
    )
}

