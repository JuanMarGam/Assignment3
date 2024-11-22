package com.example.juanjosemarquezgamboa_comp304lab3_ex1.Views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.viewModel.citiesViewModel

@Composable
fun FavoriteActivityScreen(navController: NavController, vm: citiesViewModel) {
    ListOfDBCities(
        list = vm.getDBCities(),
        modifier = Modifier.fillMaxSize(),
        vm = vm,
        onCityClick = { city ->
            navController.navigate("weather/${city.cityName}")
        }
    )
}