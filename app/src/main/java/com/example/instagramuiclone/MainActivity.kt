package com.example.instagramuiclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.instagramuiclone.model.BottomNavItem
import com.example.instagramuiclone.screens.Add
import com.example.instagramuiclone.screens.LoginScreen
import com.example.instagramuiclone.screens.Notifications
import com.example.instagramuiclone.screens.SearchScreen
import com.example.instagramuiclone.ui.theme.InstagramUICloneTheme

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramUICloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar(
                                items = listOf(
                                    BottomNavItem(
                                        route = "home",
                                        icon = painterResource(id = R.drawable.home)
                                    ),
                                    BottomNavItem(
                                        route = "search",
                                        icon = painterResource(id = R.drawable.ic_baseline_search_24),
                                    ),
                                    BottomNavItem(
                                        route = "add",
                                        icon = painterResource(id = R.drawable.add),
                                    ),
                                    BottomNavItem(
                                        route = "notifications",
                                        icon = painterResource(id = R.drawable.like),
                                    ),
                                    BottomNavItem(
                                        route = "profile",
                                        icon = painterResource(id = R.drawable.ic_baseline_perm_identity_24),
                                    ),
                                ),
                                navController = navController,
                                onItemClick = {
                                    navController.navigate(it.route)
                                }
                            )
                        }
                    ) {
                        Navigation(navController = navController)
                    }
                }
            }
        }
    }


    @ExperimentalFoundationApi
    @Composable
    fun Navigation(navController: NavHostController) {

        NavHost(navController = navController, startDestination = "login") {
            composable("login") {
                LoginScreen(navController = navController)
            }
            composable("home") {
                HomeScreen(navController = navController)
            }
            composable("search") {
                SearchScreen()
            }
            composable("add") {
                Add()
            }
            composable("notifications") {
                Notifications()
            }
            composable("profile") {
                ProfileScreen()
            }
            composable("messages") {
                Messages()
            }
        }
    }

    @Composable
    fun BottomNavigationBar(
        items: List<BottomNavItem>,
        navController: NavController,
        modifier: Modifier = Modifier,
        onItemClick: (BottomNavItem) -> Unit
    ) {
        val backStackEntry = navController.currentBackStackEntryAsState()
        BottomNavigation(
            modifier = modifier.wrapContentHeight(),
            backgroundColor = MaterialTheme.colors.background,
            elevation = 5.dp
        ) {
            items.forEach { item ->
                val selected = item.route == backStackEntry.value?.destination?.route
                BottomNavigationItem(
                    selected = selected,
                    onClick = { onItemClick(item) },
                    selectedContentColor = Color.Black,
                    unselectedContentColor = Color.Gray,
                    icon = {
                        Icon(painter = item.icon, contentDescription = item.route)
                    }
                )
            }
        }
    }
}