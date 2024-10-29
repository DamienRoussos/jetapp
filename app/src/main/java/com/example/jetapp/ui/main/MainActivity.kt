package com.example.jetapp.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import com.example.jetapp.ui.screen.AppScreen
import com.example.jetapp.ui.theme.JetAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            JetAppTheme {
                val restaurantsState by viewModel.restaurantsState
//                val restaurantsFlow by viewModel.restaurantsFlow.collectAsState()
//                val restaurantsLiveData by viewModel.restaurantsLiveData.observeAsState()
                val remoteRestaurantsState by viewModel.remoteRestaurantState


                AppScreen(
                    restaurants = restaurantsState,
                    remoteRestaurants = remoteRestaurantsState,
                    viewModel = viewModel,
                )
            }
        }
    }
}