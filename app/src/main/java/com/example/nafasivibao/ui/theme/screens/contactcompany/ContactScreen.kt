package com.example.nafasivibao.ui.theme.screens.contactcompany

import android.widget.RatingBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedButton
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
import androidx.constraintlayout.solver.state.Dimension
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.nafasivibao.R
import com.example.nafasivibao.navigation.ROUTE_HOME
import com.example.nafasivibao.navigation.ROUTE_SPLASH
import com.example.nafasivibao.ui.theme.screens.login.LoginScreen
import com.example.nafasivibao.ui.theme.screens.rating.RatingBarWithSnackbar

@Composable
fun ContactCompanyScreen(navController: NavHostController) {
    val columnScrollableState = rememberScrollState()
    var rating by remember { mutableStateOf(3) }

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
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.fishing),
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
                                    append("Seafarer Catch")
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
                                append("Seafarer's Catch ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = Color.DarkGray,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight(300)
                                )
                            ) {
                                append("is your premier destination for all things fishing. We specialize in providing top-quality fishing gear, guided excursions, and sustainable seafood products. With a passion for the open waters, we're dedicated to helping you make the most of your angling adventures.")
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
                            text = "Reviews: ",
                            color = Color.Black
                        )


                    }

                }
            }


        }

    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)

    ) {
        Button(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(bottom = 15.dp),
            onClick = {}
        ) {
            Text("Add Review")
        }
        Button(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 15.dp),
            onClick = { navController.navigate(ROUTE_HOME) }
        ) {
            Text("Go Back")
        }
    }
}
@Preview
@Composable
fun AboutCompPrev(){
    ContactCompanyScreen(rememberNavController())
}