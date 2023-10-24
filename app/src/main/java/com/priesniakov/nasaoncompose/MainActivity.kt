package com.priesniakov.nasaoncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
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
    MaterialTheme(content = {

        val rootNavController = rememberNavController()
        val rootCurrentBackStack by rootNavController.currentBackStackEntryAsState()
        val currentRootDestination = rootCurrentBackStack?.destination

        var appBarTitle by rememberSaveable {
            mutableStateOf("Title")
        }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {},
            bottomBar = {}
        ) {
        }
    })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NasaOnComposeApp()
}