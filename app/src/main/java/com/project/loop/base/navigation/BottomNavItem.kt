package com.project.loop.base.navigation

import com.project.loop.R


sealed interface BottomNavItem {
    val icon: Int
    val label: String
    val route: MainRoute


    data object Feed : BottomNavItem {
        override val icon: Int = R.drawable.ic_feed
        override val label: String = "Feed"
        override val route: MainRoute
            get() = MainRoute.Home
    }

    data object Explore : BottomNavItem {
        override val icon: Int = R.drawable.ic_explore
        override val label: String = "Explore"
        override val route: MainRoute
            get() = MainRoute.Explore
    }

    data object Create : BottomNavItem {
        override val icon: Int = R.drawable.ic_create
        override val label: String = "Create"
        override val route: MainRoute
            get() = MainRoute.Create
    }

    data object Notification : BottomNavItem {
        override val icon: Int = R.drawable.ic_notification
        override val label: String = "Notification"
        override val route: MainRoute
            get() = MainRoute.Notification
    }

    data object Profile : BottomNavItem {
        override val icon: Int = R.drawable.ic_profile
        override val label: String = "Profile"
        override val route: MainRoute
            get() = MainRoute.Profile
    }

    companion object {
        val items = listOf(Feed, Explore, Create, Notification, Profile)
    }
}


