package com.example.juanjosemarquezgamboa_comp304lab3_ex1.Views

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun AlertComposable(onSave: ()->Unit, onWeather: ()->Unit) {
    AlertDialog(
        onDismissRequest = {  },
        title = { Text(text = "Save to DB") },
        text = { Text(text = "Do You want to save this city to your favorite cities?") },
        confirmButton = {
            Button(
                onClick = {
                    onSave()
                }
            ) {
                Text(text = "Save and Go to Weather")
            }
        },
        dismissButton = {
            Button(
                onClick = {
                    onWeather()
                }
            ) {
                Text(text = "Don't Save and Go to Weather")
            }
        }
    )
}