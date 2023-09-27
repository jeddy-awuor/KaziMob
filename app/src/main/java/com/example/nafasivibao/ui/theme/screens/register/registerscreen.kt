package com.example.nafasivibao.ui.theme.screens.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition

import com.example.nafasivibao.R
import com.example.nafasivibao.data.AuthViewModel
import com.example.nafasivibao.navigation.ROUTE_LOGIN
import com.example.nafasivibao.ui.theme.MooliFont


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavHostController) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var confirmpassword by remember { mutableStateOf(TextFieldValue("")) }
    val columnScrollableState = rememberScrollState()
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .verticalScroll(columnScrollableState)
            .fillMaxSize()
            .background(Color(251, 243, 235)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top

    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "  Create Your Account ",
            fontFamily = FontFamily.Cursive,
            color = Color(68, 69, 74),
            fontSize = 35.sp,
        )
        Spacer(modifier = Modifier.height(20.dp))

        Image(painter = painterResource(id = R.drawable.usering) ,
            contentDescription = "sitting",
            modifier = Modifier.size(200.dp),
        )

        Spacer(modifier = Modifier.height(25.dp))

        OutlinedTextField(
            value = email,
            label = {
                Text(
                    text = "Email",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(100),
                    color = Color.Black,
                    fontSize = 20.sp,
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedBorderColor = Color(201, 121, 71),
                unfocusedBorderColor = Color.Black,
            ),
            trailingIcon = {
                Icon(imageVector = Icons.Outlined.Email, contentDescription ="Enter Email",tint = Color.Black )
            },
            shape = RoundedCornerShape(25.dp),
            onValueChange = {
                email = it
            },

            )

        Spacer(modifier = Modifier.height(25.dp))
        var passwordvisibilitty by remember { mutableStateOf(false) }
        var confirmpasswordvisibilitty by remember { mutableStateOf(false) }
        val icon = if (passwordvisibilitty) {
            painterResource(id = com.google.android.material.R.drawable.design_ic_visibility)
        } else painterResource(id = com.google.android.material.R.drawable.design_ic_visibility_off)
        OutlinedTextField(
            value = password,
            label = {
                Text(
                    text = "Password",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(100),
                    color = Color.Black,
                    fontSize = 20.sp,
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedBorderColor = Color(201, 121, 71),
                unfocusedBorderColor = Color.Black,
            ),
            trailingIcon = {
                IconButton(onClick = { passwordvisibilitty = !passwordvisibilitty }) {
                    Icon(contentDescription ="Visibility Icon", painter = icon,tint = Color.Black)

                }
            },
            visualTransformation = if(passwordvisibilitty) VisualTransformation.None
            else PasswordVisualTransformation(),
            shape = RoundedCornerShape(25.dp),
            onValueChange = {
                password = it
            },

            )
        Spacer(modifier = Modifier.height(25.dp))
        OutlinedTextField(
            value = confirmpassword,
            label = {
                Text(
                    text = "Confirm password",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(100),
                    color = Color.Black,
                    fontSize = 20.sp,
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedBorderColor = Color(201, 121, 71),
                unfocusedBorderColor = Color.Black,
            ),
            trailingIcon = {
                IconButton(onClick = { passwordvisibilitty = !passwordvisibilitty }) {
                    Icon(contentDescription ="Visibility Icon", painter = icon,tint = Color.Black)

                }
            },
            visualTransformation = if(passwordvisibilitty) VisualTransformation.None
            else PasswordVisualTransformation(),
            shape = RoundedCornerShape(25.dp),
            onValueChange = {
                confirmpassword = it
            },

            )
        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                val myregister = AuthViewModel(navController, context)
                myregister.signup(
                    email.text.trim(),
                    password.text.trim(),
                    confirmpassword.text.trim()
                )
            },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color(255, 159, 65)
            ),
        ) {
            Text(
                text = "Sign Up",
                style = TextStyle(letterSpacing = 2.sp),
                fontFamily = MooliFont,
                color = Color(68, 69, 74),
                fontWeight = FontWeight(300),
                fontSize = 20.sp,
            )
        }
        Spacer(modifier = Modifier.height(25.dp))
        Button(
            onClick = { navController.navigate(ROUTE_LOGIN) },
            modifier = Modifier. width(300.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color(255, 159, 65)
            ),
        ) {
            Text(
                text = "Have an account? ",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(200),
                fontSize = 19.sp,
            )
            Text(
                text = "Login",
                color = Color(68, 69, 74),
                style = TextStyle(letterSpacing = 2.sp),
                fontFamily = MooliFont,
                fontWeight = FontWeight(300),
                fontSize = 20.sp,
            )
        }
    }
}