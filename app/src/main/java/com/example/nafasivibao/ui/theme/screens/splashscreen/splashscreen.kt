package com.example.nafasivibao.ui.theme.screens.splashscreen


import android.os.Bundle
import android.os.Parcelable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ElevatedCard
import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.nafasivibao.navigation.ROUTE_SPLASH
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.nafasivibao.navigation.AppNavHost
import com.example.nafasivibao.ui.theme.NafasiVibaoTheme
data class Content(
    val id:Int,
    val title:String,
    val subtitle:String,
    val desc:String
)
const val LOREM ="Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."


@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun SplashScreen(navController: NavHostController) {
    var isCardExpanded1 by remember { mutableStateOf(false) }
    var isCardExpanded2 by remember { mutableStateOf(false) }
    val columnScrollableState = rememberScrollState()
    var expandedCardIndex by remember { mutableStateOf(-1) }

    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
            .verticalScroll(columnScrollableState),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

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
                    text = "Title", fontSize = 22.sp, fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Github",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                AnimatedVisibility( visible = isCardExpanded1) {
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
                                append("Bachelor's degree in Computer Science, Software Engineering, or a related field (or equivalent experience).\n" +
                                        "Proven experience as a Full Stack Developer or similar role.\n" +
                                        "Proficiency in front-end technologies such as HTML, CSS, JavaScript, and modern JavaScript frameworks (e.g., React, Angular, or Vue.js).\n" +
                                        "Strong back-end development skills, including server-side languages like Node.js, Python, Ruby, or Java.\n" +
                                        "Experience with relational and NoSQL databases (e.g., MySQL, PostgreSQL, MongoDB).\n" +
                                        "Knowledge of RESTful APIs and web services.\n" +
                                        "Familiarity with cloud platforms and containerization (e.g., AWS, Azure, Docker, Kubernetes).\n" +
                                        "Version control using Git and familiarity with Git workflows.\n" +
                                        "Excellent problem-solving and communication skills.\n" +
                                        "Strong teamwork and collaboration abilities.\n" +
                                        "Self-motivated and eager to learn new technologies.")
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
                        imageVector = if (isCardExpanded1) Icons.Filled.KeyboardArrowUp else
                            Icons.Filled.KeyboardArrowDown,
                        contentDescription = "Arrow Down",
                        modifier = Modifier
                            .size(25.dp)
                            .clickable {
                                isCardExpanded1 = !isCardExpanded1
                                isCardExpanded2 = false
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
                    OutlinedButton(onClick = { navController.navigate(ROUTE_SPLASH) }) { Text(text = "Close") }
                    Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                    Button(onClick = { /*TODO*/ }) { Text(text = "Open") }
                }
            }
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
                text = "Title", fontSize = 22.sp, fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 10.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Github",
                fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(start = 10.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            AnimatedVisibility( visible = isCardExpanded2) {
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
                            append("Bachelor's degree in Computer Science, Software Engineering, or a related field (or equivalent experience).\n" +
                                    "Proven experience as a Full Stack Developer or similar role.\n" +
                                    "Proficiency in front-end technologies such as HTML, CSS, JavaScript, and modern JavaScript frameworks (e.g., React, Angular, or Vue.js).\n" +
                                    "Strong back-end development skills, including server-side languages like Node.js, Python, Ruby, or Java.\n" +
                                    "Experience with relational and NoSQL databases (e.g., MySQL, PostgreSQL, MongoDB).\n" +
                                    "Knowledge of RESTful APIs and web services.\n" +
                                    "Familiarity with cloud platforms and containerization (e.g., AWS, Azure, Docker, Kubernetes).\n" +
                                    "Version control using Git and familiarity with Git workflows.\n" +
                                    "Excellent problem-solving and communication skills.\n" +
                                    "Strong teamwork and collaboration abilities.\n" +
                                    "Self-motivated and eager to learn new technologies.")
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
                    imageVector = if (isCardExpanded2) Icons.Filled.KeyboardArrowUp else
                        Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Arrow Down",
                    modifier = Modifier
                        .size(25.dp)
                        .clickable {
                            isCardExpanded2 = !isCardExpanded2
                            isCardExpanded1 = false
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
                OutlinedButton(onClick = { navController.navigate(ROUTE_SPLASH) }) { Text(text = "Close") }
                Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                Button(onClick = { /*TODO*/ }) { Text(text = "Open") }
            }
        }
        }


    }
