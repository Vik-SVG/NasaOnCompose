package com.priesniakov.nasaoncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.priesniakov.core.theme.Black
import com.priesniakov.core.theme.NasaOnComposeTheme
import com.priesniakov.nasaoncompose.navigation.AppNavHost
import com.priesniakov.nasaoncompose.navigation.HomeScreen
import com.priesniakov.nasaoncompose.navigation.appRootScreens
import com.priesniakov.nasaoncompose.navigation.navigateSingleTopTo
import com.priesniakov.nasaoncompose.ui.components.NasaAppBar
import com.priesniakov.nasaoncompose.ui.components.NasaBottomBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NasaOnComposeApp()
        }
    }
}

@Composable
private fun NasaOnComposeApp() {
    NasaOnComposeTheme {
        val rootNavController = rememberNavController()
        val rootCurrentBackStack by rootNavController.currentBackStackEntryAsState()
        val currentRootDestination = rootCurrentBackStack?.destination
        var currentRootScreen by rememberSaveable {
            mutableStateOf(appRootScreens.find { it.route == currentRootDestination?.route }
                ?: HomeScreen)
        }

        var appBarTitle by rememberSaveable {
            mutableStateOf(HomeScreen.title)
        }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                NasaAppBar(appBarTitle)
            },
            backgroundColor = Black,
            bottomBar = {
                NasaBottomBar(
                    currentScreen = currentRootScreen,
                    allScreens = appRootScreens,
                    onSelected = {
                        appBarTitle = it.title
                        rootNavController.navigateSingleTopTo(it.route)
                        currentRootScreen = it
                    }
                )
            }
        ) {
            AppNavHost(navController = rootNavController, Modifier.padding(it))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NasaOnComposeApp()
}