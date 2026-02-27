package com.project.loop.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.loop.base.composable.LoopDp
import com.project.loop.base.navigation.BottomNavItem
import com.project.loop.base.navigation.MainRoute

@Composable
fun BottomNavBar(
    selectedTab: MainRoute,
    onSelectedTab: (MainRoute) -> Unit
) {

    Surface(
        tonalElevation = 3.dp,
        shadowElevation = 12.dp,
        shape = RoundedCornerShape(topStart = LoopDp.TWENTY_FOUR_DP, topEnd = LoopDp.TWENTY_FOUR_DP)
    ) {
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.background,
            tonalElevation = NavigationBarDefaults.Elevation,
            windowInsets = NavigationBarDefaults.windowInsets
        ) {
            BottomNavItem.items.forEach { item ->
                NavigationBarItem(
                    selected = selectedTab == item.route,
                    onClick = {
                        onSelectedTab(item.route)
                    },
                    icon = {
                        Icon(
                            painter = painterResource(item.icon),
                            contentDescription = item.label,
                            modifier = Modifier.size(LoopDp.TWENTY_FOUR_DP)
                        )
                    },
                    label = {
                        Text(text = item.label, style = MaterialTheme.typography.labelSmall)
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                        selectedIconColor = MaterialTheme.colorScheme.primary,
                        selectedTextColor = MaterialTheme.colorScheme.primary,
                        unselectedIconColor = MaterialTheme.colorScheme.outline,
                        unselectedTextColor = MaterialTheme.colorScheme.outline
                    )
                )
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun BottomNavBarPreview() {
    MaterialTheme {
        Scaffold(
            bottomBar = { BottomNavBar(
                selectedTab = MainRoute.Home,
                onSelectedTab = {}
            ) }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(it)
            ) {
            }
        }
    }
}