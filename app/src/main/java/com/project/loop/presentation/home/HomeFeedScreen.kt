package com.project.loop.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.project.loop.base.composable.LoopDp
import com.project.loop.base.composable.Padding
import com.project.loop.data.MockData
import com.project.loop.presentation.home.components.PostItem

@Composable
fun HomeFeedScreen(modifier: Modifier = Modifier) {
    HomeFeedContent(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = Padding.SIXTEEN_DP)
    )
}

@Composable
fun HomeFeedContent(modifier: Modifier = Modifier) {

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(Padding.SIXTEEN_DP)
    ) {
        item { Spacer(modifier.height(LoopDp.EIGHT_DP)) }
        items(MockData.posts) { post ->
            PostItem(post = post)
        }
        item { Spacer(modifier.height(LoopDp.SIXTEEN_DP)) }
    }
}