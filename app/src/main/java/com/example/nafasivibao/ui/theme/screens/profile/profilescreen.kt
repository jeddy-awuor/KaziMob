package com.example.nafasivibao.ui.theme.screens.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PermIdentity
import androidx.compose.material.icons.outlined.RemoveRedEye
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.nafasivibao.BottomNavigationItem
import com.example.nafasivibao.R
import com.example.nafasivibao.navigation.ROUTE_ABOUT
import com.example.nafasivibao.navigation.ROUTE_HOME
import com.example.nafasivibao.navigation.ROUTE_PROFILE
import com.example.nafasivibao.navigation.ROUTE_VIEWADDED
import com.example.nafasivibao.navigation.ROUTE_VIEWPOSTED

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(navController: NavHostController) {
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
            selectedIcon = Icons.Filled.RemoveRedEye,
            unselectedIcon = Icons.Outlined.RemoveRedEye,
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
        }){
    Column(
        modifier = Modifier
            .padding(bottom = 40.dp)
           .fillMaxSize()
            .background(color = Color(243, 253, 232)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(23.dp))
        Text(
            text = "Welcome to Your Profile!",
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight(300),
            color = Color.Black,
            fontSize = 30.sp,
        )
        Spacer(modifier = Modifier.height(30.dp))
        Box(
            modifier = Modifier
                .size(220.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.anonymous),
                contentDescription = "sitting",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = CircleShape)
                    .background(Color.White, shape = CircleShape)
                    .border(
                        2.dp,
                        Color.Black,
                        CircleShape
                    )
            )

            IconButton(
                onClick = {
                    navController.navigate(ROUTE_HOME)
                },
                modifier = Modifier
                    .padding(1.dp)
                    .align(TopEnd)
                    .size(48.dp) // Adjust the size as needed
                    .offset(x = 23.dp)
                    .offset(y = 2.dp)
                    .border(2.dp, Color.Black, CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color(158, 210, 190)
            ),
        ) {
            Text(
                text = "Upload your CV",
                style = TextStyle(letterSpacing = 1.sp),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(200),
                fontSize = 28.sp,
            )
        }
        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color(158, 210, 190)
            ),
        ) {
            Text(
                text = "Delete your CV",
                style = TextStyle(letterSpacing = 1.sp),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(200),
                fontSize = 28.sp,
            )
        }
        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = { ROUTE_VIEWPOSTED },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color(158, 210, 190)
            ),
        ) {
            Text(
                text = "View Posted",
                style = TextStyle(letterSpacing = 1.sp),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(200),
                fontSize = 28.sp,
            )
        }
        Spacer(modifier = Modifier.height(33.dp))

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color(158, 210, 190)
            ),
        ) {
            Text(
                text = "Logout",
                style = TextStyle(letterSpacing = 1.sp),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(200),
                fontSize = 28.sp,
            )
        }


    }
}
}
@Preview
@Composable
fun ProfPrev() {
   ProfileScreen(rememberNavController())

}