package com.example.jetapp.ui.restaurantdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest.Builder
import coil.size.Size
import com.example.jetapp.data.Restaurant
import com.example.jetapp.ui.parameterprovider.RestaurantModelParameterProvider
import com.example.jetapp.ui.theme.JetAppTheme

@Composable
fun RestaurantImage(
    image: String,
    modifier: Modifier = Modifier,
) {

    val restaurantImagePainter: AsyncImagePainter = rememberAsyncImagePainter(
        model = Builder(LocalContext.current)
            .data(image)
            .size(Size.ORIGINAL)
            .build()
    )

    Image(
        painter = restaurantImagePainter,
        contentDescription = null,
        modifier = modifier
            .size(80.dp)
            .shadow(4.dp, RoundedCornerShape(4.dp))
            .clip(RoundedCornerShape(4.dp)),
        contentScale = ContentScale.Crop,
    )

//    AsyncImage(
//        model = ImageRequest.Builder(LocalContext.current)
//            .data(image)
//            .crossfade(true)
//            .build(),
//        contentDescription = contentDescription,
//        modifier = modifier.clip(RoundedCornerShape(4.dp)),
//        contentScale = ContentScale.Crop
//    )
//    Image(
//        painter = painterResource(image),
//        contentDescription = null,
//        modifier = modifier
//            .size(80.dp)
//            .shadow(4.dp, RoundedCornerShape(4.dp))
//            .clip(RoundedCornerShape(4.dp)),
//        contentScale = ContentScale.Crop,
//    )
}

@Preview(showBackground = true)
@Composable
fun RestaurantImagePreview(
    @PreviewParameter(
        RestaurantModelParameterProvider::class
    )
    model: Restaurant,
) {
    JetAppTheme {
        RestaurantImage(model.image)
    }
}