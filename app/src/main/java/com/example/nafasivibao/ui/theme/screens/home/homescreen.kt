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
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material.icons.outlined.ExitToApp
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
import com.example.nafasivibao.navigation.ROUTE_LOGOUT
import com.example.nafasivibao.navigation.ROUTE_PROFILE
import com.example.nafasivibao.navigation.ROUTE_SPLASH
import com.example.nafasivibao.navigation.ROUTE_UPDATE
import com.example.nafasivibao.navigation.ROUTE_VIEWADDED
import com.example.nafasivibao.navigation.ROUTE_VIEWCOMP
import com.example.nafasivibao.ui.theme.MooliFont
import com.example.nafasivibao.ui.theme.screens.product.ProductItem
import com.google.firebase.auth.FirebaseAuth
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
            title = ROUTE_ABOUT,
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
            hasNews = false,
        ),
        BottomNavigationItem(
            title = ROUTE_LOGOUT,
            selectedIcon = Icons.Filled.ExitToApp,
            unselectedIcon = Icons.Outlined.ExitToApp,
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
                .padding(bottom=10.dp)
                .fillMaxSize()
                .background(color = Color(251, 243, 235)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(25.dp))
            var context = LocalContext.current
            var productRepository = productviewmodel(navController, context)
            val emptyProductState = remember { mutableStateOf(Product("", "", "", "", "", "", "", "", "")) }
            var emptyProductsListState = remember { mutableStateListOf<Product>() }
            var products = productRepository.viewProducts(emptyProductState, emptyProductsListState)
            val currentUser = FirebaseAuth.getInstance().currentUser
            val userEmail = currentUser?.email
            Row(modifier = Modifier.padding(bottom = 5.dp)){
                Text(text = "Welcome $userEmail",
                    fontSize = 22.sp,
                    color = Color(68, 69, 74),
                    fontFamily =  MooliFont,
                    fontWeight = FontWeight.Bold)
            }
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