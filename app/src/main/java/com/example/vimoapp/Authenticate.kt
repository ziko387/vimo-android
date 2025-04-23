package com.example.vimoapp

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.remember
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp


class Authenticate : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }

    @Composable
    fun AppNavigation() {
        val navController = rememberNavController()
        //set up a host anavhostall app routes (path)

        NavHost(navController = navController, startDestination = "login") {
            // inside this we then add our composables with the path names
            composable("login") { LoginScreen(navController) }
            composable("signup") { SignupScreen(navController) }
        }
    }

    @Composable
    fun LoginScreen(navController: NavController) {
        val username = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
        val passwordVisible = remember { mutableStateOf(false) }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(R.drawable.tino4),
                        contentDescription = "App logo",
                                modifier = Modifier.size(120.dp),
                        contentScale = ContentScale.Fit
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    // USERNAME TEXT FIELD
                    OutlinedTextField(
                        value = username.value,
                        onValueChange = { username.value = it },
                        label = { Text("username or Email") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        colors = TextFieldDefaults.colors(
                            focusedTextColor = MaterialTheme.colorScheme.onSurface,
                            unfocusedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Gray
                        ),

                    )
                    OutlinedTextField(
                        value = username.value,
                        onValueChange = { username.value = it },
                        label = { Text("password") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        colors = TextFieldDefaults.colors(
                            focusedTextColor = MaterialTheme.colorScheme.onSurface,
                            unfocusedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Gray
                        ),
                        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            IconButton(onClick = {
                                passwordVisible.value=! passwordVisible.value
                            }) {
                                Icon(imageVector = if (passwordVisible.value)
                                    Icons.Filled.ThumbUp else Icons.Filled.AccountBox,
                                    contentDescription = ""

                                )


                                )



                    //spacer
                    Spacer(modifier = Modifier.height(8.dp))
                    //clickable text
                    Text(
                        text = "forgot password",
                        style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.primary),
                        modifier = Modifier
                            .align(Alignment.End)
                            .clickable(onClick = {
                                //handle reset password functionalities
                            })
                    )
                    //spacer
                    Spacer(modifier = Modifier.height(24.dp))
                    //login button
                    Button(
                        onClick = {/*handle login */},
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = Color.White
                        )

                    ) {
                        Text(text = "login", fontSize = 16.sp)
                    }
                    Text(
                        text = "Dont have an account?, login here",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.clickable{
                            navController.navigate("signup")
                        }

                    )



                    }
                })

            }
        }
        @Composable
        fun SignupScreen(navController: NavController) {
            val username= remember{mutableStateOf("")}
            val firstpassword= remember{mutableStateOf("")}
            val confirmpassword= remember{mutableStateOf("")}
            val email= remember{mutableStateOf("")}
            val passwordVisible = remember { mutableStateOf(false) }
       Box(
           modifier = Modifier.fillMaxSize(),
           contentAlignment = Alignment.Center
       ){
           Card (
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(12.dp),
               shape = RoundedCornerShape(25.dp),
               elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)

               ){
              Column(
                  modifier = Modifier.padding(14.dp),
                  horizontalAlignment = Alignment.CenterHorizontally
              ){
                  Image(
                      painter = painterResource(R.drawable.tino9),
                      contentDescription = "signup logo",
                              modifier = Modifier.size(120.dp),
                      contentScale = ContentScale.Fit
                  )
                  Spacer(modifier = Modifier.height(24.dp))
                  OutlinedTextField(
                      value = username.value,
                      onValueChange = { username.value = it },
                      label = { Text("username ") },
                      modifier = Modifier.fillMaxWidth(),
                      singleLine = true,
                      colors = TextFieldDefaults.colors(
                          focusedTextColor = MaterialTheme.colorScheme.onSurface,
                          unfocusedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                          focusedContainerColor = Color.Transparent,
                          unfocusedContainerColor = Color.Gray
                      ),
                      visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
                      trailingIcon = {
                          IconButton(onClick = {
                              passwordVisible.value=! passwordVisible.value
                          }) {
                              Icon(imageVector = if (passwordVisible.value)
                                  Icons.Filled.ThumbUp else Icons.Filled.AccountBox,
                                  contentDescription = ""

                              )


                          }
                      }
                  )
                  OutlinedTextField(
                      value = username.value,
                      onValueChange = { username.value = it },
                      label = { Text("firstpassword ") },
                      modifier = Modifier.fillMaxWidth(),
                      singleLine = true,
                      colors = TextFieldDefaults.colors(
                          focusedTextColor = MaterialTheme.colorScheme.onSurface,
                          unfocusedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                          focusedContainerColor = Color.Transparent,
                          unfocusedContainerColor = Color.Gray
                      ),
                      visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
                      trailingIcon = {
                          IconButton(onClick = {
                              passwordVisible.value=! passwordVisible.value
                          }) {
                              Icon(imageVector = if (passwordVisible.value)
                                  Icons.Filled.ThumbUp else Icons.Filled.AccountBox,
                                  contentDescription = ""

                              )


                          }
                      }
                  )
                  OutlinedTextField(
                      value = username.value,
                      onValueChange = { username.value = it },
                      label = { Text("confirmpassword ") },
                      modifier = Modifier.fillMaxWidth(),
                      singleLine = true,
                      colors = TextFieldDefaults.colors(
                          focusedTextColor = MaterialTheme.colorScheme.onSurface,
                          unfocusedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                          focusedContainerColor = Color.Transparent,
                          unfocusedContainerColor = Color.Gray
                      ),
                      visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
                      trailingIcon = {
                          IconButton(onClick = {
                              passwordVisible.value=! passwordVisible.value
                          }) {
                              Icon(imageVector = if (passwordVisible.value)
                                  Icons.Filled.ThumbUp else Icons.Filled.AccountBox,
                                  contentDescription = ""

                              )


                          }
                      }
                  )
                  OutlinedTextField(
                      value = username.value,
                      onValueChange = { username.value = it },
                      label = { Text("email ") },
                      modifier = Modifier.fillMaxWidth(),
                      singleLine = true,
                      colors = TextFieldDefaults.colors(
                          focusedTextColor = MaterialTheme.colorScheme.onSurface,
                          unfocusedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                          focusedContainerColor = Color.Transparent,
                          unfocusedContainerColor = Color.Gray
                      ),

                  )

              }
           }
       }
        }
    @Composable
    fun ForgotPasswordScreen(navController: NavController){

    }

    @Preview(showBackground = true)
    @Composable
    fun LoginScreenPreview(){
        MaterialTheme {
            Surface(modifier = Modifier.fillMaxSize()){
                LoginScreen(rememberNavController())
            }
        }
    }
            @Preview(showBackground = true)
            @Composable
            fun SignupScreen(){
                MaterialTheme {
                    Surface(modifier = Modifier.fillMaxSize()){
                        SignupScreen(rememberNavController())
                    }
                }
            }
}
