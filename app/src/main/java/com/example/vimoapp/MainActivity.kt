package com.example.vimoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.vimoapp.ui.theme.VimoappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VimoappTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier=Modifier.padding(innerPadding)) {
                        var name by remember { mutableStateOf("Android") }

                        Greeting(
                            name = "Android",
                            modifier = Modifier.padding(innerPadding)
                        )
                        myButton(onClick = {
                            name = if (name == "Android") "world" else "Android"
                        })
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@Composable
fun  myButton(onClick:() -> Unit){
    Button(onClick=onClick) {
        Text(text = "!Click Me!")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VimoappTheme {
        Column {
            var name by remember { mutableStateOf("Android") }
            Greeting("Android")
            myButton(onClick =  {
                name = if (name == "Android") "world" else "Android"
            })
        }
    }
}