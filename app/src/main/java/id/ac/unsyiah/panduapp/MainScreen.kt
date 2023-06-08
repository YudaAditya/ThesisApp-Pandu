package id.ac.unsyiah.panduapp

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import id.ac.unsyiah.panduapp.ui.navigation.BottomBarScreen
import id.ac.unsyiah.panduapp.ui.navigation.BottomNavGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    //TopBar Part
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()


    //BottomBar Part
    val screens = listOf(
        BottomBarScreen.Navigasi,
        BottomBarScreen.Ruangan,
        BottomBarScreen.Bantuan
    )
    var selectedItem by remember { mutableStateOf(0) }

    var navController = rememberNavController()

    //Navigation Bar & Top Bar
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = screens[selectedItem].title) },
            )
        },


        bottomBar = {
//            BottomBar(navController = navController)
//            BottomAppBar() {
                NavigationBar() {
                    screens.forEachIndexed { index, bottomBarScreen ->
                        NavigationBarItem(
                            icon = {
                                if (selectedItem == index) {
                                    Icon(
                                        painterResource(id = bottomBarScreen.selectedIcon),
                                        contentDescription = bottomBarScreen.title,
                                        tint = MaterialTheme.colorScheme.onSecondaryContainer
                                    )
                                } else {
                                    Icon(
                                        painterResource(id = bottomBarScreen.icon),
                                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                        contentDescription = bottomBarScreen.title,

                                    )
                                }

                            },
                            selected = selectedItem == index,
                            label = {
                                if (selectedItem == index) {
                                    Text(
                                        text = bottomBarScreen.title,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                } else
                                    Text(
                                        text = bottomBarScreen.title,
//                                        modifier =Modifier.alpha(alpha = ContentAlpha.disabled),
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
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
//            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(
            PaddingValues(top = innerPadding.calculateTopPadding(), bottom = innerPadding.calculateBottomPadding())
        )){
            BottomNavGraph(navController = navController)
        }
    }

}



