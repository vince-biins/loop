package com.project.loop.base.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.project.loop.R
import com.project.loop.base.theme.LoopTheme

@Composable
fun LoopTextField(
    modifier: Modifier = Modifier,
    value: String,
    title: String? = null,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    trailingIcon: (@Composable (() -> Unit))? = null,
    leadingIcon: (@Composable (() -> Unit))? = null,
    errorMessage: String? = null,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    hasBorder: Boolean = true,
    shape: Shape = RoundedCornerShape(LoopDp.SIXTEEN_DP),
    enabled: Boolean = true,
    readOnly: Boolean = false,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    minHeight: Dp? = null,
) {
    val isPassword = visualTransformation is PasswordVisualTransformation
    var passwordVisible by remember { mutableStateOf(!isPassword) }


    val isError = !errorMessage.isNullOrEmpty()
    Column(modifier = modifier.fillMaxWidth()) {
        if(!title.isNullOrEmpty()){
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier.padding(Padding.FOUR_DP)
            )
        }
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .then(
                    if (minHeight != null) Modifier.heightIn(min = minHeight) else Modifier
                ),
            placeholder = {
                Text(
                    text = placeholder,
                    style = MaterialTheme.typography.bodyLarge
                )
            },
            leadingIcon = leadingIcon,
            trailingIcon = {
                if (isPassword) {
                    val icon =
                        if (passwordVisible) R.drawable.ic_eye_open else R.drawable.ic_eye_closed
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = painterResource(id = icon),
                            contentDescription = if (passwordVisible) "Hide password" else "Show password",
                            tint = Color.Gray
                        )
                    }
                } else {
                    trailingIcon?.invoke()
                }
            },
            isError = isError,
            singleLine = singleLine,
            maxLines = maxLines,
            textStyle = MaterialTheme.typography.bodyLarge,
            visualTransformation = if(isPassword && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None ,
            keyboardOptions = keyboardOptions,
            enabled = enabled,
            readOnly = readOnly,
            shape = if (hasBorder) shape else RectangleShape,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = if (hasBorder) {
                    if (isError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.outline.copy(
                        alpha = 0.5f
                    )
                } else Color.Transparent,
                focusedBorderColor = if (hasBorder) {
                    if (isError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary
                } else Color.Transparent,
                unfocusedContainerColor = backgroundColor,
                focusedContainerColor = backgroundColor,
                errorBorderColor = MaterialTheme.colorScheme.error,
                errorLeadingIconColor = MaterialTheme.colorScheme.error,
                unfocusedLeadingIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                focusedLeadingIconColor = if (isError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary,
                unfocusedPlaceholderColor = MaterialTheme.colorScheme.onSurfaceVariant,
                focusedPlaceholderColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
            )
        )

        if (!errorMessage.isNullOrEmpty()) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 16.dp, top = 4.dp)
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFDF0F5)
@Composable
private fun LoopTextFieldPreview() {
    LoopTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            LoopTextField(
                value = "description",
                onValueChange = { },
                placeholder = "Enter description",
                singleLine = false,
                maxLines = 5,
                minHeight = 120.dp
            )

            LoopTextField(
                value = "description",
                title = "username",
                onValueChange = { },
                placeholder = "Enter description",
                singleLine = true,
            )
        }
    }
}
