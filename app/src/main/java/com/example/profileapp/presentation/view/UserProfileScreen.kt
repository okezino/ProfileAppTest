package com.example.profileapp.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.profileapp.data.model.UserProfile
import com.example.profileapp.presentation.MainViewModel
import com.example.profileapp.ui.theme.Purple200
import com.example.profileapp.ui.theme.White

@Composable
fun UserProfileScreen(navController: NavController, list: List<UserProfile> = emptyList()) {

    val searchValue = remember {
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
                text = "Search",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp
                ),
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.padding(20.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                TextField(
                    value = searchValue.value,
                    shape = RoundedCornerShape(35.dp),
                    onValueChange = { searchValue.value = it },

                    placeholder = { Text(text = "Search for name, phone , account number") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(0.9f),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Gray,
                        disabledTextColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    )



                    )



                Spacer(modifier = Modifier.padding(10.dp))

                //  LazyColumn(content = )

                Spacer(modifier = Modifier.padding(20.dp))

            }
        }
    }

}