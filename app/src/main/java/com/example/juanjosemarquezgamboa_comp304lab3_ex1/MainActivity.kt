package com.example.juanjosemarquezgamboa_comp304lab3_ex1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.RoomDB.CityDataBase
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.Views.FavoriteActivityScreen
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.Views.HomeScreen
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.Views.TopBar
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.Views.WeatherActivityScreen
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.ui.theme.WeatherAppTheme
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.viewModel.AppRepository
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.viewModel.ViewModelFactory
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.viewModel.WeatherViewModel
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.viewModel.WeatherViewModelFactory
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.viewModel.citiesViewModel

class MainActivity : ComponentActivity() {
    // Access the application context correctly after Activity initialization
    private val repository by lazy {
        val database = CityDataBase.getInstance(applicationContext)
        AppRepository(database.getCityDao())
    }

    // Use the viewModels() property delegate for lifecycle-aware ViewModel
    private val myViewModelCities: citiesViewModel by viewModels {
        ViewModelFactory(repository)  // Pass repository to the factory
    }
    private val myViewModelWeather: WeatherViewModel by viewModels {
        WeatherViewModelFactory(repository)
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WeatherAppTheme {
                val navController = rememberNavController()

                Scaffold { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "home",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("home") {
                            Scaffold(
                                topBar = { TopBar(myViewModelCities,navController) },
                            ) {
                                HomeScreen(navController, myViewModelCities)
                            }
                        }
                        composable("favorites") {
                            FavoriteActivityScreen(navController, myViewModelCities)
                        }
                        composable(
                            route = "weather/{city}",
                            arguments = listOf(navArgument("city") { type = NavType.StringType })
                        ) { backStackEntry ->
                            val city = backStackEntry.arguments?.getString("city") ?: ""
                            WeatherActivityScreen(navController = navController, vm = myViewModelWeather)
                        }
                    }
                }
            }
        }
    }
}