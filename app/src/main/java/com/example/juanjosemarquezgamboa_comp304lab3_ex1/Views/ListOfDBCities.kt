package com.example.juanjosemarquezgamboa_comp304lab3_ex1.Views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.RoomDB.City
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.viewModel.citiesViewModel

@Composable
fun ListOfDBCities(
    list: List<City>,
    modifier: Modifier = Modifier,
    vm: citiesViewModel,
    onCityClick: (City) -> Unit
) {
    // State to control the dialog
    val isDialogOpen = remember { mutableStateOf(false) }
    val cityToEdit = remember { mutableStateOf<City?>(null) }
    val newCityName = remember { mutableStateOf("") }

    LazyColumn(modifier = modifier) {
        items(list.size) { id ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = list[id].cityName)
                IconButton(onClick = {
                    vm.deleteOneCity(list[id])
                }) {
                    Icon(Icons.Default.Delete, "")
                }
                // Edit Button
                IconButton(onClick = {
                    cityToEdit.value = list[id]
                    newCityName.value = list[id].cityName // Pre-fill the text field with the current name
                    isDialogOpen.value = true
                }) {
                    Icon(Icons.Default.Edit, "Edit City Name")
                }
            }
        }
    }

    // Dialog for editing the city name
    if (isDialogOpen.value) {
        AlertDialog(
            onDismissRequest = { isDialogOpen.value = false },
            title = { Text("Edit City Name") },
            text = {
                Column {
                    TextField(
                        value = newCityName.value,
                        onValueChange = { newCityName.value = it },
                        label = { Text("New City Name") },
                        modifier = Modifier.padding(8.dp)
                    )
                }
            },
            confirmButton = {
                Button(onClick = {
                    cityToEdit.value?.let {
                        val updatedCity = it.copy(cityName = newCityName.value)
                        vm.update(updatedCity) // Update the city in the database
                    }
                    isDialogOpen.value = false
                }) {
                    Text("Save")
                }
            },
            dismissButton = {
                Button(onClick = { isDialogOpen.value = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}