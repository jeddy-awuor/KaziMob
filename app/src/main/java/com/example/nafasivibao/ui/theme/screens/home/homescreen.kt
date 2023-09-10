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
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.nafasivibao.R
import androidx.compose.material3.OutlinedButton as OutlinedButton

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Homescreen(navController: NavHostController) {
    val columnScrollableState = rememberScrollState()

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
            )
        }
        Row(modifier = Modifier
            .background(color = Color.Red)) {
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
        ) {
            ElevatedCard(
                onClick = { /*TODO*/ },
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 30.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Blue,
                ),
                modifier = Modifier
                    .padding(10.dp)
            ) {
                TutorialCardContent()
            }
            ElevatedCard(
                onClick = { /*TODO*/ },
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 25.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Magenta,
                )
            ) {
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "Tutorials", fontSize = 22.sp, fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Github Code",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In efficitur enim ligula, non cursus sem mattis a. Mauris fringilla ipsum leo, non cursus magna imperdiet id. Nam fringilla ultrices magna sit amet facilisis. Pellentesque nibh est, accumsan sit amet justo auctor, tincidunt interdum dolor. Nullam dignissim ex id sem efficitur, eu dapibus massa iaculis. Duis interdum mi eget justo tincidunt, quis pretium lectus accumsan. Curabitur non cursus sapien. Duis dictum, nulla et imperdiet fringilla, est magna egestas massa, ut bibendum magna dolor in sem. Pellentesque sed nisi ullamcorper nunc pellentesque sagittis vitae et magna. Proin eu diam finibus, imperdiet ipsum et, tempor libero.\n" +
                            "\n" +
                            "Donec pellentesque massa sed velit tristique, sit amet imperdiet risus iaculis. Ut vel dui augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; In hac habitasse platea dictumst. Donec eget erat posuere, convallis tortor eu, posuere orci. Cras viverra et libero quis malesuada. Nulla vitae est in tellus aliquet feugiat quis nec diam.\n" +
                            "\n" +
                            "Curabitur metus turpis, pharetra at viverra quis, fermentum eget sapien. Curabitur dignissim in urna ut gravida. Curabitur finibus porta nunc id hendrerit. Pellentesque convallis finibus pretium. Nunc bibendum consequat quam, ac congue nulla egestas vel. Fusce tempor neque purus, iaculis rutrum eros dapibus id. Sed ut iaculis odio. Mauris tempor at ante at euismod. Sed ante augue, aliquam sit amet semper sed, tincidunt vel erat. Sed id feugiat ligula. Nulla facilisi. Morbi sollicitudin, eros eu ultrices iaculis, magna ex posuere tellus, nec aliquam nibh turpis id metus. Duis et semper ipsum. Fusce pulvinar elementum ex. Mauris cursus ipsum vel leo tincidunt accumsan.",
                    softWrap = true,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    OutlinedButton(onClick = { /*TODO*/ }) { Text(text = "Close") }
                    Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                    Button(onClick = { /*TODO*/ }) { Text(text = "Open") }
                }
            }
            ElevatedCard(
                onClick = { /*TODO*/ },
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 30.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Blue,
                ),
                modifier = Modifier
                    .padding(10.dp)
            ) {
                TutorialCardContent()
            }
            ElevatedCard(
                onClick = { /*TODO*/ },
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 30.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Blue,
                ),
                modifier = Modifier
                    .padding(10.dp)
            ) {
                TutorialCardContent()
            }

        }

    }
}



@Composable
fun TutorialCardContent() {
Column(modifier = Modifier
    .padding(10.dp),
    verticalArrangement = spacedBy(10.dp),
    ) {
    Text(text = "Tutorials", fontSize = 22.sp, fontWeight = FontWeight.Bold)
    Text(text = "Github Code", fontSize = 16.sp, fontWeight = FontWeight.Light)
    Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In efficitur enim ligula, non cursus sem mattis a. Mauris fringilla ipsum leo, non cursus magna imperdiet id. Nam fringilla ultrices magna sit amet facilisis. Pellentesque nibh est, accumsan sit amet justo auctor, tincidunt interdum dolor. Nullam dignissim ex id sem efficitur, eu dapibus massa iaculis. Duis interdum mi eget justo tincidunt, quis pretium lectus accumsan. Curabitur non cursus sapien. Duis dictum, nulla et imperdiet fringilla, est magna egestas massa, ut bibendum magna dolor in sem. Pellentesque sed nisi ullamcorper nunc pellentesque sagittis vitae et magna. Proin eu diam finibus, imperdiet ipsum et, tempor libero.\n" +
            "\n" +
            "Donec pellentesque massa sed velit tristique, sit amet imperdiet risus iaculis. Ut vel dui augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; In hac habitasse platea dictumst. Donec eget erat posuere, convallis tortor eu, posuere orci. Cras viverra et libero quis malesuada. Nulla vitae est in tellus aliquet feugiat quis nec diam.\n" +
            "\n" +
            "Curabitur metus turpis, pharetra at viverra quis, fermentum eget sapien. Curabitur dignissim in urna ut gravida. Curabitur finibus porta nunc id hendrerit. Pellentesque convallis finibus pretium. Nunc bibendum consequat quam, ac congue nulla egestas vel. Fusce tempor neque purus, iaculis rutrum eros dapibus id. Sed ut iaculis odio. Mauris tempor at ante at euismod. Sed ante augue, aliquam sit amet semper sed, tincidunt vel erat. Sed id feugiat ligula. Nulla facilisi. Morbi sollicitudin, eros eu ultrices iaculis, magna ex posuere tellus, nec aliquam nibh turpis id metus. Duis et semper ipsum. Fusce pulvinar elementum ex. Mauris cursus ipsum vel leo tincidunt accumsan.", fontSize = 16.sp)
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