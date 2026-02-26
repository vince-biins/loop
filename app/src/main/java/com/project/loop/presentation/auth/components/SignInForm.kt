package com.project.loop.presentation.auth.components

import androidx.compose.foundation.background
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
    userNameField: FieldState,
    passwordField: FieldState,
    modifier: Modifier = Modifier
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
        onPrimaryClick = { /* handle sign in */ },
        showOtherSignInSection = true,
        bottomContent = {
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
                    )
                )
            }
        }
    )
}
//
//@Composable
//fun SignInForm(
//    userNameField: FieldState,
//    passwordField: FieldState,
//    modifier: Modifier = Modifier
//) {
//    Box(
//        modifier = modifier
//            .fillMaxWidth()
//            .shadow(
//                elevation = 12.dp,
//                shape = RoundedCornerShape(LoopDp.TWENTY_FOUR_DP),
//                clip = true,
//                spotColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
//            )
//            .clip(RoundedCornerShape(LoopDp.EIGHT_DP))
//            .background(LightBackground),
//        contentAlignment = Alignment.Center
//    ) {
//        Column(
//            modifier = modifier.padding(Padding.TWENTY_FOUR_DP),
//            verticalArrangement = Arrangement.spacedBy(
//                Spacing.SIXTEEN_DP,
//                Alignment.CenterVertically
//            ),
//            horizontalAlignment = Alignment.CenterHorizontally,
//        ) {
//            InputSection(
//                userNameField = userNameField,
//                passwordField = passwordField,
//            )
//
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.End
//            ) {
//                Text(
//                    text = stringResource(R.string.forgot_password),
//                    style = MaterialTheme.typography.bodySmall.copy(
//                        color = LoopPurple,
//                        fontWeight = FontWeight.W800
//                    )
//                )
//            }
//
//            LoopButton(
//                modifier = Modifier.fillMaxWidth(),
//                text = stringResource(R.string.sign_in),
//                onClick = {},
//                tailingIcon = {
//                    Icon(
//                        painter = painterResource(id = R.drawable.ic_arrow_forward),
//                        contentDescription = null,
//                        tint = Color.White,
//                        modifier = Modifier.size(20.dp)
//                    )
//                }
//            )
//
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.Center
//            ) {
//                HorizontalDivider(
//                    modifier = Modifier.weight(1f)
//                )
//                Text(
//                    modifier = Modifier.padding(horizontal = Padding.FOUR_DP),
//                    text = stringResource(R.string.or_continue_with),
//                    style = MaterialTheme.typography.bodyMedium.copy(
//                        color = Color.Gray,
//                        fontWeight = FontWeight.W600
//                    )
//                )
//                HorizontalDivider(
//                    modifier = Modifier.weight(1f)
//                )
//            }
//
//            OtherSigInSection()
//
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.Center
//            ) {
//
//                Text(
//
//                    text = stringResource(R.string.dont_have_account),
//                    style = MaterialTheme.typography.bodyMedium.copy(
//                        color = Color.Gray,
//                        fontWeight = FontWeight.W500
//                    )
//                )
//                Text(
//                    text = stringResource(R.string.sign_up),
//                    style = MaterialTheme.typography.bodyMedium.copy(
//                        color = LoopPurple,
//                        fontWeight = FontWeight.W800
//                    )
//                )
//
//            }
//
//        }
//    }
//}

@Composable
fun OtherSigInSection(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier.fillMaxWidth(),
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

@Composable
fun InputSection(
    userNameField: FieldState,
    passwordField: FieldState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(Spacing.EIGHT_DP, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        LoopTextField(
            title = stringResource(R.string.email_or_username),
            singleLine = true,
            placeholder = stringResource(R.string.email_or_username),
            onValueChange = userNameField.onValueChange,
            value = userNameField.value,
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_email),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = Color.Gray
                )
            },
            backgroundColor = Color.White,
        )

        LoopTextField(
            title = stringResource(R.string.password),
            placeholder = stringResource(R.string.password),
            singleLine = true,
            onValueChange = passwordField.onValueChange,
            value = passwordField.value,
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_lock),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = Color.Gray
                )
            },
            backgroundColor = Color.White,
            visualTransformation = PasswordVisualTransformation()
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
                passwordField = FieldState()
            )
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun InputSectionPreview() {
    MaterialTheme() {

        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            InputSection(
                userNameField = FieldState(),
                passwordField = FieldState()
            )

            InputSection(
                userNameField = FieldState(
                    value = "username@mail.com"
                ),
                passwordField = FieldState(
                    value = "password"
                )
            )
        }
    }

}