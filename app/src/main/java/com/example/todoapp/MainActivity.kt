package com.example.todoapp

import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.RememberObserver
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.ui.theme.TodoAppTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFF6EEE9)
                ) {

                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = "splash_screen"  ){
        composable("splash_screen"){

            SplashScreen(navController = navController)
        }
        composable("main_screen"){

            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {

    Box(modifier = Modifier.fillMaxSize().background(Color(0xfffdf5f0)),
        contentAlignment = Alignment.Center
    ){
        Text(text = "Main Screen", modifier = Modifier.padding(40.dp),Color.DarkGray)
    }
}

@Composable
fun SplashScreen(navController: NavController){

    LaunchedEffect(key1 = true){
//        Delay for 3 seconds before navigating t the main screen
        delay(3000L)
        navController.navigate("main_screen")
    }
    Box (

        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()

                ){
        Image(painter = painterResource(id = R.drawable.ic_logo)
            , contentDescription = "Logo",
            modifier = Modifier.size(400.dp).align(Alignment.Center)

        )

    }
}
