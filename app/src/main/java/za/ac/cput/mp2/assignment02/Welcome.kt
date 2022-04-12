package za.ac.cput.mp2.assignment02


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import za.ac.cput.mp2.assignment02.ui.theme.*


@Composable
fun Welcome(){
    Column(
        Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WelcomeText()
        Spacer(modifier = Modifier.height(40.dp))
        ButtonInfo()
    }

}

@Composable
private fun WelcomeText() {
    Text(
        text = "Welcome to My Jetpack Compose Journey",
        modifier = Modifier.padding(10.dp),
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp,
        color = blueVariant,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun ButtonInfo() {
    var showDialog by remember { mutableStateOf(false) }

    Button(
        onClick = { showDialog = true },
        shape = RoundedCornerShape(50),
        modifier = Modifier
            .fillMaxWidth(0.47f),
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
                            coolBlue,
                            lightBlue
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
                    imageVector = Icons.Filled.Info,
                    contentDescription = "Info button icon",
                    colorFilter = ColorFilter.tint(white)
                )
                Text(
                    text = "View Info",
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
fun AlertMessage(state: Boolean, onDismissRequest: (state: Boolean) -> Unit) {

    val context = LocalContext.current

    if (state) {    //if state is true, display the alert dialog
        AlertDialog(
            onDismissRequest = { onDismissRequest(state) },
            title = {
                Text(
                    text = "Welcome",
                    color = blueVariant,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            },
            text = {
                Text(
                    text = stringResource(
                        id = R.string.welcomeJetpack
                    ),
                    color = blueVariant,
                    fontSize = 17.sp,
                    lineHeight = 30.sp
                )
            },
            backgroundColor = pastelBlue,

            confirmButton = {
                Button(
                    onClick = {
                        onDismissRequest(state)
                        Toast.makeText(context, "Click confirmed", Toast.LENGTH_SHORT).show()
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = coolBlue
                    )
                ) {
                    Text(text = "Confirm", color = white)
                }
            }
        )
    }
}

@Preview
@Composable
fun Preview(){
    WelcomeText()
}