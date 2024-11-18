package com.app.abc.presentation.home.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.app.abc.R


@Composable
fun CarouselItem(modifier: Modifier = Modifier, @DrawableRes resource: Int, description: String) {
    Image(
        painter = painterResource(id = resource),
        contentDescription = description,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .height(dimensionResource(id = R.dimen.dp_180))
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(id = R.dimen.dp_30))
            .clip(
                RoundedCornerShape(dimensionResource(id = R.dimen.dp_20))
            )
    )
}

@Preview
@Composable
private fun Preview() {
    CarouselItem(
        resource = R.drawable.ic_launcher_background,
        description = "Carousel"
    )
}