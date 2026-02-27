package com.project.loop.presentation.auth.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import com.project.loop.presentation.common.FieldState
import com.project.loop.presentation.common.InputFieldData


@Composable
fun SignInForm(
    modifier: Modifier = Modifier,
    userNameField: FieldState,
    passwordField: FieldState,
    onSignInClick: () -> Unit,
    onSignUpClick: () -> Unit
) {
    val signInFields = listOf(
        InputFieldData(
            title = stringResource(R.string.email_or_username),
            placeholder = stringResource(R.string.email_or_username),
            fieldState = userNameField,
            leadingIcon = R.drawable.ic_email
        ),
        InputFieldData(
            title = stringResource(R.string.password),
            placeholder = stringResource(R.string.password),
            fieldState = passwordField,
            leadingIcon = R.drawable.ic_lock,
            visualTransformation = PasswordVisualTransformation()
        )
    )

    AuthForm(
        modifier = modifier,
        fields = signInFields,
        primaryButtonText = stringResource(R.string.sign_in),
        onPrimaryClick = onSignInClick,
        bottomContent = {

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

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.dont_have_account),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.Gray,
                        fontWeight = FontWeight.W500
                    )
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = stringResource(R.string.sign_up),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = LoopPurple,
                        fontWeight = FontWeight.W800
                    ),
                    modifier = Modifier.clickable{
                        onSignUpClick()
                    }
                )
            }
        }
    )
}

@Composable
fun OtherSigInSection(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        LoopButton(
            modifier = Modifier.weight(1f),
            text = "Google",
            onClick = {},
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = Color.Unspecified
                )
            },
            backgroundColor = Color.White,
            style = MaterialTheme.typography.bodyMedium.copy(
                color = LightTextSecondary
            ),
            height = LoopDp.FORTY_DP,
            shape = RoundedCornerShape(LoopDp.EIGHT_DP)
        )
        Spacer(modifier = Modifier.width(Spacing.TWENTY_FOUR_DP))
        LoopButton(
            modifier = Modifier.weight(1f),
            text = "Facebook",
            onClick = {},
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.fb),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = Color.Unspecified
                )
            },
            backgroundColor = Color.White,
            style = MaterialTheme.typography.bodyMedium.copy(
                color = LightTextSecondary
            ),
            height = LoopDp.FORTY_DP,
            shape = RoundedCornerShape(LoopDp.EIGHT_DP)
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SignInFormPreview() {
    MaterialTheme() {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(LoopGradients.LoopHorizontalGradient)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            SignInForm(
                userNameField = FieldState(),
                passwordField = FieldState(),
                onSignInClick = {},
                onSignUpClick = {},
            )
        }
    }

}
