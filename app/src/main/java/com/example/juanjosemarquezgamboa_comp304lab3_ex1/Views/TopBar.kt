package com.example.juanjosemarquezgamboa_comp304lab3_ex1.Views

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.viewModel.citiesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(vm: citiesViewModel,navController: NavController){
    var searchText by remember { mutableStateOf("") } // Query for SearchBar
    var active by remember { mutableStateOf(false) } // Active state for SearchBar
    var cnx = LocalContext.current
    TopAppBar(
        title = { Text(text = searchText) } ,
        actions = {
            SearchBar(
                modifier = Modifier.fillMaxWidth(0.5f),
                query = searchText,
                onQueryChange = {
                    searchText = it
                    Log.d("text", searchText)
                    if (searchText.length > 2){
                        vm.getCities(searchText)
                    }
                },
                onSearch = {
                    active = false
                },
                active = active,
                onActiveChange = {
                    active = it
                },
                placeholder = {
                    Text(text = "Search For Cities")
                },
                shape = SearchBarDefaults.inputFieldShape,

                trailingIcon = {
                    if (active) {
                        Icon(
                            modifier = Modifier.clickable {
                                if (searchText.isNotEmpty()) {
                                    searchText = ""
                                } else {
                                    active = false
                                }
                            },
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close icon"
                        )
                    }
                }

            ) {
                Text(text = searchText)
            }
            IconButton(onClick = {
                navController.navigate("favorites")
            }) {
                Icon(Icons.Default.Favorite, "")
            }



        })
}