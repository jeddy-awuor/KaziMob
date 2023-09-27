package com.example.mvvm.ui.theme.screens.about

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.widget.RatingBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PermIdentity
import androidx.compose.material.icons.outlined.RemoveRedEye
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.nafasivibao.BottomNavigationItem
import com.example.nafasivibao.R
import com.example.nafasivibao.navigation.ROUTE_ABOUT
import com.example.nafasivibao.navigation.ROUTE_HOME
import com.example.nafasivibao.navigation.ROUTE_LOGOUT
import com.example.nafasivibao.navigation.ROUTE_PROFILE
import com.example.nafasivibao.navigation.ROUTE_VIEWADDED
import com.example.nafasivibao.navigation.ROUTE_VIEWCOMP
import com.example.nafasivibao.ui.theme.MooliFont
import com.example.nafasivibao.ui.theme.screens.contactcompany.MyDialButton
import com.example.nafasivibao.ui.theme.screens.contactcompany.MyInstaButton
import com.example.nafasivibao.ui.theme.screens.home.Homescreen
import com.example.nafasivibao.ui.theme.screens.rating.RatingBarWithSnackbar
import com.example.nafasivibao.ui.theme.screens.rating.RatingScreen

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(navController: NavHostController) {
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
        }){
        Column(
            modifier = Modifier
                .padding(bottom = 50.dp)
                .fillMaxSize()
                .background(color = Color(251, 243, 235)),
            horizontalAlignment = Alignment.CenterHorizontally,

        ){
            OutlinedCard(onClick = { /*TODO*/ },
                modifier = Modifier.padding(start =20.dp, bottom = 40.dp, end = 20.dp, top = 20.dp) ,
                colors = cardColors(
                        containerColor = Color(255, 159, 65)),
            )
             {
               TutorialCardContentt()

            }
        }
    }
    }

@Composable

fun TutorialCardContentt() {
    val context: Context = LocalContext.current
    val columnScrollableState= rememberScrollState()
    Column(
        modifier = Modifier
            .padding( 10.dp)
            .verticalScroll(columnScrollableState),
    verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
    horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.teamwork),
            contentDescription = "sitting",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(shape = CircleShape)
                .size(100.dp)
        )
        Text(text = "About our app", fontSize = 22.sp, fontWeight = FontWeight.Bold, fontFamily = MooliFont  ,color = Color(68, 69, 74),)
        Text(text =
                "Nafasi means opportunity or opening  in Swahili while 'Kibao' means plenty or a lot.When combined, \"Nafasi Kibao\" conveys the idea of an abundance of opportunities or job openings. It's a descriptive and engaging term, particularly suitable for this app that aims to connect job seekers with a wide range of available job opportunities, highlighting the wealth of choices and possibilities for users  ",
            fontSize = 16.sp,
            color = Color(68, 69, 74),)
        Text(text = "\"Nafasi Kibao\" is your gateway to a world of limitless opportunities. Our app is your trusted companion on the journey to finding your dream job or discovering exciting career paths.\n" +
                "With Nafasi Kibao, you have access to an extensive and diverse array of job openings that cater to your unique skills, interests, and ambitions. Whether you're a seasoned professional looking to advance your career or a fresh graduate eager to take your first step into the professional world, Nafasi Kibao is here to help.",
            fontSize = 16.sp,
            color = Color(68, 69, 74),)
        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 1.dp)) {
            Button(onClick = {
                val shareIntent = Intent(Intent.ACTION_SEND)

                shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

                shareIntent.type = "text/plain"

                shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")

                context.startActivity(shareIntent)
            },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Black,
                    containerColor = Color(239, 100, 85)
                ),) {
                Icon(
                imageVector = Icons.Default.Mail,
                contentDescription = null,
                tint = Color.Black,
                    modifier = Modifier.size(20.dp)
                        .offset(x = -5.dp)
            )
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "Share the app")
            }
        }

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
                    text = "Get in touch with us :",
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 13.dp, bottom = 30.dp)
            ) {

                IconButton(
                    onClick = {
                        val emailIntent =
                            Intent(Intent.ACTION_SENDTO, android.net.Uri.fromParts("mailto", "jeddy@gmail.com", null))

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
                Spacer(modifier = Modifier.width(50.dp))
                MyInstaButton()
                Spacer(modifier = Modifier.width(50.dp))
                MyDialButton()

            }

        }
       RatingScreen()
    }
}


@Preview
@Composable
fun AbrPr(){
    AboutScreen(rememberNavController())
}