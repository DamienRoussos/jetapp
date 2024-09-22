package com.example.jetapp.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.jetapp.ui.screen.AppScreen
import com.example.jetapp.ui.screen.Header
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

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        Header()
                    }
                ) { contentPadding ->
                    Surface {
                        AppScreen(
                            modifier = Modifier.padding(contentPadding),
                            onPostCodeChange = viewModel::searchRestaurantByPostCode,
                            restaurants = restaurantsState,
                            onSetFavourite = viewModel::toggleRestaurantIsFavourite,
                            onGetFavourites = viewModel::getFavouriteRestaurants
                        )
                    }
                }
            }
        }
    }
}