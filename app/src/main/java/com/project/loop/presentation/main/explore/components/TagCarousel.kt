package com.project.loop.presentation.main.explore.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.loop.base.composable.LoopDp
import com.project.loop.base.composable.Padding
import com.project.loop.base.enums.Tags
import com.project.loop.base.theme.LoopGradients


@Composable
fun TagCarousel(
    modifier: Modifier = Modifier,
    tags: List<Triple<String, Boolean, () -> Unit>>,
) {

    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = Padding.EIGHT_DP),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(tags) {
            TagItem(
                text = it.first,
                isSelected = it.second,
                onClick = it.third
            )
        }

    }
}


@Composable
fun TagItem(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    isSelected: Boolean = false,
) {

    val backgroundColor: Brush = if (isSelected) {
        LoopGradients.LoopHorizontalGradient
    } else {
        SolidColor(MaterialTheme.colorScheme.background)
    }

    val contentColor: Color = if (isSelected) {
        Color.White
    } else {
        MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
    }

    val borderColor = if (isSelected) {
        Color.Transparent
    } else {
        MaterialTheme.colorScheme.outline.copy(alpha = 0.5f)
    }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(LoopDp.SIXTEEN_DP))
            .clickable { onClick.invoke() }
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(LoopDp.SIXTEEN_DP)
            )
            .background(
                brush = backgroundColor
            )
            .padding(Padding.EIGHT_DP),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color = contentColor
        )
    }

}

@Preview(showBackground = true)
@Composable
fun TagItemPreview() {
    MaterialTheme {
        TagItem(
            text = "Memes",
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TagCarouselPreview() {
    MaterialTheme {
        TagCarousel(
            tags = listOf(
                Triple(Tags.MEMES.name, true) {},
                Triple(Tags.CAMPUS_LIFE.name, false) {},
                Triple(Tags.MUSIC.name, false) {},
                Triple(Tags.OTHERS.name, false) {}
            )
        )
    }
}
