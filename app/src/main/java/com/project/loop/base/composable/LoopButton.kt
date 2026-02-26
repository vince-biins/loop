package com.project.loop.base.composable

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.project.loop.R
import com.project.loop.base.theme.LoopGradients
import com.project.loop.base.theme.LoopTheme

@Composable
fun LoopButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    height: Dp = LoopDp.FIFTY_SIX_DP,
    isLoading: Boolean = false,
    leadingIcon: (@Composable (() -> Unit))? = null,
    tailingIcon: (@Composable (() -> Unit))? = null,
    backgroundColor: Color? = null,
    style: TextStyle = MaterialTheme.typography.titleMedium.copy(
        color = if (enabled) Color.White else MaterialTheme.colorScheme.onSurfaceVariant,
        fontWeight = FontWeight.Bold
    ),
    shape: RoundedCornerShape = RoundedCornerShape(16.dp),
) {

    val buttonBrush = when {
        backgroundColor != null -> Brush.horizontalGradient(
            colors = listOf(backgroundColor, backgroundColor)
        )
        enabled -> LoopGradients.LoopHorizontalGradient
        else -> Brush.horizontalGradient(
            colors = listOf(
                MaterialTheme.colorScheme.outline.copy(alpha = 0.3f),
                MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)
            )
        )
    }

    Box(
        modifier = modifier
            .height(height)
            .shadow(
                elevation = if (enabled && !isLoading) 12.dp else 0.dp,
                shape = shape,
                clip = false,
                spotColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
            )
            .clip(shape)
            .background(buttonBrush)
            .clickable(
                enabled = enabled && !isLoading,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(24.dp),
                color = Color.White,
                strokeWidth = 2.dp
            )
        } else {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                if (leadingIcon != null) {
                    leadingIcon.invoke()
                    Spacer(modifier = Modifier.width(8.dp))
                }

                Text(
                    text = text,
                    style = style
                )
                if (tailingIcon != null) {
                    Spacer(modifier = Modifier.width(8.dp))
                    tailingIcon.invoke()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoopButtonPreview() {
    LoopTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            LoopButton(
                text = stringResource(id = R.string.sign_in),
                onClick = {}
            )
            
            LoopButton(
                text = "Loading...",
                onClick = {},
                isLoading = true
            )
            
            LoopButton(
                text = "Disabled",
                onClick = {},
                enabled = false
            )
        }
    }
}
