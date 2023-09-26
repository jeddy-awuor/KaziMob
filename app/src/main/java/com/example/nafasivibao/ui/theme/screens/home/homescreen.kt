@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.nafasivibao.ui.theme.screens.home



import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PermIdentity
import androidx.compose.material.icons.outlined.RemoveRedEye
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
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
import com.example.nafasivibao.BottomNavigationItem
import com.example.nafasivibao.R
import com.example.nafasivibao.data.productviewmodel
import com.example.nafasivibao.models.Product
import com.example.nafasivibao.navigation.ROUTE_ABOUT
import com.example.nafasivibao.navigation.ROUTE_BOTTOMNAVY
import com.example.nafasivibao.navigation.ROUTE_HOME
import com.example.nafasivibao.navigation.ROUTE_PROFILE
import com.example.nafasivibao.navigation.ROUTE_SPLASH
import com.example.nafasivibao.navigation.ROUTE_UPDATE
import com.example.nafasivibao.navigation.ROUTE_VIEWADDED
import com.example.nafasivibao.navigation.ROUTE_VIEWCOMP
import com.example.nafasivibao.ui.theme.screens.product.ProductItem
import androidx.compose.runtime.remember as remember


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun Homescreen(navController: NavHostController) {
    val columnScrollableState = rememberScrollState()
    var isCardExpanded1 by remember { mutableStateOf(false) }
    var isCardExpanded2 by remember { mutableStateOf(false) }
    var isCardExpanded3 by remember { mutableStateOf(false) }
    var isCardExpanded4 by remember { mutableStateOf(false) }
    var isCardExpanded5 by remember { mutableStateOf(false) }
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(-1)
    }


    val items = listOf(
        BottomNavigationItem(
            title = ROUTE_HOME,
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNews = false,
        ),
        BottomNavigationItem(
            title = ROUTE_VIEWADDED,
            selectedIcon = Icons.Filled.Add,
            unselectedIcon = Icons.Outlined.AddCircleOutline,
            hasNews = false,
        ),
        BottomNavigationItem(
            title = ROUTE_PROFILE,
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.PermIdentity,
            hasNews = false,
            badgeCount = 45
        ),
        BottomNavigationItem(
            title = ROUTE_ABOUT,
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
            hasNews = false,
        ),
    )

    Scaffold(
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .height(78.dp)
            ) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index
                            navController.navigate(item.title)
                        },
                        label = {
                            Text(text = item.title)
                        },
                        icon = {
                            BadgedBox(
                                badge = {

                                }
                            ) {
                                Icon(
                                    imageVector = if (index == selectedItemIndex) {
                                        item.selectedIcon
                                    } else item.unselectedIcon,
                                    contentDescription = item.title
                                )
                            }
                        }
                    )
                }
            }
        })
    {
    Column(
        modifier = Modifier
            .background(color = Color(243, 253, 232))
            .fillMaxSize()
    ) {
        var text by remember { mutableStateOf("") }
        var active by remember { mutableStateOf(false) }
        val items = remember {
            mutableListOf(
                "Full Stack",
                "Android Developer"
            )
        }
        Row(
            modifier = Modifier
                .padding(bottom = 5.dp, start = 10.dp, end = 10.dp)
        ) {
            SearchBar(
                query = text,
                onQueryChange = {
                    text = it
                },
                onSearch = {
                    items.add(text)
                    active = false
                },
                active = active,
                onActiveChange = {
                    active = it
                },
                placeholder = { Text(text = "Search") },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "search")
                },
                trailingIcon = {
                    if (active) {
                        Icon(
                            modifier = Modifier.clickable {
                                if (text.isNotEmpty()) {
                                    text = ""
                                } else {
                                    active = false
                                }
                            },
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close icon"
                        )
                    }

                }

            ) {
                items.forEach {
                    Row(modifier = Modifier.padding(all = 5.dp)) {
                        Icon(
                            modifier = Modifier.padding(end = 10.dp),
                            imageVector = Icons.Default.History,
                            contentDescription = "history"
                        )
                        Text(text = it)

                    }
                }

            }
        }

        Column(
            modifier = Modifier
                .padding(bottom=10.dp)
                .fillMaxSize()
                .background(color = Color.Red),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(3.dp))
            var context = LocalContext.current
            var productRepository = productviewmodel(navController, context)
            val emptyProductState = remember { mutableStateOf(Product("", "", "", "", "", "", "", "", "")) }
            var emptyProductsListState = remember { mutableStateListOf<Product>() }
            var products = productRepository.viewProducts(emptyProductState, emptyProductsListState)

            LazyColumn(modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, bottom = 85.dp,),
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
}
}

@Composable
fun ProductCard
            (product: Product,
             navController: NavHostController,
             productRepository: productviewmodel) {
    var isproductcardexpandend by remember { mutableStateOf(false) }
    ElevatedCard(
        onClick = { },
        modifier = Modifier
            .padding(bottom = 10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 25.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.Magenta,
        )
    ){

        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = product.name, fontSize = 22.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 10.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = product.company,
            fontSize = 16.sp,
            fontWeight = FontWeight(400),
            modifier = Modifier.padding(start = 10.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = product.location,
            fontSize = 15.sp,
            fontWeight = FontWeight(300),
            modifier = Modifier.padding(start = 10.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = product.time,
            fontSize = 15.sp,
            fontWeight = FontWeight(300),
            modifier = Modifier.padding(start = 10.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        AnimatedVisibility(visible = isproductcardexpandend) {
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
                        append(product.responsibilities
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
                         product.skills
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
                        product.docs
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
                            product.deadline
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
                imageVector = if (isproductcardexpandend) Icons.Filled.KeyboardArrowUp else
                    Icons.Filled.KeyboardArrowDown,
                contentDescription = "Arrow Down",
                modifier = Modifier
                    .size(25.dp)
                    .clickable {
                        isproductcardexpandend = !isproductcardexpandend
                    },
                tint = Color.DarkGray
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            OutlinedButton(onClick = {productRepository.deleteProduct(product.id)},
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Black,
                    containerColor = Color(158, 210, 190)
                ))
            {  Text(text = "Delete",
                style = TextStyle(letterSpacing = 2.sp),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(200),
                color = Color.Black,
                fontSize = 20.sp,) }
            Spacer(modifier = Modifier.padding(horizontal = 5.dp))
            OutlinedButton(onClick = {  navController.navigate(ROUTE_UPDATE+"/$product.id")},
                colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color(158, 210, 190),
                ))
            { Text(text = "Update") }
            Spacer(modifier = Modifier.padding(horizontal = 5.dp))
            OutlinedButton(onClick = { ROUTE_VIEWCOMP }) { Text(text = "Company") }
        }
    }
    Spacer(modifier = Modifier.height(1.dp))

        Button(onClick = {
            productRepository.deleteProduct(product.id)
        },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color(158, 210, 190)
            )) {
            Text(text = "Delete",
                style = TextStyle(letterSpacing = 2.sp),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(200),
                color = Color.Black,
                fontSize = 20.sp,)
        }
        Spacer(modifier = Modifier.height(7.dp))
        Button(onClick = {
            navController.navigate(ROUTE_UPDATE+"/$product.id")
        },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color(158, 210, 190),

                )) {
            Text(text = "Update",
                style = TextStyle(letterSpacing = 2.sp),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(200),
                color = Color.Black,
                fontSize = 20.sp,)
        }
    }
@Composable
fun TutorialCardContentt() {
    Column(
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "Tutorial")
        Text(text = "Tutorials", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Text(text = "Github Code", fontSize = 16.sp, fontWeight = FontWeight.Light)
        Text(text = "Find the information about the code", fontSize = 16.sp)
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)) {
            OutlinedButton(onClick = { /*TODO*/ }) { Text(text = "Close") }
            Spacer(modifier = Modifier.padding(horizontal = 10.dp))
            Button(onClick = { /*TODO*/ }) { Text(text = "Open") }
        }
    }
}
@Preview
@Composable
fun HomPrev(){
    Homescreen(rememberNavController())
}