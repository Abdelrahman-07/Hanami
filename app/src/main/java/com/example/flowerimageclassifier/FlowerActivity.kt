package com.example.flowerimageclassifier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.flowerimageclassifier.DetailFlower
import com.example.flowerimageclassifier.MainFlower
import com.example.flowerimageclassifier.FlowerData
import com.example.flowerimageclassifier.ui.theme.FlowerImageClassifierTheme
// class that handles the linking between flower details and main flower selection page

class FlowerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlowerImageClassifierTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val imageId = flower_images
                    val toxic = flower_toxicity
                    val link = flower_links
                    val names = flower_names
                    val cultivation = cult_methods

                    // navigation controller to rout to each flower page when the flower card is clicked
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "MainFlower") {
                        composable(route = "MainFlower") {
                            MainFlower(imageId, names, navController)
                        }
                        composable(route = "DetailFlower/{index}",
                            arguments = listOf(
                                navArgument(name = "index") {
                                    type = NavType.IntType
                                }
                            )
                        ) { index->
                            DetailFlower(
                                photos = imageId,
                                names = names,
                                cultivation = cultivation,
                                link = link,
                                toxicity = toxic,
                                itemIndex = index.arguments?.getInt("index")
                            )
                        }
                    }

                }
            }
        }
    }
}
