package com.example.jetapp.ui.restaurantsearch

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetapp.ui.theme.JetAppTheme

@Composable
fun RestaurantSearch(
    userPostCode: String,
    onPostCodeEnter: (String) -> Unit,
    modifier: Modifier = Modifier,
) {

    var postCodeInput by remember { mutableStateOf("") }

    TextField(
        value = postCodeInput,
        onValueChange = { updatedInput ->
            postCodeInput = updatedInput
            onPostCodeEnter(updatedInput)
        },
        placeholder = { Text(text = userPostCode) },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Text
        ),
        modifier = modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun RestaurantSearchPreview() {
    JetAppTheme {
        RestaurantSearch(userPostCode = "test", {})
    }
}