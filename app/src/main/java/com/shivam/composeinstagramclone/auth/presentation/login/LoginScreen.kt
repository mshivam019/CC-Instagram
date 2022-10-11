package com.shivam.composeinstagramclone.auth.presentation.login

import android.annotation.SuppressLint
import android.app.usage.UsageEvents.Event
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.shivam.composeinstagramclone.R
import com.shivam.composeinstagramclone.auth.presentation.AuthScreenEvents
import com.shivam.composeinstagramclone.auth.presentation.AuthViewModel
import com.shivam.composeinstagramclone.auth.presentation.ResultEvents
import com.shivam.composeinstagramclone.auth.presentation.destinations.RegisterScreenDestination
import com.shivam.composeinstagramclone.common.components.CustomFormTextField
import com.shivam.composeinstagramclone.common.components.CustomRaisedButton
import com.shivam.composeinstagramclone.ui.theme.AccentColor
import com.shivam.composeinstagramclone.ui.theme.LightGray
import com.shivam.composeinstagramclone.ui.theme.LineColor
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.shivam.composeinstagramclone.auth.model.currentUser
import com.shivam.composeinstagramclone.auth.presentation.destinations.MainScreenDestination
import kotlinx.coroutines.flow.collectLatest


@ExperimentalFoundationApi
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination
@Composable
fun LoginScreen(
    navigator: DestinationsNavigator,
    viewModel: AuthViewModel = hiltViewModel()
) {

    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true) {
        viewModel.eventChannelFlow.collectLatest {events:ResultEvents ->
            when (events) {
                is ResultEvents.OnError -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = events.message,
                        duration = SnackbarDuration.Short
                    )
                }
                is ResultEvents.OnSuccess -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = "Sign in Successful",
                        duration = SnackbarDuration.Short
                    )

                    navigator.navigate(MainScreenDestination)

                }
                else -> {}
            }
        }
    }

    Scaffold(scaffoldState = scaffoldState) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp)
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_instagram_logo),
                    contentDescription = null,
                )

                Spacer(modifier = Modifier.height(40.dp))

                FormSection(viewModel)

                Spacer(modifier = Modifier.height(40.dp))

                SignUpSection {
                    navigator.popBackStack()
                    navigator.navigate(RegisterScreenDestination)
                }
            }


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            ) {

                Box(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(LineColor)
                )

                Spacer(modifier = Modifier.height(18.dp))

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 40.dp)
                ) {
                    Text(
                        text = "Instagram from Meta",
                        style = MaterialTheme.typography.button,
                        color = LightGray,
                    )
                }
            }
        }
    }
}

@Composable
fun SignUpSection(onSignUpClicked: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .height(1.dp)
                .weight(1f)
                .background(LineColor)
        )

        Text(
            text = "OR",
            style = MaterialTheme.typography.body1,
            fontSize = 12.sp,
            color = LightGray,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)
        )

        Box(
            modifier = Modifier
                .height(1.dp)
                .weight(1f)
                .background(LineColor)
        )
    }

    Spacer(modifier = Modifier.height(40.dp))

    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 40.dp)
    ) {
        Text(
            text = "Don't have an account?",
            style = MaterialTheme.typography.button,
            color = LightGray,
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = "Sign up",
            style = MaterialTheme.typography.button,
            modifier = Modifier.clickable { onSignUpClicked() }
        )
    }
}


@Composable
fun ColumnScope.FormSection(viewModel: AuthViewModel) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    CustomFormTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        hint = "Email",
        value = email,
        keyboardType = KeyboardType.Email,
        onValueChange = { email = it },
    )

    Spacer(modifier = Modifier.height(12.dp))

    CustomFormTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        visualTransformation = PasswordVisualTransformation(),
        hint = "Password",
        value = password,
        onValueChange = { password = it }
    )

    Spacer(modifier = Modifier.height(20.dp))

    Text(
        text = "Forgot password?",
        style = MaterialTheme.typography.body1,
        fontSize = 12.sp,
        color = AccentColor,
        textAlign = TextAlign.End,
        modifier = Modifier
            .padding(end = 16.dp)
            .align(Alignment.End)
            .clickable { }
    )

    Spacer(modifier = Modifier.height(30.dp))

    CustomRaisedButton(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        text = "Log in",
        isLoading = viewModel.isLoading
    ) {
        viewModel.onUserEvents(
            AuthScreenEvents.OnLogin(
                email = email.trim(),
                password = password.trim(),
            )
        )
    }

    Spacer(modifier = Modifier.height(38.dp))

    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
        Icon(
            painter = painterResource(id = R.drawable.ic_facebook),
            contentDescription = null,
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = "Log in with Facebook",
            style = MaterialTheme.typography.body1,
            color = AccentColor
        )
    }
}