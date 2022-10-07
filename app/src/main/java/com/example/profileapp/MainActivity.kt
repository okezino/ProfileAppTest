package com.example.profileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.TextUnitType.Companion.Sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.profileapp.presentation.view.LoginScreen
import com.example.profileapp.presentation.view.UserProfileScreen
import com.example.profileapp.ui.theme.ProfileAppTheme
import com.example.profileapp.ui.theme.Purple200
import com.example.profileapp.ui.theme.White


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileAppTheme {
                // A surface container using the 'background' color from the theme
                UserProfileApplication()
            }
        }
    }
}

@Composable
fun UserProfileApplication(){
    val navController = rememberNavController()

   NavHost(navController = navController, startDestination = "login_screen", builder = {
      composable("login_screen", content = { LoginScreen(navController = navController)})
       composable("user_profile_screen", content = { UserProfileScreen(navController = navController)})
   })
}





