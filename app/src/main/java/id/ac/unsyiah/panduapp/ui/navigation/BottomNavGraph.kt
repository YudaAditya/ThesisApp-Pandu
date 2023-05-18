package id.ac.unsyiah.panduapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import id.ac.unsyiah.panduapp.ui.bantuan.BantuanScreen
import id.ac.unsyiah.panduapp.ui.homescreen.PanduHomeScreen
import id.ac.unsyiah.panduapp.ui.ruangan.RuanganScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Navigasi.route
    ){
        composable(route = BottomBarScreen.Navigasi.route) {
            PanduHomeScreen()
        }
        composable(route = BottomBarScreen.Ruangan.route) {
            RuanganScreen()
        }
        composable(route = BottomBarScreen.Bantuan.route) {
            BantuanScreen()
        }
    }


}