package com.example.nafasivibao.ui.theme.screens.product

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.nafasivibao.BottomNavigationItem
import com.example.nafasivibao.data.productviewmodel
import com.example.nafasivibao.models.Product
import com.example.nafasivibao.navigation.ROUTE_ABOUT
import com.example.nafasivibao.navigation.ROUTE_HOME
import com.example.nafasivibao.navigation.ROUTE_LOGOUT
import com.example.nafasivibao.navigation.ROUTE_VIEWADDED
import com.example.nafasivibao.ui.theme.MooliFont
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UpdateScreen(navController: NavHostController, id:String) {
    var context = LocalContext.current
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
                .fillMaxSize()
                .verticalScroll(columnScrollableState)
                .background(color = Color(251, 243, 235)),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Update Opening",
                style = TextStyle(letterSpacing = 2.sp),
                fontFamily = MooliFont,
                fontWeight = FontWeight(200),
                color = Color(68, 69, 74),
                fontSize = 28.sp,

            )
            var Name by remember { mutableStateOf("") }
            var Company by remember { mutableStateOf("") }
            var Time by remember { mutableStateOf("") }
            var Responsibilities by remember { mutableStateOf("") }
            var Skills by remember { mutableStateOf("") }
            var Docus by remember { mutableStateOf("") }
            var Deadliine by remember { mutableStateOf("") }
            var Location by remember { mutableStateOf("") }
            var currentDataRef = FirebaseDatabase.getInstance().getReference()
                .child("Products/$id")
            currentDataRef.addValueEventListener(object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    var product = snapshot.getValue(Product::class.java)
                   Name = product!!.name
                    Company = product!!.company
                    Time = product!!.time
                    Responsibilities= product!!.responsibilities
                   Skills= product!!.skills
                    Docus= product!!.docs
                   Deadliine = product!!.deadline
                  Location = product!!.location
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
                }
            })
            var productName by remember { mutableStateOf(TextFieldValue(Name)) }
            var productCompany by remember { mutableStateOf(TextFieldValue(Company)) }
            var productTime by remember { mutableStateOf(TextFieldValue(Time)) }
            var productResponsibilities by remember { mutableStateOf(TextFieldValue(Responsibilities)) }
            var productSkills by remember { mutableStateOf(TextFieldValue(Skills)) }
            var productDocus by remember { mutableStateOf(TextFieldValue(Docus)) }
            var productDeadliine by remember { mutableStateOf(TextFieldValue(Deadliine)) }
            var productLocation by remember { mutableStateOf(TextFieldValue(Location)) }
            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = productName,
                onValueChange = { productName = it },
                label = {
                    Text(
                        text = "Job Title *",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight(100),
                        color = Color.Black,
                        fontSize = 20.sp,
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedBorderColor = Color(255, 159, 65),
                    unfocusedBorderColor = Color.Black,
                ),
                shape = RoundedCornerShape(25.dp),
            )

            Spacer(modifier = Modifier.height(25.dp))

            OutlinedTextField(
                value = productCompany,
                onValueChange = { productCompany = it },
                label = {
                    Text(
                        text = "Company *",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight(100),
                        color = Color.Black,
                        fontSize = 20.sp,
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedBorderColor = Color(255, 159, 65),
                    unfocusedBorderColor = Color.Black,
                ),
                shape = RoundedCornerShape(25.dp),
            )

            Spacer(modifier = Modifier.height(25.dp))

            OutlinedTextField(
                value = productLocation,
                onValueChange = { productLocation = it },
                label = {
                    Text(
                        text = "Location *",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight(100),
                        color = Color.Black,
                        fontSize = 20.sp,
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedBorderColor = Color(255, 159, 65),
                    unfocusedBorderColor = Color.Black,
                ),
                shape = RoundedCornerShape(25.dp),
            )
            Spacer(modifier = Modifier.height(25.dp))
            OutlinedTextField(
                value = productTime,
                onValueChange = { productTime = it },
                label = {
                    Text(
                        text = "Duration *",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight(100),
                        color = Color.Black,
                        fontSize = 20.sp,
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedBorderColor = Color(255, 159, 65),
                    unfocusedBorderColor = Color.Black,
                ),
                shape = RoundedCornerShape(25.dp),
            )
            Spacer(modifier = Modifier.height(25.dp))
            OutlinedTextField(
                value = productResponsibilities,
                onValueChange = { productResponsibilities = it },
                label = {
                    Text(
                        text = "Responsibilities *",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight(100),
                        color = Color.Black,
                        fontSize = 20.sp,
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedBorderColor = Color(255, 159, 65),
                    unfocusedBorderColor = Color.Black,
                ),
                shape = RoundedCornerShape(25.dp),
            )
            Spacer(modifier = Modifier.height(25.dp))
            OutlinedTextField(
                value = productSkills,
                onValueChange = { productSkills = it },
                label = {
                    Text(
                        text = "Skills required *",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight(100),
                        color = Color.Black,
                        fontSize = 20.sp,
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedBorderColor = Color(255, 159, 65),
                    unfocusedBorderColor = Color.Black,
                ),
                shape = RoundedCornerShape(25.dp),
            )
            Spacer(modifier = Modifier.height(25.dp))
            OutlinedTextField(
                value = productDocus,
                onValueChange = { productDocus = it },
                label = {
                    Text(
                        text = "Needed Documents *",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight(100),
                        color = Color.Black,
                        fontSize = 20.sp,
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedBorderColor = Color(255, 159, 65),
                    unfocusedBorderColor = Color.Black,
                ),
                shape = RoundedCornerShape(25.dp),
            )
            Spacer(modifier = Modifier.height(25.dp))
            OutlinedTextField(
                value = productDeadliine,
                onValueChange = { productDeadliine = it },
                label = {
                    Text(
                        text = "Application Deadline *",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight(100),
                        color = Color.Black,
                        fontSize = 20.sp,
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedBorderColor = Color(255, 159, 65),
                    unfocusedBorderColor = Color.Black,
                ),
                shape = RoundedCornerShape(25.dp),
            )
            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    //-----------WRITE THE UPDATE LOGIC HERE---------------//
                    var productRepository = productviewmodel(navController, context)
                    productRepository.updateProduct(
                        productName.text.trim(),
                        productCompany.text.trim(),
                        productLocation.text.trim(),
                        productTime.text.trim(),
                        productResponsibilities.text.trim(),
                        productSkills.text.trim(),
                        productDocus.text.trim(),
                        productDeadliine.text.trim(),id
                    )
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Black,
                    containerColor = Color(239, 100, 85)
                ),
                modifier = Modifier.padding(bottom = 90.dp)
            ){
                Text(
                    text = "Update",
                    style = TextStyle(letterSpacing = 2.sp),
                    fontFamily = MooliFont,
                    fontWeight = FontWeight(300),
                    color = Color(68, 69, 74),
                    fontSize = 20.sp,
                )
            }

        }

    }
}