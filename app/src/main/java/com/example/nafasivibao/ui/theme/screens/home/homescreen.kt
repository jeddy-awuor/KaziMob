package com.example.nafasivibao.ui.theme.screens.home



import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard

import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text

import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.nafasivibao.R
import com.example.nafasivibao.navigation.ROUTE_ABOUT
import com.example.nafasivibao.navigation.ROUTE_LOGIN
import com.example.nafasivibao.navigation.ROUTE_SPLASH
import androidx.compose.material3.OutlinedButton as OutlinedButton


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
    var expanded by remember { mutableStateOf(true) }



    Column(
        modifier = Modifier
            .background(color = Color.Red)
            .fillMaxSize()
    ) {
        var text by remember { mutableStateOf("") }
        var active by remember { mutableStateOf(false) }
        var items = remember {
            mutableListOf(
                "Full Stack",
                "Android Developer"
            ) }
        Row(
            modifier = Modifier
                .background(color = Color.Red)
        ) {
            SearchBar(
                query = text,
                modifier = Modifier
                    .background(color = Color.Red),
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


        Spacer(modifier = Modifier.height(5.dp))
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize()
                .verticalScroll(columnScrollableState),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
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
                                isCardExpanded3 = false
                                isCardExpanded4 = false
                                isCardExpanded5 = false
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
                                isCardExpanded3 = false
                                isCardExpanded4= false
                                isCardExpanded5 = false
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
                AnimatedVisibility( visible = isCardExpanded3) {
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
                        imageVector = if (isCardExpanded3) Icons.Filled.KeyboardArrowUp else
                            Icons.Filled.KeyboardArrowDown,
                        contentDescription = "Arrow Down",
                        modifier = Modifier
                            .size(25.dp)
                            .clickable {
                                isCardExpanded3 = !isCardExpanded3
                                isCardExpanded1 = false
                                isCardExpanded2 = false
                                isCardExpanded4 = false
                                isCardExpanded5 = false
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
                AnimatedVisibility( visible = isCardExpanded4) {
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
                        imageVector = if (isCardExpanded4) Icons.Filled.KeyboardArrowUp else
                            Icons.Filled.KeyboardArrowDown,
                        contentDescription = "Arrow Down",
                        modifier = Modifier
                            .size(25.dp)
                            .clickable {
                                isCardExpanded4 = !isCardExpanded4
                                isCardExpanded1 = false
                                isCardExpanded2 = false
                                isCardExpanded3 = false
                                isCardExpanded5 = false
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
                AnimatedVisibility( visible = isCardExpanded5) {
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
                        imageVector = if (isCardExpanded5) Icons.Filled.KeyboardArrowUp else
                            Icons.Filled.KeyboardArrowDown,
                        contentDescription = "Arrow Down",
                        modifier = Modifier
                            .size(25.dp)
                            .clickable {
                                isCardExpanded5 = !isCardExpanded5
                                isCardExpanded1 = false
                                isCardExpanded2 = false
                                isCardExpanded3 = false
                                isCardExpanded4 = false
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

}




@Preview
@Composable
fun HomPrev(){
    Homescreen(rememberNavController())
}