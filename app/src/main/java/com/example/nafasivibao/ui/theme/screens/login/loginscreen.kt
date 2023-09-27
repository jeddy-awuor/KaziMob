package com.example.nafasivibao.ui.theme.screens.login


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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import com.example.nafasivibao.R
import com.example.nafasivibao.data.AuthViewModel
import com.example.nafasivibao.navigation.ROUTE_REGISTER
import com.example.nafasivibao.ui.theme.MooliFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(251, 243, 235)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,


        ) {
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = " Welcome Back ! ",
            modifier = Modifier.padding(top= 3.dp),
            fontFamily = MooliFont ,
            fontWeight = FontWeight(400),
            color = Color(68, 69, 74),
            fontSize = 32.sp,
        )
        Image(painter = painterResource(id = R.drawable.jobhhunting) ,
            contentDescription = "sitting",
            modifier = Modifier.size(290.dp),
        )
        OutlinedTextField( value = email,
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
                unfocusedBorderColor = Color.Black,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedBorderColor = Color(201, 121, 71),
            ),
            trailingIcon = {
                Icon(imageVector = Icons.Outlined.Email, contentDescription ="Enter Email",tint = Color.DarkGray )
            },
            shape = RoundedCornerShape(25.dp),
            onValueChange = {
                email = it
            },
        )
        Spacer(modifier = Modifier.height(25.dp))
        var passwordvisibilitty by remember { mutableStateOf(false) }
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
                    color = Color . Black,
                    fontSize = 20.sp,
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                IconButton(onClick = { passwordvisibilitty = !passwordvisibilitty }) {
                    Icon(contentDescription ="Visibility Icon", painter = icon,tint = Color.DarkGray)

                }
            },
            visualTransformation = if(passwordvisibilitty) VisualTransformation.None
            else PasswordVisualTransformation(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedBorderColor = Color(201, 121, 71),
                unfocusedBorderColor = Color.Black,
            ),
            shape = RoundedCornerShape(25.dp),
            onValueChange = {
                password = it
            },
        )
        Spacer(modifier = Modifier.height(40.dp))


        Button(
            onClick = {
                var mylogin = AuthViewModel(navController, context)
                mylogin.login(email.text, password.text)
            },
            modifier = Modifier.width(170.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color(255, 159, 65)
            ),
        ) {
            Text(
                text = "Login",
                style = TextStyle(letterSpacing = 3.sp),
                color = Color(68, 69, 74),
                fontFamily = MooliFont,
                fontWeight = FontWeight(200),
                fontSize = 20.sp,
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {   navController.navigate(ROUTE_REGISTER) },
            modifier = Modifier.width(280.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color(255, 159, 65)
            ),
        ) {
            Text(
                text = "New here?",
                style = TextStyle(letterSpacing = 2.sp),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(200),
                fontSize = 19.sp,
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "Sign Up",
                color = Color(68, 69, 74),
                style = TextStyle(letterSpacing = 2.sp),
                fontFamily =  MooliFont,
                fontWeight = FontWeight(300),
                fontSize = 20.sp,
            )
        }
    }
}