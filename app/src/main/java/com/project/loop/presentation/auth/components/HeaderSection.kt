package com.project.loop.presentation.auth.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.loop.R
import com.project.loop.base.composable.LoopDp
import com.project.loop.base.theme.LoopGradients
import com.project.loop.base.theme.LoopTheme

@Composable
fun HeaderSection(
    title: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = title,
            style = MaterialTheme.typography.displayLarge.copy(
                letterSpacing = 3.sp,
                fontWeight = FontWeight.Bold
            ),
            color = Color.White
        )
        Spacer(modifier = Modifier.height(LoopDp.SIXTEEN_DP))
        Text(
            text = description,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HeaderSectionPreview() {
    LoopTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(LoopGradients.LoopDiagonalGradient)
        ) {
            HeaderSection(
                title = "Loop",
                description = "The best way to learn"
            )
        }

    }
}