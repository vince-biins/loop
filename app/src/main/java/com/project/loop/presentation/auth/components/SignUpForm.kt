package com.project.loop.presentation.auth.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.project.loop.R
import com.project.loop.base.theme.LoopPurple
import com.project.loop.presentation.common.FieldState
import com.project.loop.presentation.common.InputFieldData

@Composable
fun SignUpForm(
    fullNameField: FieldState,
    emailField: FieldState,
    confirmPasswordField: FieldState,
    passwordField: FieldState,
    modifier: Modifier = Modifier
) {
    val signUpFields = listOf(
        InputFieldData(
            placeholder = stringResource(R.string.full_name),
            fieldState = fullNameField,
            leadingIcon = R.drawable.ic_person,
        ),
        InputFieldData(
            placeholder = stringResource(R.string.email_address),
            fieldState = emailField,
            leadingIcon = R.drawable.ic_email,
        ),
        InputFieldData(
            placeholder = stringResource(R.string.password),
            fieldState = passwordField,
            leadingIcon = R.drawable.ic_lock,
            visualTransformation = PasswordVisualTransformation()
        ),
        InputFieldData(
            placeholder = stringResource(R.string.confirm_password),
            fieldState = confirmPasswordField,
            leadingIcon = R.drawable.ic_lock,
            visualTransformation = PasswordVisualTransformation()
        )
    )

    AuthForm(
        modifier = modifier,
        fields = signUpFields,
        primaryButtonText = stringResource(R.string.sign_up),
        onPrimaryClick = { /* handle sign up */ },
        showOtherSignInSection = false,
        bottomContent = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.already_have_account),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.Gray,
                        fontWeight = FontWeight.W500
                    )
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = stringResource(R.string.sign_in),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = LoopPurple,
                        fontWeight = FontWeight.W800
                    )
                )
            }
        }
    )
}