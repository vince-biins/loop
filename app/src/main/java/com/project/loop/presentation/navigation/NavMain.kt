package com.project.loop.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.project.loop.R
import com.project.loop.base.navigation.MainRoute
import com.project.loop.base.theme.LoopGradients
import com.project.loop.presentation.home.HomeFeedScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavMain(modifier: Modifier = Modifier) {

    val backStack = rememberNavBackStack(MainRoute.Home)
    Scaffold(
        modifier = modifier.background(MaterialTheme.colorScheme.background),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.app_name),
                        style = MaterialTheme.typography.titleLarge.copy(
                            brush = LoopGradients.LoopHorizontalGradient,
                            fontWeight = FontWeight.Bold,
                        )
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    scrolledContainerColor = Color.Unspecified,
                    navigationIconContentColor = Color.Unspecified,
                    titleContentColor = Color.Unspecified,
                    actionIconContentColor = Color.Unspecified,
                ),
                modifier = modifier,
            )
        },
        bottomBar = { BottomNavBar(selectedTab = MainRoute.Home, onSelectedTab = {}) }
    ) {
        NavDisplay(
            modifier = Modifier.padding(it),
            backStack = backStack,
            onBack = { backStack.removeLastOrNull() },
            entryDecorators = listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator()
            ),
            entryProvider = entryProvider {
                entry<MainRoute.Home> { HomeFeedScreen() }
                entry<MainRoute.Explore> { }
                entry<MainRoute.Create> { }
                entry<MainRoute.Notification> { }
                entry<MainRoute.Profile> { }
            }
        )
    }
}