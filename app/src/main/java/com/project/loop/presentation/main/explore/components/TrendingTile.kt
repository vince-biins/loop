package com.project.loop.presentation.main.explore.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.loop.R
import com.project.loop.base.composable.CacheableImage
import com.project.loop.base.composable.LoopDp
import com.project.loop.base.composable.Padding
import com.project.loop.base.composable.Spacing
import com.project.loop.base.theme.LoopGradients
import com.project.loop.base.theme.LoopPurple


@Composable
fun TrendingGrid() {

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = LoopDp.ONE_SIXTY_DP),
        contentPadding = PaddingValues(Spacing.EIGHT_DP),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item(
            span = { GridItemSpan(maxLineSpan) }
        ) {
            HeadLine()
        }
        items(20) {
            TrendingTile(
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun TrendingTile(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .widthIn(min = 140.dp, max = 320.dp)
            .heightIn(min = 160.dp, max = 240.dp)
            .background(Color.LightGray, RoundedCornerShape(LoopDp.SIXTEEN_DP))
            .clip(RoundedCornerShape(LoopDp.SIXTEEN_DP)),
        contentAlignment = Alignment.Center
    ) {
        Box(modifier = Modifier.matchParentSize()) {
            CacheableImage(
                imageModel = R.drawable.scenery,
                contentDescription = "Sample Image"
            )
        }
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.8f)
                        )
                    )
                )
        ){}
        Column(
            modifier = Modifier.matchParentSize().padding(Padding.EIGHT_DP),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().weight(1f),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.Top
            ) {
                Box(
                    modifier = Modifier
                        .size(LoopDp.TWENTY_FOUR_DP)
                        .background(
                            LoopGradients.LoopHorizontalGradient,
                            RoundedCornerShape(LoopDp.FIFTY_SIX_DP)
                        )
                        .clip(RoundedCornerShape(LoopDp.FIFTY_SIX_DP))
                        .padding(Padding.FOUR_DP)
                ) {

                    Icon(
                        painter = painterResource(R.drawable.ic_trending),
                        contentDescription = "Hot Topic",
                        tint = Color.White
                    )

                }
            }

            Text(
                text = "When the professor says 'this will be on the test'",
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.White,
                    fontWeight = FontWeight.W600
                )
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_heart),
                    contentDescription = "Reastions",
                    tint = Color.White,
                    modifier = Modifier.size(LoopDp.SIXTEEN_DP)
                )
                Spacer(modifier = Modifier.width(Spacing.EIGHT_DP))
                Text(
                    text = "2,012",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color.White
                    )
                )
            }
        }
    }
}
@Composable
fun HeadLine(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = Padding.FOUR_DP, horizontal = Padding.EIGHT_DP),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .size(LoopDp.THIRTY_TWO_DP),
            painter = painterResource(R.drawable.ic_trending),
            contentDescription = "Trending Now",
            tint = LoopPurple
        )

        Spacer(modifier = Modifier.width(LoopDp.EIGHT_DP))
        Text(
            text = stringResource(R.string.trending_now),
            style = MaterialTheme.typography.titleLarge.copy(
                brush = LoopGradients.LoopHorizontalGradient,
                fontWeight = FontWeight.Bold,
            )
        )


    }
}

@Preview(showBackground = true)
@Composable
fun TrendingTilePreview() {
    MaterialTheme {
        TrendingTile()
    }
}
