package za.ac.cput.mp2.assignment02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import za.ac.cput.mp2.assignment02.ui.theme.MPIIAssignment02Practical01Theme
import za.ac.cput.mp2.assignment02.ui.theme.pastelBlue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MPIIAssignment02Practical01Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    //color = pastelBlue
                ) {
                    //WelcomeScreen(rememberNavController())
                        Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NavHost(navController = navController,
            startDestination = "Welcome Screen",
            builder ={
                composable("Welcome Screen", content = { WelcomeScreen(navController = navController)})
                composable("About Screen", content = { AboutMeScreen(navController = navController)})
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MPIIAssignment02Practical01Theme {
        //WelcomeScreen()
    }
}