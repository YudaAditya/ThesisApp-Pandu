package id.ac.unsyiah.panduapp

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import id.ac.unsyiah.panduapp.ui.navigation.BottomBarScreen
import id.ac.unsyiah.panduapp.ui.navigation.BottomNavGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    var navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController)}
    ) {
        BottomNavGraph(navController = navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Navigasi,
        BottomBarScreen.Ruangan,
        BottomBarScreen.Bantuan
    )
    var selectedItem by remember { mutableStateOf(0) }


    NavigationBar() {
        screens.forEachIndexed { index, bottomBarScreen ->
            NavigationBarItem(
                icon = {
                    if (selectedItem == index) {
                        Icon(
                            bottomBarScreen.selectedIcon!!,
                            contentDescription = bottomBarScreen.title
                        )
                    } else {
                        Icon(
                            bottomBarScreen.icon,
                            modifier = Modifier.alpha(alpha = ContentAlpha.disabled),
                            contentDescription = bottomBarScreen.title
                        )
                    }

                },
                selected = selectedItem == index,
                label = {
                    if (selectedItem == index) {
                        Text(
                            text = bottomBarScreen.title,
                            fontWeight = FontWeight.Bold
                        )
                    } else
                        Text(
                            text = bottomBarScreen.title,
                            modifier =Modifier.alpha(alpha = ContentAlpha.disabled),
                        )
                },
                onClick = {
                    selectedItem = index
                    navController.navigate(bottomBarScreen.route) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

