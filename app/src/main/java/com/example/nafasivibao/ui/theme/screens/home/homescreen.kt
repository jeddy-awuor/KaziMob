package com.example.nafasivibao.ui.theme.screens.home



import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PermIdentity
import androidx.compose.material.icons.outlined.RemoveRedEye
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.nafasivibao.BottomNavigationItem
import com.example.nafasivibao.navigation.ROUTE_ABOUT
import com.example.nafasivibao.navigation.ROUTE_BOTTOMNAVY
import com.example.nafasivibao.navigation.ROUTE_HOME
import com.example.nafasivibao.navigation.ROUTE_PROFILE
import com.example.nafasivibao.navigation.ROUTE_SPLASH
import com.example.nafasivibao.navigation.ROUTE_VIEWADDED
import com.example.nafasivibao.navigation.ROUTE_VIEWCOMP


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
                .padding(start = 20.dp, end = 20.dp, bottom = 30.dp,)
                .fillMaxSize()
                .verticalScroll(columnScrollableState),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(3.dp))
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
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Github",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                AnimatedVisibility(visible = isCardExpanded1) {
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
                                    "Bachelor's degree in Computer Science, Software Engineering, or a related field (or equivalent experience).\n" +
                                            "Proven experience as a Full Stack Developer or similar role.\n" +
                                            "Proficiency in front-end technologies such as HTML, CSS, JavaScript, and modern JavaScript frameworks (e.g., React, Angular, or Vue.js).\n" +
                                            "Strong back-end development skills, including server-side languages like Node.js, Python, Ruby, or Java.\n" +
                                            "Experience with relational and NoSQL databases (e.g., MySQL, PostgreSQL, MongoDB).\n" +
                                            "Knowledge of RESTful APIs and web services.\n" +
                                            "Familiarity with cloud platforms and containerization (e.g., AWS, Azure, Docker, Kubernetes).\n" +
                                            "Version control using Git and familiarity with Git workflows.\n" +
                                            "Excellent problem-solving and communication skills.\n" +
                                            "Strong teamwork and collaboration abilities.\n" +
                                            "Self-motivated and eager to learn new technologies."
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
                    OutlinedButton(onClick = {  }) { Text(text = "Send CV") }
                    Spacer(modifier = Modifier.width(10.dp))
                    OutlinedButton(onClick = { }) { Text(text = "Add") }
                }
            }
            Spacer(modifier = Modifier.height(1.dp))
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
                    text = "Finance and Budget Assistant", fontSize = 22.sp, fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Seafarer's Catch",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Atlantis, Atlantis Cove",
                    fontSize = 15.sp,

                    fontWeight = FontWeight(300),
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Full-time",
                    fontSize = 15.sp,
                    fontWeight = FontWeight(200),
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.height(7.dp))
                AnimatedVisibility(visible = isCardExpanded2) {
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
                                    "Provide exceptional customer service, answering questions and offering assistance.\n" +
                                    "Accurately process cash and card transactions for seafood purchases.\n" +
                                            "Maintain a clean and organized cashier station, including stocking supplies.\n" +
                                            "Ensure accurate pricing and inventory management for seafood products.\n" +
                                            "Handle customer inquiries and resolve any payment-related issues.\n" +
                                            "Collaborate with team members to create a positive shopping experience for customers."
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
                                    "Proficiency in using basic computer systems and point-of-sale (POS) software for processing transactions and maintaining sales records.\n" +
                                            " Ability to handle customer complaints or conflicts calmly and effectively, aiming to find solutions that satisfy both the customer and the business.\n" +
                                            "Ability to handle cash transactions accurately, make change, and operate a cash register.\n" +
                                            "Precision and attention to detail to ensure accurate pricing, receipt issuance, and inventory management."
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
                                    " CV / RESUME: This document should include your contact information, educational background, work experience, relevant skills, and any certifications or qualifications that are pertinent to the job.\n" +
                                            "Identification and Work Authorization: Proof of your identity, such as a copy of your ID or passport, and authorization to work in the country.\n"+
                                            "References and any other relevant document."
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
                                    "12/12/2023"
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
                        imageVector = if (isCardExpanded2) Icons.Filled.KeyboardArrowUp else
                            Icons.Filled.KeyboardArrowDown,
                        contentDescription = "Arrow Down",
                        modifier = Modifier
                            .size(25.dp)
                            .clickable {
                                isCardExpanded2 = !isCardExpanded2
                                isCardExpanded1 = false
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
                        .padding(start = 10.dp,bottom = 10.dp)
                ) {
                    OutlinedButton(onClick = {  }) { Text(text = "Send CV") }
                    Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                    OutlinedButton(onClick = { ROUTE_VIEWADDED}) { Text(text = "Add") }
                    Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                    OutlinedButton(onClick = { ROUTE_VIEWCOMP }) { Text(text = "Company") }
                }
            }
            Spacer(modifier = Modifier.height(1.dp))
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
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Github",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                AnimatedVisibility(visible = isCardExpanded3) {
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
                                    "Bachelor's degree in Computer Science, Software Engineering, or a related field (or equivalent experience).\n" +
                                            "Proven experience as a Full Stack Developer or similar role.\n" +
                                            "Proficiency in front-end technologies such as HTML, CSS, JavaScript, and modern JavaScript frameworks (e.g., React, Angular, or Vue.js).\n" +
                                            "Strong back-end development skills, including server-side languages like Node.js, Python, Ruby, or Java.\n" +
                                            "Experience with relational and NoSQL databases (e.g., MySQL, PostgreSQL, MongoDB).\n" +
                                            "Knowledge of RESTful APIs and web services.\n" +
                                            "Familiarity with cloud platforms and containerization (e.g., AWS, Azure, Docker, Kubernetes).\n" +
                                            "Version control using Git and familiarity with Git workflows.\n" +
                                            "Excellent problem-solving and communication skills.\n" +
                                            "Strong teamwork and collaboration abilities.\n" +
                                            "Self-motivated and eager to learn new technologies."
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
            Spacer(modifier = Modifier.height(1.dp))
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
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Github",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                AnimatedVisibility(visible = isCardExpanded4) {
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
                                    "Bachelor's degree in Computer Science, Software Engineering, or a related field (or equivalent experience).\n" +
                                            "Proven experience as a Full Stack Developer or similar role.\n" +
                                            "Proficiency in front-end technologies such as HTML, CSS, JavaScript, and modern JavaScript frameworks (e.g., React, Angular, or Vue.js).\n" +
                                            "Strong back-end development skills, including server-side languages like Node.js, Python, Ruby, or Java.\n" +
                                            "Experience with relational and NoSQL databases (e.g., MySQL, PostgreSQL, MongoDB).\n" +
                                            "Knowledge of RESTful APIs and web services.\n" +
                                            "Familiarity with cloud platforms and containerization (e.g., AWS, Azure, Docker, Kubernetes).\n" +
                                            "Version control using Git and familiarity with Git workflows.\n" +
                                            "Excellent problem-solving and communication skills.\n" +
                                            "Strong teamwork and collaboration abilities.\n" +
                                            "Self-motivated and eager to learn new technologies."
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
                    Button(onClick = { navController.navigate(ROUTE_BOTTOMNAVY) }) { Text(text = "NAVBAR") }
                }
            }
            Spacer(modifier = Modifier.height(1.dp))
            ElevatedCard(
                onClick = { },
                modifier = Modifier
                    .padding(bottom = 70.dp),
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
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Github",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                AnimatedVisibility(visible = isCardExpanded5) {
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
                                    "Bachelor's degree in Computer Science, Software Engineering, or a related field (or equivalent experience).\n" +
                                            "Proven experience as a Full Stack Developer or similar role.\n" +
                                            "Proficiency in front-end technologies such as HTML, CSS, JavaScript, and modern JavaScript frameworks (e.g., React, Angular, or Vue.js).\n" +
                                            "Strong back-end development skills, including server-side languages like Node.js, Python, Ruby, or Java.\n" +
                                            "Experience with relational and NoSQL databases (e.g., MySQL, PostgreSQL, MongoDB).\n" +
                                            "Knowledge of RESTful APIs and web services.\n" +
                                            "Familiarity with cloud platforms and containerization (e.g., AWS, Azure, Docker, Kubernetes).\n" +
                                            "Version control using Git and familiarity with Git workflows.\n" +
                                            "Excellent problem-solving and communication skills.\n" +
                                            "Strong teamwork and collaboration abilities.\n" +
                                            "Self-motivated and eager to learn new technologies."
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
                    OutlinedButton(onClick = { navController.navigate(ROUTE_VIEWCOMP) })
                    { Text(text = "Company") }
                    Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                    Button(onClick = { navController.navigate(ROUTE_VIEWADDED) })
                    { Text(text = "Add") }
                }
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