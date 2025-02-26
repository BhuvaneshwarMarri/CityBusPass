package com.example.buspassapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.buspassapplication.AuthenticationScreenRoutes
import com.example.buspassapplication.components.HeadingText
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.components.OutlinedInputField
import com.example.buspassapplication.components.PasswordField
import com.example.buspassapplication.components.PrimaryButton
import com.example.buspassapplication.graphs.Graph
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.NavyBlue
import com.example.buspassapplication.ui.theme.PoppinsMedium

@ExperimentalMaterial3Api
@Composable
fun LoginScreen(
    navController: NavController
){

    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            HeadingText(
                value = "Hey there,",
                isSmall = true
            )
            HeadingText(
                value = "Welcome back!",
                isSmall = false
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedInputField(
                label = "Email",
                modifier = Modifier.width(330.dp),
                value = email,
                onValueChange = { email = it }
            )
            Spacer(modifier = Modifier.height(20.dp))
            PasswordField(
                modifier = Modifier.width(330.dp),
                label = "Password",
                value = password,
                onValueChange = { password = it }
            )
            Spacer(modifier = Modifier.height(25.dp))
            Row {
                NormalText(
                    value= "Forgot password? ",
                    fontSize = 15.sp,
                    fontFamily = PoppinsMedium,
                    color = DarkGray,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                )
                NormalText(
                    value= "Reset",
                    fontSize = 15.sp,
                    fontFamily = PoppinsMedium,
                    color = NavyBlue,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.clickable {
                        navController.navigate(route = AuthenticationScreenRoutes.ForgotPassword.route) {
                            launchSingleTop = true
                        }
                    }
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
            PrimaryButton(
                text = "Submit",
                width = 280.dp,
                height = 45.dp,
                borderShape = RoundedCornerShape(50)
            ) {
                navController.navigate(route = Graph.MAIN) {
                    popUpTo(route = Graph.AUTHENTICATION) {
                        inclusive = true
                    }
                }
            }
            Row(
                modifier = Modifier.padding(top = 15.dp)
            ) {
                NormalText(
                    value = "Not a member? ",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = PoppinsMedium,
                    color = DarkGray,
                    modifier = Modifier
                )
                NormalText(
                    value = "Signup",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = PoppinsMedium,
                    color = NavyBlue,
                    modifier = Modifier.clickable {
                        navController.navigate(route = AuthenticationScreenRoutes.Signup.route) {
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun LoginPreview(){
    LoginScreen(navController = rememberNavController())
}