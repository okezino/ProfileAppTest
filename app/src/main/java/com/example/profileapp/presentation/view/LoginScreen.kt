package com.example.profileapp.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.profileapp.ui.theme.Purple200
import com.example.profileapp.ui.theme.White

@Composable
fun LoginScreen(navController: NavController) {

    val emailValue = remember {
        mutableStateOf("")
    }

    val password = remember {
        mutableStateOf("")
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.60f)
                .padding(10.dp)

        ) {
            Text(
                text = "Login",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp
                ),
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.padding(20.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                OutlinedTextField(
                    value = emailValue.value,
                    onValueChange = {
                        emailValue.value = it

                    },
                    label = { Text(text = "Email") },
                    placeholder = { Text(text = "Email") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(0.8f))

                OutlinedTextField(
                    value = password.value,
                    onValueChange = {
                        password.value = it

                    },
                    label = { Text(text = "Password") },
                    placeholder = { Text(text = "Password") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(0.8f))

                Spacer(modifier = Modifier.padding(10.dp))

                Button(onClick = { navController.navigate("user_profile_screen") },
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .background(Purple200)
                        .height(50.dp)) {
                    Text(text = "login", fontSize = 20.sp, color = White)
                }

                Spacer(modifier = Modifier.padding(20.dp))

            }
        }
    }

}