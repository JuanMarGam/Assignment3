package com.example.juanjosemarquezgamboa_comp304lab3_ex1.Views

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.viewModel.WeatherViewModel

@Composable
fun WeatherActivityScreen(navController: NavController, vm: WeatherViewModel) {
    // Retrieve the city name from NavController arguments
    val backStackEntry = navController.currentBackStackEntry
    val city = backStackEntry?.arguments?.getString("city") ?: ""

    // Trigger weather data fetch if the city is valid
    if (city.isNotEmpty()) {
        vm.getWeather(city) // Ensure this method fetches weather for the provided city
    }

    // Display the WeatherView
    WeatherView(vm)
    }
