package com.example.nafasivibao.ui.theme.screens.product

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import com.example.nafasivibao.data.productviewmodel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductsScreen(navController: NavHostController) {
    var context = LocalContext.current
    val columnScrollableState = rememberScrollState()
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(columnScrollableState)
        .background(color = Color(243, 253, 232)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Add Product",
            style = TextStyle(letterSpacing = 2.sp),
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight(300),
            color = Color.Black,
            fontSize = 33.sp,
            textDecoration = TextDecoration.Underline
        )

        var productName by remember { mutableStateOf(TextFieldValue("")) }
        var productCompany by remember { mutableStateOf(TextFieldValue("")) }
        var productTime by remember { mutableStateOf(TextFieldValue("")) }
        var productResponsibilities by remember { mutableStateOf(TextFieldValue("")) }
        var productSkills by remember { mutableStateOf(TextFieldValue("")) }
        var productDocus by remember { mutableStateOf(TextFieldValue("")) }
        var productDeadliine by remember { mutableStateOf(TextFieldValue("")) }
        var productLocation by remember { mutableStateOf(TextFieldValue("")) }

        Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = productName,
                onValueChange = { productName = it },
                label = {
                    Text(
                        text = "Job Title *",
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
                    focusedBorderColor = Color(207, 239, 232, 255),
                    unfocusedBorderColor = Color.Black,
                ),
                shape = RoundedCornerShape(25.dp),
            )

            Spacer(modifier = Modifier.height(25.dp))

            OutlinedTextField(
                value = productCompany,
                onValueChange = { productCompany = it },
                label = {
                    Text(
                        text = "Company *",
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
                    focusedBorderColor = Color(207, 239, 232, 255),
                    unfocusedBorderColor = Color.Black,
                ),
                shape = RoundedCornerShape(25.dp),
            )

            Spacer(modifier = Modifier.height(25.dp))

            OutlinedTextField(
                value = productLocation,
                onValueChange = { productLocation = it },
                label = {
                    Text(
                        text = "Location *",
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
                    focusedBorderColor = Color(207, 239, 232, 255),
                    unfocusedBorderColor = Color.Black,
                ),
                shape = RoundedCornerShape(25.dp),
            )
            Spacer(modifier = Modifier.height(25.dp))
            OutlinedTextField(
                value = productTime,
                onValueChange = { productTime = it },
                label = {
                    Text(
                        text = "Duration *",
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
                    focusedBorderColor = Color(207, 239, 232, 255),
                    unfocusedBorderColor = Color.Black,
                ),
                shape = RoundedCornerShape(25.dp),
            )
            Spacer(modifier = Modifier.height(25.dp))
            OutlinedTextField(
                value = productResponsibilities,
                onValueChange = { productResponsibilities = it },
                label = {
                    Text(
                        text = "Responsibilities *",
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
                    focusedBorderColor = Color(207, 239, 232, 255),
                    unfocusedBorderColor = Color.Black,
                ),
                shape = RoundedCornerShape(25.dp),
            )
            Spacer(modifier = Modifier.height(25.dp))
            OutlinedTextField(
                value = productSkills,
                onValueChange = { productSkills = it },
                label = {
                    Text(
                        text = "Skills required *",
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
                    focusedBorderColor = Color(207, 239, 232, 255),
                    unfocusedBorderColor = Color.Black,
                ),
                shape = RoundedCornerShape(25.dp),
            )
            Spacer(modifier = Modifier.height(25.dp))
            OutlinedTextField(
                value = productDocus,
                onValueChange = { productDocus = it },
                label = {
                    Text(
                        text = "Needed Documents *",
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
                    focusedBorderColor = Color(207, 239, 232, 255),
                    unfocusedBorderColor = Color.Black,
                ),
                shape = RoundedCornerShape(25.dp),
            )
            Spacer(modifier = Modifier.height(25.dp))
            OutlinedTextField(
                value = productDeadliine,
                onValueChange = { productDeadliine = it },
                label = {
                    Text(
                        text = "Application Deadline *",
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
                    focusedBorderColor = Color(207, 239, 232, 255),
                    unfocusedBorderColor = Color.Black,
                ),
                shape = RoundedCornerShape(25.dp),
            )
            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    //-----------WRITE THE SAVE LOGIC HERE---------------//
                    var productRepository = productviewmodel(navController, context)
                    productRepository.saveProduct(
                        productName.text.trim(),
                        productCompany.text.trim(),
                        productLocation.text.trim(),
                        productTime.text.trim(),
                        productResponsibilities.text.trim(),
                        productSkills.text.trim(),
                        productDocus.text.trim(),
                        productDeadliine.text.trim()
                    )
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Black,
                    containerColor = Color(158, 210, 190)
                ),
                modifier = Modifier.padding(bottom = 10.dp)
            ) {
                Text(
                    text = "Save",
                    style = TextStyle(letterSpacing = 2.sp),
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(300),
                    color = Color.Black,
                    fontSize = 20.sp,
                )
            }
        }
    }


@Preview
@Composable
fun Addpr() {
    AddProductsScreen(rememberNavController())

}