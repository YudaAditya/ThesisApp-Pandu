package id.ac.unsyiah.panduapp.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Place
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector,
    val selectedIcon: ImageVector? = null
){
    object Navigasi : BottomBarScreen(
        route = "navigasi",
        title = "Navigasi",
        icon = Icons.Outlined.Place,
        selectedIcon = Icons.Rounded.Place
    )
    object Ruangan : BottomBarScreen(
        route = "ruangan",
        title = "Ruangan",
        icon = Icons.Outlined.Build,
        selectedIcon = Icons.Rounded.Build
    )
    object Bantuan : BottomBarScreen(
        route = "bantuan",
        title = "Bantuan",
        icon = Icons.Outlined.Phone,
        selectedIcon = Icons.Rounded.Phone
    )
}
