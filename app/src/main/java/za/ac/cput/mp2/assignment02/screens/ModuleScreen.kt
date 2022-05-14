package za.ac.cput.mp2.assignment02.screens

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import za.ac.cput.mp2.assignment02.R
import za.ac.cput.mp2.assignment02.navigation.Screen
import za.ac.cput.mp2.assignment02.ui.theme.*

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
            TextDetails()
            ExitButton()
        }

    }
}

@Composable
private fun TopAppBarModuleScreen(navController: NavController) {
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

@Composable
private fun ExitButton() {
    var showDialog by remember { mutableStateOf(false) }

    Button(
        onClick = { showDialog = true },
        shape = RoundedCornerShape(50),
        modifier = Modifier
            .fillMaxWidth(0.4f),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        ),
        contentPadding = PaddingValues() //removes padding between button and box
    ) {
        Box(
            modifier = Modifier
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            Color(146, 1, 1, 255),
                            Color(131, 3, 3, 255)
                        )
                    )
                )
                .padding(16.dp, 8.dp)
                .clip(shape = RoundedCornerShape(12.dp))
                .fillMaxWidth(1f),
            contentAlignment = Alignment.Center,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Info button icon",
                    colorFilter = ColorFilter.tint(white)
                )
                Text(
                    text = "Goodbye",
                    modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp),
                    color = white,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500
                )
            }
        }
        AlertMessage(state = showDialog, onDismissRequest = { showDialog = !it })
    }
}

@Composable
private fun AlertMessage(state: Boolean, onDismissRequest: (state: Boolean) -> Unit) {

    val context = LocalContext.current //Display the toast message
    val activity = (LocalContext.current as Activity) //allows to exit the application: line 164

    if (state) {    //if state is true, display the alert dialog
        AlertDialog(
            onDismissRequest = { onDismissRequest(state) },
            title = {
                Text(
                    text = "Warning!!!",
                    color = blueVariant,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            },
            text = {
                Text(
                    text = "Are you sure you want to leave now?",
                    color = blueVariant,
                    fontSize = 17.sp,
                    lineHeight = 30.sp
                )
            },
            backgroundColor = pastelBlue,
            confirmButton = {
                Button(
                    onClick = {
                        activity.finish()
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(136, 5, 5, 255)
                    )
                ) {
                    Text(text = "Confirm", color = white)
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        onDismissRequest(state)
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = coolBlue
                    )
                ) {
                    Text(text = "Cancel", color = white)
                }
            }
        )
    }
}

@Composable
private fun TextDetails() {
    Column(
        Modifier
            .fillMaxWidth()
            .height(400.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(20.dp, 0.dp, 20.dp, 0.dp)
                .background(coolBlue)
                .height(40.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround

        ) {
            Text(
                text = "Module Name",
                color = white,
                fontSize = 17.sp,
                lineHeight = 30.sp
            )
            Text(text = "Type",
                color = white,
                fontSize = 17.sp,
                lineHeight = 30.sp
            )
            Text(text = "Duration",
                color = white,
                fontSize = 17.sp,
                lineHeight = 30.sp
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(20.dp, 0.dp, 20.dp, 0.dp)
                .height(40.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround

        ) {
            Text(
                text = "Application Development",
                color = blueVariant,
                fontSize = 13.sp,
                lineHeight = 30.sp
            )
            Text(text = "Practical",
                color = blueVariant,
                fontSize = 13.sp,
                lineHeight = 30.sp
            )
            Text(text = "Year-round",
                color = blueVariant,
                fontSize = 13.sp,
                lineHeight = 30.sp
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(20.dp, 0.dp, 20.dp, 0.dp)
                .height(40.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround

        ) {
            Text(
                text = "Application Theory",
                color = blueVariant,
                fontSize = 13.sp,
                lineHeight = 30.sp
            )
            Text(text = "Thoery/Practical",
                color = blueVariant,
                fontSize = 13.sp,
                lineHeight = 30.sp
            )
            Text(text = "Year-round",
                color = blueVariant,
                fontSize = 13.sp,
                lineHeight = 30.sp
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(20.dp, 0.dp, 20.dp, 0.dp)
                .height(40.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround

        ) {
            Text(
                text = "Information System",
                color = blueVariant,
                fontSize = 13.sp,
                lineHeight = 30.sp
            )
            Text(text = "Theory/Practical",
                color = blueVariant,
                fontSize = 13.sp,
                lineHeight = 30.sp
            )
            Text(text = "Year-round",
                color = blueVariant,
                fontSize = 13.sp,
                lineHeight = 30.sp
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(20.dp, 0.dp, 20.dp, 0.dp)
                .height(40.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround

        ) {
            Text(
                text = "Professional Practice",
                color = blueVariant,
                fontSize = 13.sp,
                lineHeight = 30.sp
            )
            Text(text = "Theory",
                color = blueVariant,
                fontSize = 13.sp,
                lineHeight = 30.sp
            )
            Text(text = "Year-round",
                color = blueVariant,
                fontSize = 13.sp,
                lineHeight = 30.sp
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(20.dp, 0.dp, 20.dp, 0.dp)
                .height(40.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround

        ) {
            Text(
                text = "ICT Electives Mobile Dev",
                color = blueVariant,
                fontSize = 13.sp,
                lineHeight = 30.sp
            )
            Text(text = "Practical",
                color = blueVariant,
                fontSize = 13.sp,
                lineHeight = 30.sp
            )
            Text(text = "Year-round",
                color = blueVariant,
                fontSize = 13.sp,
                lineHeight = 30.sp
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(20.dp, 0.dp, 20.dp, 0.dp)
                .height(40.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround

        ) {
            Text(
                text = "Project 3",
                color = blueVariant,
                fontSize = 13.sp,
                lineHeight = 30.sp
            )
            Text(text = "Practical",
                color = blueVariant,
                fontSize = 13.sp,
                lineHeight = 30.sp
            )
            Text(text = "Year-round",
                color = blueVariant,
                fontSize = 13.sp,
                lineHeight = 30.sp
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(20.dp, 0.dp, 20.dp, 0.dp)
                .height(40.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround

        ) {
            Text(
                text = "Project Management",
                color = blueVariant,
                fontSize = 13.sp,
                lineHeight = 30.sp
            )
            Text(text = "Theory/Practical",
                color = blueVariant,
                fontSize = 13.sp,
                lineHeight = 30.sp
            )
            Text(text = "Year-round",
                color = blueVariant,
                fontSize = 13.sp,
                lineHeight = 30.sp
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(20.dp, 0.dp, 20.dp, 0.dp)
                .height(40.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround

        ) {
            Text(
                text = "Project Presentation",
                color = blueVariant,
                fontSize = 13.sp,
                lineHeight = 30.sp
            )
            Text(text = "Practical",
                color = blueVariant,
                fontSize = 13.sp,
                lineHeight = 30.sp
            )
            Text(text = "Year-round",
                color = blueVariant,
                fontSize = 13.sp,
                lineHeight = 30.sp
            )
        }
    }
}

@Preview
@Composable
fun Module() {
    ModuleScreen(rememberNavController())
}