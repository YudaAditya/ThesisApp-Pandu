package id.ac.unsyiah.panduapp.ui.navigation

import id.ac.unsyiah.panduapp.R


sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int,
    val selectedIcon: Int
){
    object Navigasi : BottomBarScreen(
        route = "navigasi",
        title = "Navigasi",
        icon = R.drawable.outline_navigation_24,
        selectedIcon = R.drawable.round_navigation_24
    )
    object Ruangan : BottomBarScreen(
        route = "ruangan",
        title = "Ruangan",
        icon = R.drawable.outline_home_work_24,
        selectedIcon = R.drawable.round_home_work_24
    )
    object Bantuan : BottomBarScreen(
        route = "bantuan",
        title = "Bantuan",
        icon = R.drawable.outline_help_outline_24,
        selectedIcon = R.drawable.baseline_help_24
    )
}
