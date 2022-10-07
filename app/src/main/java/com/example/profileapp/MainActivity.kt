package com.example.profileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.profileapp.presentation.view.LoginScreen
import com.example.profileapp.presentation.view.UserProfileScreen
import com.example.profileapp.ui.theme.ProfileAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
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





