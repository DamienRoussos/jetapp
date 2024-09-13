package com.example.jetapp.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.jetapp.ui.screen.AppScreen
import com.example.jetapp.ui.screen.Header
import com.example.jetapp.ui.theme.JetAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetAppTheme {
                Scaffold (
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        Header()
                    }
                ) {
                    Surface {
                        AppScreen()
                    }
                }
            }
        }
    }
}