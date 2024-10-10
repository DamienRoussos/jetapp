package com.example.jetapp.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModelProvider
import com.example.jetapp.ui.screen.AppScreen
import com.example.jetapp.ui.theme.JetAppTheme

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

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