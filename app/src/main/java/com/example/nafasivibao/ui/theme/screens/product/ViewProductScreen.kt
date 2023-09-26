@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.nafasivibao.ui.theme.screens.product

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import com.example.nafasivibao.data.productviewmodel
import com.example.nafasivibao.models.Product
import com.example.nafasivibao.navigation.ROUTE_UPDATE
import com.example.nafasivibao.navigation.ROUTE_VIEWADDED
import com.example.nafasivibao.navigation.ROUTE_VIEWCOMP



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewProductsScreen(navController: NavHostController) {
    var context = LocalContext.current
    var productRepository = productviewmodel(navController, context)
    val emptyProductState = remember { mutableStateOf(Product("", "", "", "", "", "", "", "", "")) }
    var emptyProductsListState = remember { mutableStateListOf<Product>() }

    var products = productRepository.viewProducts(emptyProductState, emptyProductsListState)
    val columnScrollableState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(243, 253, 232)),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "View Products",
            style = TextStyle(letterSpacing = 3.sp),
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight(300),
            color = Color.Black,
            fontSize = 33.sp,
            textDecoration = TextDecoration.Underline,
        )
        Spacer(modifier = Modifier.height(3.dp))
        LazyColumn(modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, bottom = 30.dp,),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            items(products) {

                ProductItem(
                    name = it.name,
                    company = it.company,
                    location = it.location,
                    duration = it.time,
                    responsibilities = it.responsibilities,
                    skills = it.skills,
                    doc = it.docs,
                    deadline = it.deadline,
                    id = it.id,
                    navController = navController,
                    productRepository = productRepository
                )
            }
        }

    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductItem(
    name: String,
    company: String,
    location: String,
    duration: String,
    responsibilities: String,
    skills: String,
    doc: String,
    deadline: String,
    id: String,
    navController: NavHostController,
    productRepository: productviewmodel
) {
    Spacer(modifier = Modifier.height(3.dp))
    var isCardExpanded by remember { mutableStateOf(false) }
    ElevatedCard(
        onClick = { },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 25.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.Magenta,
        )
    ) {

        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = name, fontSize = 22.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 10.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = company,
            fontSize = 16.sp,
            fontWeight = FontWeight(400),
            modifier = Modifier.padding(start = 10.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = location,
            fontSize = 15.sp,
            fontWeight = FontWeight(300),
            modifier = Modifier.padding(start = 10.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = duration,
            fontSize = 15.sp,
            fontWeight = FontWeight(200),
            modifier = Modifier.padding(start = 10.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        AnimatedVisibility(visible = isCardExpanded) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Text(buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.DarkGray,
                            fontSize = 13.sp
                        )
                    ) {
                        append("Description: ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color.DarkGray,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(
                            responsibilities
                        )
                    }

                })
                Spacer(modifier = Modifier.height(20.dp))
                Text(buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.DarkGray,
                            fontSize = 13.sp
                        )
                    ) {
                        append("Skills: ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color.DarkGray,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(
                            skills
                        )
                    }

                })
                Spacer(modifier = Modifier.height(20.dp))
                Text(buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.DarkGray,
                            fontSize = 13.sp
                        )
                    ) {
                        append("Needed Documents: ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color.DarkGray,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(
                            doc
                        )
                    }

                })
                Spacer(modifier = Modifier.height(20.dp))
                Text(buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.DarkGray,
                            fontSize = 13.sp
                        )
                    ) {
                        append("Deadline: ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color.DarkGray,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(
                            "12/10/2023"
                        )
                    }

                })
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp)
        ) {
            Icon(
                imageVector = if (isCardExpanded) Icons.Filled.KeyboardArrowUp else
                    Icons.Filled.KeyboardArrowDown,
                contentDescription = "Arrow Down",
                modifier = Modifier
                    .size(25.dp)
                    .clickable {
                        isCardExpanded = !isCardExpanded

                    },
                tint = Color.DarkGray
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp)
        ) {
            OutlinedButton(onClick = { }) { Text(text = "Send CV") }
            Spacer(modifier = Modifier.padding(horizontal = 3.dp))
            OutlinedButton(onClick = {productRepository.deleteProduct(id)}) { Text(text = "delete") }
            Spacer(modifier = Modifier.padding(horizontal = 3.dp))
            OutlinedButton(onClick = { ROUTE_VIEWCOMP }) { Text(text = "update") }
        }
    }
}


@Preview
@Composable
fun View() {
    ViewProductsScreen(rememberNavController())

}