package com.priesniakov.nasaoncompose.navigation

import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.priesniakov.nasaoncompose.R
import kotlinx.parcelize.Parcelize


sealed class Screen(val title: String, val route: String) : Parcelable

@Parcelize
object HomeScreen : Screen("NASA On Compose", "home_screen"), Parcelable

@Parcelize
object ApodScreen : Screen("APOD", "apod_screen"), Parcelable

@Parcelize
object AstronomersScreen : Screen("Astronomers", "astronomers_screen"), Parcelable

@Parcelize
object MarsRoverScreen : Screen("Mars Rover", "mars_rover_screen"), Parcelable

//val appScreens = listOf(HomeScreen, ApodScreen, AstronomersScreen, MarsRoverScreen)

val appRootScreens =
    listOf(ApodScreen, AstronomersScreen, MarsRoverScreen)

val rootScreenIcons = mapOf(
    ApodScreen.route to R.drawable.apod_24,
    AstronomersScreen.route to R.drawable.astro_24,
    MarsRoverScreen.route to R.drawable.rover_24,
)


fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = ApodScreen.route,
        modifier = modifier
    ) {
        composable(route = HomeScreen.route) {
        }
        composable(route = ApodScreen.route) {
        }
        composable(route = AstronomersScreen.route) {
        }
        composable(route = MarsRoverScreen.route) {
        }
    }
}