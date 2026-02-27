package com.project.loop.base.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import coil3.compose.AsyncImage
import com.project.loop.R

sealed interface ImageShape {
    data object Circle : ImageShape
    data class Rounded(val radius: Dp) : ImageShape
    data object Square : ImageShape
}

@Composable
fun CacheableImage(
    imageModel: Any?,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    shape: ImageShape = ImageShape.Square,
    placeholder: Painter? = null,
    error: Painter? = painterResource(R.drawable.ic_person),
    fallback: Painter? = painterResource(R.drawable.ic_person),
    contentScale: ContentScale = ContentScale.Crop,
    colorFilter: ColorFilter? = null,
    backgroundWhileLoading: Color = Color.Transparent
) {
    val shapeModifier = when (shape) {
        is ImageShape.Circle -> Modifier.clip(CircleShape)
        is ImageShape.Rounded -> Modifier.clip(RoundedCornerShape(shape.radius))
        ImageShape.Square -> Modifier
    }

    AsyncImage(
        model = imageModel,
        contentDescription = contentDescription,
        modifier = modifier
            .then(shapeModifier)
            .background(backgroundWhileLoading),
        placeholder = placeholder,
        error = error,
        fallback = fallback,
        contentScale = contentScale,
        colorFilter = colorFilter
    )
}
