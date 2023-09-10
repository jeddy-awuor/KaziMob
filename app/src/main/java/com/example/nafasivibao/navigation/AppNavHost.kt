package com.example.nafasivibao.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvm.ui.theme.screens.about.AboutScreen
import com.example.nafasivibao.ui.theme.screens.home.Homescreen
import com.example.nafasivibao.ui.theme.screens.login.LoginScreen
import com.example.nafasivibao.ui.theme.screens.profile.ProfileScreen
import com.example.nafasivibao.ui.theme.screens.register.RegisterScreen
import com.example.nafasivibao.ui.theme.screens.splashscreen.SplashScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavHost(modifier: Modifier= Modifier, navController:NavHostController= rememberNavController(), startDestination:String= ROUTE_LOGIN){
    NavHost(navController =navController,modifier=modifier, startDestination = startDestination ){
        composable(ROUTE_HOME){
            Homescreen(navController)
        }
        composable(ROUTE_LOGIN){
            LoginScreen(navController)
        }
        composable(ROUTE_REGISTER){
            RegisterScreen(navController)
        }
        composable(ROUTE_PIC){
           ProfileScreen(navController)
        }
        composable(ROUTE_SPLASH){
            SplashScreen(navController)
        }
        composable(ROUTE_ABOUT){
            AboutScreen(navController)
        }

    }

}