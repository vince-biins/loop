package com.project.loop.presentation.auth.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.loop.R
import com.project.loop.base.composable.LoopButton
import com.project.loop.base.composable.LoopDp
import com.project.loop.base.composable.LoopTextField
import com.project.loop.base.composable.Padding
import com.project.loop.base.composable.Spacing
import com.project.loop.base.theme.LightBackground
import com.project.loop.base.theme.LightSurface
import com.project.loop.base.theme.LightSurfaceVariant
import com.project.loop.base.theme.LightTextPrimary
import com.project.loop.base.theme.LightTextSecondary
import com.project.loop.base.theme.LoopGradients
import com.project.loop.base.theme.LoopPurple
import com.project.loop.presentation.common.DynamicInputSection
import com.project.loop.presentation.common.FieldState
import com.project.loop.presentation.common.InputFieldData


@Composable
fun AuthForm(
    modifier: Modifier = Modifier,
    fields: List<InputFieldData>,
    primaryButtonText: String,
    onPrimaryClick: () -> Unit,
    showOtherSignInSection: Boolean = true,
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

            if (showOtherSignInSection) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    HorizontalDivider(modifier = Modifier.weight(1f))
                    Text(
                        modifier = Modifier.padding(horizontal = 4.dp),
                        text = stringResource(R.string.or_continue_with),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = Color.Gray,
                            fontWeight = FontWeight.W600
                        )
                    )
                    HorizontalDivider(modifier = Modifier.weight(1f))
                }

                OtherSigInSection()
            }

            bottomContent()
        }
    }
}