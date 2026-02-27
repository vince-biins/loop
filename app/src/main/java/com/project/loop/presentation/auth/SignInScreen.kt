package com.project.loop.presentation.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.project.loop.R
import com.project.loop.base.composable.LoopDp
import com.project.loop.base.composable.Padding
import com.project.loop.base.theme.LoopGradients
import com.project.loop.presentation.auth.components.HeaderSection
import com.project.loop.presentation.auth.components.SignInForm
import com.project.loop.presentation.common.FieldState

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    onSignInClick: () -> Unit,
    onNavigateToSignUp: () -> Unit
) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(LoopGradients.LoopDiagonalGradient)
    ) {
        SignInContent(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = Padding.SIXTEEN_DP, vertical = Padding.TWENTY_FOUR_DP),
            onSignInClick = onSignInClick,
            onSignUpClick = onNavigateToSignUp
        )


    }
}

@Composable
fun SignInContent(
    modifier: Modifier = Modifier,
    onSignInClick: () -> Unit,
    onSignUpClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .imePadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HeaderSection(
            title = stringResource(R.string.app_name),
            description = stringResource(R.string.sign_in_welcome_message)
        )

        Spacer(modifier = Modifier.height(LoopDp.FORTY_DP))

        SignInForm(
            userNameField = FieldState(),
            passwordField = FieldState(),
            onSignInClick = onSignInClick,
            onSignUpClick = onSignUpClick,
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun SignInContentPreview() {
    MaterialTheme {
        SignInScreen(
            onSignInClick = {},
            onNavigateToSignUp = {}
        )
    }

}