package com.example.juanjosemarquezgamboa_comp304lab3_ex1.Views

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.ui.theme.WeatherAppTheme
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.viewModel.stocksViewModel

@Composable
fun HomeScreen(navController: NavController, vm: stocksViewModel) {
    WeatherAppTheme {
        Scaffold(

        ) { innerPadding ->
            var list = vm.getDBStocks()
            ListOfDBStocks(
                list = list,
                modifier = Modifier.padding(innerPadding),vm
            )
        }

    }
}