package com.project.loop.presentation.common

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation

data class InputFieldData(
    val title: String = "",
    val placeholder: String = "",
    val fieldState: FieldState,
    val leadingIcon: Int? = null,
    val leadingIconTint: Color = Color.Gray,
    val visualTransformation: VisualTransformation = VisualTransformation.None,
    val singleLine: Boolean = true,
    val maxLines: Int = 1
)
