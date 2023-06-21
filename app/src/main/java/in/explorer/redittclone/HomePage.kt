@file:OptIn(ExperimentalMaterial3Api::class)

package `in`.explorer.redittclone

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import `in`.explorer.redittclone.homeBottomNavi.BottomNavItem
import `in`.explorer.redittclone.homeBottomNavi.ChatScreenFun
import `in`.explorer.redittclone.homeBottomNavi.CreatePostScreenFun
import `in`.explorer.redittclone.homeBottomNavi.DiscoverScreenFun
import `in`.explorer.redittclone.homeBottomNavi.HomeScreenFun
import `in`.explorer.redittclone.homeBottomNavi.InboxScreenFun
import `in`.explorer.redittclone.ui.theme.Gray20
import `in`.explorer.redittclone.ui.theme.RedittCloneTheme

class HomePage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RedittCloneTheme {
                MainScreenView()
            }
        }
    }
}

@Preview(device = Devices.PIXEL_4, uiMode = Configuration.UI_MODE_TYPE_NORMAL)
@Composable
fun HomePagePreview() {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Gray20)
    ) {

    }
}

@Composable
fun MainScreenView() {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Discover,
        BottomNavItem.Create,
        BottomNavItem.Chat,
        BottomNavItem.Inbox
    )
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = colorResource(id = R.color.white),
                contentColor = Color.Black
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                items.forEach { item ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                painterResource(id = item.icon),
                                contentDescription = item.title
                            )
                        },
                        label = {
                            Text(
                                text = item.title,
                                fontSize = 9.sp
                            )
                        },
                        selectedContentColor = Color.Black,
                        unselectedContentColor = Color.Black.copy(0.4f),
                        alwaysShowLabel = true,
                        selected = currentRoute == item.screen_route,
                        onClick = {
                            navController.navigate(item.screen_route) {

                                navController.graph.startDestinationRoute?.let { screen_route ->
                                    popUpTo(screen_route) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavigationGraph(navController = navController, innerPadding)
    }
}

@Composable
fun NavigationGraph(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController,
        startDestination = BottomNavItem.Home.screen_route,
        Modifier.padding(paddingValues)
    ) {
        composable(BottomNavItem.Home.screen_route) {
            HomeScreen()
        }
        composable(BottomNavItem.Discover.screen_route) {
            DiscoverScreen()
        }
        composable(BottomNavItem.Create.screen_route) {
            CreatePostScreen()
        }
        composable(BottomNavItem.Chat.screen_route) {
            ChatScreen()
        }
        composable(BottomNavItem.Inbox.screen_route) {
            InboxScreen()
        }
    }
}

@Composable
fun HomeScreen() {
    HomeScreenFun()
}

@Composable
fun DiscoverScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white))
            .wrapContentSize(Alignment.Center)
    ) {
        DiscoverScreenFun()
    }
}

@Composable
fun CreatePostScreen() {
    CreatePostScreenFun()
}


@Composable
fun ChatScreen() {
    ChatScreenFun()
}


@Composable
fun InboxScreen() {
    InboxScreenFun()
}