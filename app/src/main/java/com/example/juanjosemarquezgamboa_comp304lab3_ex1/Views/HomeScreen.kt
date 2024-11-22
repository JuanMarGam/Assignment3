package com.example.juanjosemarquezgamboa_comp304lab3_ex1.Views

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.ui.theme.WeatherAppTheme
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.viewModel.citiesViewModel

@Composable
fun HomeScreen(navController: NavController, vm: citiesViewModel) {
    WeatherAppTheme {
        Scaffold(
            topBar = { TopBar(vm,navController) },
        ) { innerPadding ->
            var list = vm.cities
            ListOfCities(
                list = list,
                modifier = Modifier.padding(innerPadding),vm,navController
            )
        }

    }
}