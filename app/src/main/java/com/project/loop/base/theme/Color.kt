package com.project.loop.base.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val LoopPink = Color(0xFFE1067B)
val LoopPurple = Color(0xFFB32FCF)
val LoopPurpleDarker = Color(0xFF5214A9)
val LoopPurple2 = Color(0xFFCF2FBF)
val LoopOrange = Color(0xFFF7594C)
val LightBackground = Color(0xFFFDFDFD)
val LightSurface = Color(0xFFFFFFFF)
val LightSurfaceVariant = Color(0xFFE5E4E5)
val LightTextPrimary = Color(0xFF272B33)
val LightTextSecondary = Color(0xFF72675E)
val LightOutline = Color(0xFFC3BFBD)
val DarkBackground = Color(0xFF121212)
val DarkSurface = Color(0xFF1E1E1E)
val DarkSurfaceVariant = Color(0xFF2A2A2A)
val DarkTextPrimary = Color(0xFFEDEDED)
val DarkTextSecondary = Color(0xFFBDBDBD)
val DarkOutline = Color(0xFF444444)
val ErrorRed = Color(0xFFCF6679)


object LoopGradients {
    val LoopHorizontalGradient = Brush.horizontalGradient(
        colors = listOf(
            LoopPurple,
            LoopPink,
            LoopOrange
        )
    )

    val LoopVerticalGradient = Brush.verticalGradient(
        colors = listOf(
            LoopPurple,
            LoopPink,
            LoopOrange
        )
    )

    val LoopDiagonalGradient = Brush.linearGradient(
        colors = listOf(
            LoopPurple,
            LoopPink,
            LoopOrange
        ),
        start = Offset(0f, 0f),
        end = Offset(1000F, 1000F)
    )
}
