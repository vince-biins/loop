package com.project.loop.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.project.loop.base.composable.LoopTextField

data class InputFieldData(
    val title: String = "",
    val placeholder: String = "",
    val fieldState: FieldState,
    val leadingIcon: Int? = null,
    val visualTransformation: VisualTransformation = VisualTransformation.None,
    val singleLine: Boolean = true,
    val maxLines: Int = 1
)


@Composable
fun DynamicInputSection(
    fields: List<InputFieldData>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        fields.forEach { field ->
            LoopTextField(
                title = field.title,
                placeholder = field.placeholder,
                value = field.fieldState.value,
                onValueChange = field.fieldState.onValueChange,
                leadingIcon = field.leadingIcon?.let {
                    { Icon(painter = painterResource(id = it), contentDescription = null, modifier = Modifier.size(24.dp)) }
                },
                visualTransformation = field.visualTransformation,
                singleLine = field.singleLine,
                maxLines = field.maxLines,
                backgroundColor = Color.White
            )
        }
    }
}