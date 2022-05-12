package za.ac.cput.mp2.assignment02.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import za.ac.cput.mp2.assignment02.navigation.Screen
import za.ac.cput.mp2.assignment02.ui.theme.coolBlue
import za.ac.cput.mp2.assignment02.ui.theme.white

@Composable
fun ModuleScreen(navController: NavController) {
    val scaffoldState: ScaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopAppBarModuleScreen(navController) }
    ){
        Column(
            Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

            ){

        }

    }
}

@Composable
fun TopAppBarModuleScreen(navController: NavController) {
    TopAppBar(
        navigationIcon = {
            IconButton(
                content = {
                    Icon(
                        Icons.Default.ArrowBack,
                        tint = Color.White,
                        contentDescription = "Module Screen"
                    )
                },
                onClick = {
                    navController.navigate(Screen.AboutScreen.route){
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                }
            )
        },
        title = { Text(text = "Modules", color = white) },
        backgroundColor = coolBlue
    )
}