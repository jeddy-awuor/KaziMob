package com.example.nafasivibao.ui.theme.screens.contactcompany

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.widget.RatingBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PermIdentity
import androidx.compose.material.icons.outlined.RemoveRedEye
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType.Companion.Uri
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.solver.state.Dimension
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.nafasivibao.BottomNavigationItem
import com.example.nafasivibao.R
import com.example.nafasivibao.navigation.ROUTE_ABOUT
import com.example.nafasivibao.navigation.ROUTE_HOME
import com.example.nafasivibao.navigation.ROUTE_PROFILE
import com.example.nafasivibao.navigation.ROUTE_SPLASH
import com.example.nafasivibao.navigation.ROUTE_VIEWADDED
import com.example.nafasivibao.ui.theme.screens.login.LoginScreen
import com.example.nafasivibao.ui.theme.screens.rating.RatingBarWithSnackbar
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ContactCompanyScreen(navController: NavHostController) {
    val context = LocalContext.current
    val columnScrollableState = rememberScrollState()
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
        }) {
        Column(
            modifier = Modifier
                .background(color = Color.Red)
                .fillMaxSize()
                .verticalScroll(columnScrollableState),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxSize(),
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                ElevatedCard(
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Magenta,
                    ),
                            modifier = Modifier
                            .padding(bottom = 70.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.marketing),
                            contentDescription = "people",
                            modifier = Modifier
                                .size(100.dp)
                                .padding(start = 20.dp),
                        )

                        Spacer(modifier = Modifier.width(5.dp))
                        Column(modifier = Modifier.padding(start = 15.dp, top = 30.dp)) {
                            Text(
                                buildAnnotatedString {
                                    withStyle(
                                        style = SpanStyle(
                                            color = Color.Black,
                                            fontSize = 25.sp,
                                            fontWeight = FontWeight.ExtraBold
                                        )
                                    ) {
                                        append("MarketXcel")
                                    }
                                })
                        }
                    }

                    Column(
                        modifier = Modifier
                            .width(340.dp)
                            .padding(start = 10.dp)
                    ) {
                        Text(
                            buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.Black,
                                        fontSize = 17.sp,
                                        fontWeight = FontWeight(400)
                                    )
                                ) {
                                    append("About us:  ")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.Black,
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight(500)
                                    )
                                ) {
                                    append("MarketXcel ")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.DarkGray,
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight(300)
                                    )
                                ) {
                                    append("is a dynamic and innovative organization that specializes in delivering cutting-edge marketing solutions to businesses of all sizes. With a passion for creativity and a commitment to excellence, we help our clients achieve their marketing goals and stand out in competitive markets. Our remote-friendly work environment fosters collaboration, innovation, and work-life balance, making MarketXcel Solutions an exciting place to work and grow your career in marketing. Join us and be part of a team that thrives on innovation and is dedicated to making a real impact in the world of marketing.")
                                }
                            },
                            // Prevent text from wrapping to a new line
                        )
                    }
                    //  Spacer(modifier = Modifier.width(2.dp))
//       Column(modifier = Modifier
//            .fillMaxWidth()
//            .padding(20.dp)) {
//           Row(  modifier = Modifier
//               .fillMaxWidth()
//               .padding(10.dp)){
//               Text(text = "Rate this app:",
//                   modifier = Modifier
//               )
//           }
//            Spacer(modifier = Modifier.height(2.dp))
//           RatingBarWithSnackbar(
//               rating = rating,
//               onRatingChanged = { newRating ->
//                   rating = newRating
//               }
//           )
//        }
                    Spacer(modifier = Modifier.height(10.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                        ) {
                            Text(
                                text = "Contact Us ",
                                color = Color.Black
                            )
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 13.dp, bottom = 30.dp)
                        ) {

                            IconButton(
                                onClick = {
                                    val emailIntent =
                                        Intent(Intent.ACTION_SENDTO, android.net.Uri.fromParts("mailto", "abc@gmail.com", null))

                                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")

                                    emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")

                                    context.startActivity(Intent.createChooser(emailIntent, "Send email..."))
                                },
                                modifier = Modifier
                                    .offset(x = 10.dp)
                                    .size(20.dp) // Adjust the size as needed
                                    .border(0.dp, Color.Black, CircleShape)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Mail,
                                    contentDescription = null,
                                    tint = Color.Black
                                )
                            }
                            Spacer(modifier = Modifier.width(40.dp))
                            MyInstaButton()
                            Spacer(modifier = Modifier.width(40.dp))
                            MyDialButton()

                        }

                    }
                }


            }

        }
    }
}

@Composable
fun MyInstaButton() {
    val context = LocalContext.current
    val intent = remember { Intent(Intent.ACTION_VIEW, android.net.Uri.parse("https://www.instagram.com/")) }

    IconButton(
        onClick = {
            context.startActivity(intent)
        },
        modifier = Modifier
            .offset(x = 10.dp)
            .size(20.dp) // Adjust the size as needed
            .border(0.dp, Color.Black, CircleShape)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.logoinst),
            contentDescription = null,
            tint = Color.Black

        )
    }
}
@Composable
fun MyDialButton() {
    val context = LocalContext.current

    IconButton(
        onClick = {
            val phone = "+254710388411"
            val intent = Intent(Intent.ACTION_DIAL, android.net.Uri.fromParts("tel", phone, null))
            context.startActivity(intent)
        },
        modifier = Modifier
            .offset(x = 10.dp)
            .size(20.dp) // Adjust the size as needed
            .border(0.dp, Color.Black, CircleShape)
    ) {
        Icon(
            imageVector = Icons.Default.Call,
            contentDescription = null,
            tint = Color.Black

        )
    }
}
@Preview
@Composable
fun AboutCompPrev(){
    ContactCompanyScreen(rememberNavController())
}