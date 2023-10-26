package com.priesniakov.nasaoncompose.navigation

import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.priesniakov.core.navigation.BottomRouteScreen
import com.priesniakov.core.navigation.RouteScreen
import com.priesniakov.featureapod.ui.ApodComposableScreen
import com.priesniakov.nasaoncompose.R
import kotlinx.parcelize.Parcelize


sealed class AppScreen(override val title: String, override val route: String) : Parcelable,
    RouteScreen

@Parcelize
object HomeScreen : AppScreen("NASA On Compose", "home_screen"), Parcelable

@Parcelize
object ApodScreen : AppScreen("APOD", "apod_screen"), Parcelable, BottomRouteScreen {
    override fun getIconRes(): Int = rootScreenIcons.getValue(route)
}

@Parcelize
object AstronomersScreen : AppScreen("Astronomers", "astronomers_screen"), Parcelable,
    BottomRouteScreen {
    override fun getIconRes(): Int = rootScreenIcons.getValue(route)
}

@Parcelize
object MarsRoverScreen : AppScreen("Mars Rover", "mars_rover_screen"), Parcelable,
    BottomRouteScreen {
    override fun getIconRes(): Int = rootScreenIcons.getValue(route)
}

//val appScreens = listOf(HomeScreen, ApodScreen, AstronomersScreen, MarsRoverScreen)

val appRootScreens =
    listOf<BottomRouteScreen>(ApodScreen, AstronomersScreen, MarsRoverScreen)

val rootScreenIcons = mapOf(
    ApodScreen.route to R.drawable.apod_24,
    AstronomersScreen.route to R.drawable.astro_24,
    MarsRoverScreen.route to R.drawable.rover_24,
)


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
            ApodComposableScreen()
        }
        composable(route = AstronomersScreen.route) {
        }
        composable(route = MarsRoverScreen.route) {
        }
    }
}