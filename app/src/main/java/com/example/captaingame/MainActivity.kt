package com.example.captaingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaptainGameTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Captaingame(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Captaingame(modifier: Modifier){
    val tressurefound= remember{mutableStateOf(0) }
    val stromencountered= remember { mutableStateOf(0) }
    val direction= remember{ mutableStateOf("north") }
    val stromORtressure= remember { mutableStateOf("") }
    val  health= remember { mutableStateOf(100) }
    var decor=TextStyle(fontFamily = FontFamily.Default,
        fontSize = 30.sp,
        color = Color.Blue

    )


    Column (modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {if(health.value>0) {
        Text("CAPTAIN GAME", modifier = Modifier.padding(80.dp), style = decor,fontWeight = FontWeight.Bold)
        Text("")
        Text("Tressure found: ${tressurefound.value}")
        Text("Strom encountered ${stromencountered.value}")
        Text("Current direction: ${direction.value}")
        Text("HP ${health.value}")
        Text(stromORtressure.value)

        Button(onClick = {
            direction.value = "east"
            if (Random.nextBoolean()) {
                tressurefound.value += 1
                health.value += 5
            } else {
                stromencountered.value += 1
                health.value -= 10
            }

        })
        {
            Text("EAST")
        }


        Button(onClick = {
            direction.value = "west"
            if (Random.nextBoolean()) {
                tressurefound.value += 1
//                health.value+=5
            } else {
                stromencountered.value += 1
                health.value -= 10

            }
        })
        {
            Text("WEST")


        }
        Button(onClick = {
            direction.value = "north"
            if (Random.nextBoolean()) {
                tressurefound.value += 1
                health.value += 5
            } else {
                stromencountered.value += 1
                health.value -= 10
            }
        })
        {
            Text("NORTH")
        }

        Button(onClick = {
            direction.value = "south"
            if (Random.nextBoolean()) {
                tressurefound.value += 1
                health.value += 5
            } else {
                stromencountered.value += 1
                health.value -= 10
            }
        })
        {
            Text("SOUTH")
        }
    }
        else{
            health.value=0
            Text("👍 You Have Found ${tressurefound.value} tressures", fontWeight = FontWeight.Bold)
            Text("😑 You Have Encountered ${stromencountered.value} Stroms",fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.padding(10.dp))
            Text("GAME OVER ")
            Button(onClick = {tressurefound.value=0
            stromencountered.value=0
                health.value=100
            })
            { Text("RETRY") }

        }
}
}

@Preview(showBackground = true)
@Composable
fun CheckPrev(){
    Captaingame(Modifier)
}
