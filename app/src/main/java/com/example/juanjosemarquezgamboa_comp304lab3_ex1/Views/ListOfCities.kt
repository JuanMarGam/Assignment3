package com.example.juanjosemarquezgamboa_comp304lab3_ex1.Views

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.RoomDB.City
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.viewModel.citiesViewModel

@Composable
fun ListOfCities(list: List<String>,
                 modifier: Modifier = Modifier,
                 vm: citiesViewModel,
                 navController: NavController
) {
    var selectedIndex by remember {mutableStateOf(-1)}
    var showAlert by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = modifier
    ) {
        items(list.size) { id ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp).selectable(
                        selected = id == selectedIndex,
                        onClick = {
                            if (selectedIndex != id) {
                                selectedIndex = id
                                Log.d("city", list[id])
                                showAlert = true
                            }
                            else selectedIndex = -1
                        }
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(text = list.get(id))
            }

        }



    }

    if (showAlert){
        AlertComposable(
            onWeather = {
                val selectedCity = list[selectedIndex] // Retrieve selected city
                navController.navigate("weather/$selectedCity") // Pass city dynamically
                showAlert = false
            },

            onSave = {
                val selectedCity = list[selectedIndex] // Retrieve selected city
                vm.insertToDB(City(Math.random().toInt(), selectedCity)) // Save to DB
                showAlert = false
                navController.navigate("weather/$selectedCity") // Pass city dynamically

            })
    }

}