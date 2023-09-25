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
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PermIdentity
import androidx.compose.material.icons.outlined.RemoveRedEye
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
                    text = "Pastry Chef", fontSize = 22.sp, fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Sweet Delights Bakery",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Sweetville, Confectionery Kingdom",
                    fontSize = 15.sp,

                    fontWeight = FontWeight(300),
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Part-time",
                    fontSize = 15.sp,
                    fontWeight = FontWeight(200),
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
                                    "Prepare and bake a variety of bread, pastries, and cakes following established recipes.\n" +
                                            "Decorate and present baked goods in an appealing manner.\n" +
                                            "Ensure the quality and freshness of all products.\n" +
                                            "Maintain a clean and organized workspace.\n" +
                                            "Collaborate with the team to develop new recipes and products.\n" +
                                            "Provide exceptional customer service and assist with customer inquiries."
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
                                    "Proven experience as a Baker or Pastry Chef.\n" +
                                            "Strong knowledge of baking techniques and equipment.\n" +
                                            "Creativity and attention to detail in decorating baked goods.\n" +
                                            "Ability to work in a fast-paced environment.\n" +
                                            "Excellent teamwork and communication skills.\n" +
                                            "Food safety and hygiene certification is a plus."
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
                                            "Food Safety and Hygiene Certification(within the last 2 years).\n"+
                                            "Identification and Work Authorization: Proof of your identity, such as a copy of your ID or passport, and authorization to work in the country.\n"+
                                            "Portfolio of your baked goods (photos or samples, if available).\n"+
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
                        .padding(start = 10.dp, bottom = 10.dp)
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
                    text = "Full Stack Software Developer Intern", fontSize = 22.sp, fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "InnovateTech Solutions",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Techville, Innovation Hub",
                    fontSize = 15.sp,
                    fontWeight = FontWeight(300),
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Full-time; 5 months ",
                    fontSize = 15.sp,
                    fontWeight = FontWeight(200),
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
                                    "Collaborate with our development team to design, develop, test, and deploy web applications.\n" +
                                            "Work on both front-end and back-end development tasks.\n" +
                                            "Participate in the entire software development lifecycle, from planning and architecture to deployment and maintenance.\n" +
                                            "Assist in the creation and maintenance of technical documentation.\n" +
                                    "Debug and resolve software defects and issues."

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
                                    "Pursuing or recently completed a degree in Computer Science, Software Engineering, or a related field.\n" +
                                            "Knowledge of programming languages such as JavaScript, Python, or Java.\n" +
                                            "Familiarity with web development frameworks (e.g., React, Angular, Node.js, Django).\n" +
                                            "Understanding of databases and SQL.\n" +
                                            "Strong problem-solving and analytical skills.\n" +
                                            "Excellent communication and teamwork abilities.\n" +
                                            "Eagerness to learn and adapt to new technologies."
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
                                            "Academic Transcripts: Minimum grade of 60% in each academic year (or equivalent grading system), and the applicant must be either a student in their final academic year or an individual who has completed their university degree within the last year.\n"+
                                            "GitHub Repository: A link to your GitHub repository or profile showcasing relevant software development projects.\n"+
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
                    text = "Marketing Manager", fontSize = 22.sp, fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "MarketXcel Solutions",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Remote",
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
                                append("Responsibilities: ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = Color.DarkGray,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(
                                   "Develop and execute comprehensive marketing strategies to drive brand awareness and lead generation.\n" +
                                           "Manage and lead a team of marketing professionals to achieve marketing goals.\n" +
                                           "Oversee digital marketing campaigns, including SEO, SEM, email marketing, and social media.\n" +
                                           "Analyze market trends and competitor activities to identify opportunities and threats.\n" +
                                           "Collaborate with cross-functional teams to align marketing efforts with business objectives.\n" +
                                           "Track and report on marketing performance metrics and ROI"
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
                                    "Bachelor's degree in Marketing, Business, or a related field (MBA is a plus).\n" +
                                            "Proven experience in marketing management roles.\n" +
                                            "Strong understanding of digital marketing channels and analytics tools.\n" +
                                            "Exceptional leadership and team management skills.\n" +
                                            "Excellent written and verbal communication skills.\n" +
                                            "Self-driven and able to work independently in a remote work environment.\n" +
                                            "Creativity and strategic thinking."
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
                                            "Portfolio or examples of successful marketing campaigns.\n"+
                                            "Cover letter. Please ensure that your cover letter is included in your application email..\n"+
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
                                    "12/9/2023"
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
                    OutlinedButton(onClick = {  }) { Text(text = "Send CV") }
                    Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                    OutlinedButton(onClick = {}) { Text(text = "Add") }
                    Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                    OutlinedButton(onClick = {navController.navigate(ROUTE_VIEWCOMP)}) { Text(text = "Company") }
                }
            }
            Spacer(modifier = Modifier.height(1.dp))
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
            ) {
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "Fish Supplier", fontSize = 22.sp, fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "OceanFresh Distributors",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = " Coastal Harbor Bay, Seafishia",
                    fontSize = 15.sp,
                    fontWeight = FontWeight(300),
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
                                    "Source and purchase a variety of fish species from trusted suppliers and fisheries.\n" +
                                            "Inspect and evaluate the quality and freshness of fish products.\n" +
                                            "Negotiate pricing and contracts with suppliers to ensure competitive pricing and favorable terms.\n" +
                                            "Manage inventory levels and ensure adequate stock of fish products.\n" +
                                            "Coordinate with the logistics team for timely delivery to our distribution centers.\n" +
                                            "Monitor market trends and seafood industry news to stay informed about the latest developments.\n" +
                                            "Maintain accurate records of purchases, prices, and supplier information."
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
                                   "Proven experience as a Fish Supplier or similar role in the seafood industry.\n" +
                                           "Strong knowledge of fish species, quality standards, and industry regulations.\n" +
                                           "Excellent negotiation and communication skills.\n" +
                                           "Ability to assess and maintain the freshness and quality of fish products.\n" +
                                           "Organizational and inventory management skills.\n" +
                                           "Attention to detail and a commitment to food safety and hygiene.\n" +
                                           "Willingness to work in a fast-paced and dynamic environment."
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
                                            "Food safety and hygiene certification within the last 1 year.\n"+
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
                    OutlinedButton(onClick = {  }) { Text(text = "Send CV") }
                    Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                    OutlinedButton(onClick = { ROUTE_VIEWADDED}) { Text(text = "Add") }
                    Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                    OutlinedButton(onClick = { ROUTE_VIEWCOMP }) { Text(text = "Company") }
                }
            }
            Spacer(modifier = Modifier.height(1.dp))
      //add added products//
            Spacer(modifier = Modifier.height(1.dp))
            IconButton(
                onClick = {
                    navController.navigate(ROUTE_HOME)
                },
                modifier = Modifier
                    .padding(bottom = 70.dp)
                    .size(48.dp)
                    .offset(x = 145.dp)
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
@Preview
@Composable
fun HomPrev(){
    Homescreen(rememberNavController())
}