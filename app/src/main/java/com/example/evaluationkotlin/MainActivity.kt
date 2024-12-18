package com.example.evaluationkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.evaluationkotlin.ui.theme.EvaluationKotlinTheme
import com.example.evaluationkotlin.ui.screens.mainscreen.MainScreen
import com.example.evaluationkotlin.ui.screens.detailsscreen.DetailsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EvaluationKotlinTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "mainscreen") {
                    composable("mainscreen") {
                        MainScreen(navController)
                    }
                    composable("detailsscreen/{detailId}") { backStackEntry ->
                        val detailId = backStackEntry.arguments?.getString("detailId")
                        DetailsScreen(detailId?.toIntOrNull() ?: 0, navController)
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EvaluationKotlinTheme {
        Greeting("Android")
    }
}