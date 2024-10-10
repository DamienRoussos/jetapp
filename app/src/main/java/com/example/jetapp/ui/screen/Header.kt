package com.example.jetapp.ui.screen

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.jetapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(
    dataSource: String,
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name, dataSource),
            )
        },
        modifier = Modifier
            .statusBarsPadding()
    )
}