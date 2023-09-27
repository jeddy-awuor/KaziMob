package com.example.nafasivibao.ui.theme.screens.about

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.nafasivibao.R

@Composable
fun PostOffice() {
   Column(modifier = Modifier
       .fillMaxSize(),
   horizontalAlignment = Alignment.CenterHorizontally,
       verticalArrangement = Arrangement.Center) {

       var passcode by rememberSaveable { mutableStateOf("") }
       var passwordvisibility by remember { mutableStateOf(false) }
       val icon = if (passwordvisibility) {
           painterResource(id = com.google.android.material.R.drawable.design_ic_visibility)
       } else painterResource(id = com.google.android.material.R.drawable.design_ic_visibility_off)
       OutlinedTextField(value = passcode,
           onValueChange ={
               passcode = it
                          },
           placeholder = { Text(text = "Password")},
           label = { Text(text = "Password")},
           trailingIcon = {
               IconButton(onClick = { passwordvisibility = !passwordvisibility }) {
                   Icon(contentDescription ="Visibility Icon", painter = icon)

               }
           },
           keyboardOptions = KeyboardOptions(
               keyboardType = KeyboardType.Password
           ),
           visualTransformation = if(passwordvisibility) VisualTransformation.None
           else PasswordVisualTransformation()

       )

   }

}