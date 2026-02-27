package com.project.loop.presentation.auth.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.project.loop.R
import com.project.loop.base.composable.LoopButton
import com.project.loop.base.composable.LoopTextField
import com.project.loop.base.theme.LightBackground
import com.project.loop.presentation.common.InputFieldData


@Composable
fun AuthForm(
    modifier: Modifier = Modifier,
    fields: List<InputFieldData>,
    primaryButtonText: String,
    onPrimaryClick: () -> Unit,
    bottomContent: @Composable ColumnScope.() -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 12.dp,
                shape = RoundedCornerShape(24.dp),
                clip = true,
                spotColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
            )
            .clip(RoundedCornerShape(8.dp))
            .background(LightBackground),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            DynamicInputSection(fields = fields)

            LoopButton(
                modifier = Modifier.fillMaxWidth(),
                text = primaryButtonText,
                onClick = onPrimaryClick,
                tailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_forward),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
            )

            bottomContent()
        }
    }
}

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
                    { Icon(painter = painterResource(id = it), contentDescription = null, modifier = Modifier.size(24.dp), tint = field.leadingIconTint) }
                },
                visualTransformation = field.visualTransformation,
                singleLine = field.singleLine,
                maxLines = field.maxLines,
                backgroundColor = Color.White
            )
        }
    }
}