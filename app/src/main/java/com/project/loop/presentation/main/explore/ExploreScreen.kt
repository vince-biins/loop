package com.project.loop.presentation.main.explore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.project.loop.base.composable.Spacing
import com.project.loop.base.enums.Tags
import com.project.loop.presentation.main.explore.components.TagCarousel
import com.project.loop.presentation.main.explore.components.TrendingGrid

@Composable
fun ExploreScreen() {
    ExploreContent(
        tags = listOf(
            Triple(Tags.MEMES.name, true) {},
            Triple(Tags.CAMPUS_LIFE.name, false) {},
            Triple(Tags.MUSIC.name, false) {},
            Triple(Tags.OTHERS.name, false) {}
        )
    )
}

@Composable
fun ExploreContent(
    modifier: Modifier = Modifier,
    tags: List<Triple<String, Boolean, () -> Unit>>,
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        TagCarousel(
            modifier = Modifier.fillMaxWidth(),
            tags = tags
        )
        Spacer(modifier = Modifier.height(Spacing.SIXTEEN_DP))
        TrendingGrid()
    }
}



@Preview(showBackground = true)
@Composable
fun ExplorePreview() {
    MaterialTheme {
        ExploreContent(
            modifier = Modifier.background(MaterialTheme.colorScheme.background),
            tags = listOf(
                Triple(Tags.MEMES.name, true) {},
                Triple(Tags.CAMPUS_LIFE.name, false) {},
                Triple(Tags.MUSIC.name, false) {},
                Triple(Tags.OTHERS.name, false) {}
            )
        )
    }
}
