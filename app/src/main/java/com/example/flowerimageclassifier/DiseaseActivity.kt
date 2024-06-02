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
import com.example.flowerimageclassifier.DetailDisease
import com.example.flowerimageclassifier.MainDisease
import com.example.flowerimageclassifier.DiseaseData
import com.example.flowerimageclassifier.ui.theme.FlowerImageClassifierTheme
// class that handles the disease details page and the main page
class DiseaseActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlowerImageClassifierTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val imageId = disease_image

                    val names = disease_names
                    val description = disease_description
                    val treatment = disease_treatment

                    // navigation controller that handles the selection of diseases
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "MainDisease") {
                        composable(route = "MainDisease") {
                            MainDisease(imageId, names, navController)
                        }
                        composable(route = "DetailDisease/{index}",
                            arguments = listOf(
                                navArgument(name = "index") {
                                    type = NavType.IntType
                                }
                            )
                        ) { index->
                            DetailDisease(
                                photos = imageId,
                                names = names,
                                description = description,
                                treatment = treatment,
                                itemIndex = index.arguments?.getInt("index")
                            )
                        }
                    }

                }
            }
        }
    }
}