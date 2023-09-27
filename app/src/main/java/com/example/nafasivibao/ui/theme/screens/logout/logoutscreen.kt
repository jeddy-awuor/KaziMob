package com.example.nafasivibao.ui.theme.screens.logout

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PermIdentity
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.nafasivibao.BottomNavigationItem
import com.example.nafasivibao.R
import com.example.nafasivibao.data.AuthViewModel
import com.example.nafasivibao.navigation.ROUTE_ABOUT
import com.example.nafasivibao.navigation.ROUTE_HOME
import com.example.nafasivibao.navigation.ROUTE_LOGOUT
import com.example.nafasivibao.navigation.ROUTE_PROFILE
import com.example.nafasivibao.navigation.ROUTE_VIEWADDED
import com.example.nafasivibao.ui.theme.MooliFont
import com.example.nafasivibao.ui.theme.screens.home.Homescreen

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LogoutScreen(navController: NavHostController) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.waving))
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
                .fillMaxSize()
                .background(color = Color(251, 243, 235)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
        ) {
            val context = LocalContext.current
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Leaving?",
                fontFamily = MooliFont ,
                modifier = Modifier.padding(top = 20.dp),
                fontWeight = FontWeight(300),
                color = Color.Black,
                fontSize = 30.sp,
            )
            LottieAnimation(
                composition = composition,
                iterations = Int.MAX_VALUE,
                modifier = Modifier.size(350.dp)
                    .padding(top = 20.dp),
                speed = 2f,

                )
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "It's way too soon..",
                fontFamily = MooliFont ,
                fontWeight = FontWeight(200),
                color = Color.Black,
                fontSize = 25.sp,
            )

            Spacer(modifier = Modifier.height(45.dp))
            Row(
                modifier = Modifier
                    .padding(start = 1.dp)
            ) {
                OutlinedButton(onClick = {
                    val mylogout = AuthViewModel(navController, context)
                    mylogout.logout()
                },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = Color(239, 100, 85)
                    ),) {
                    Icon(
                        imageVector = Icons.Default.ExitToApp,
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier.size(20.dp)
                            .offset(x = -5.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Confirm Logout",
                        color = Color.DarkGray
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun LotPrev(){
    LogoutScreen(rememberNavController())
}