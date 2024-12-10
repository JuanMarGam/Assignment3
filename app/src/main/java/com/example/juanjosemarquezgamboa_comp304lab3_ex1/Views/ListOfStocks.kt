package com.example.juanjosemarquezgamboa_comp304lab3_ex1.Views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.RoomDB.StockInfo
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.viewModel.stocksViewModel

@Composable
fun ListOfDBStocks(
    list: List<StockInfo>,
    modifier: Modifier = Modifier,
    vm: stocksViewModel,
) {
    var stockSymbol by remember { mutableStateOf("") }
    var companyName by remember { mutableStateOf("") }
    var stockQuote by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxHeight()) {
        // Form section takes up half of the screen
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
        ) {
            // Title
            Text(text = "Insert Stocks")

            // Stock Symbol input field
            OutlinedTextField(
                value = stockSymbol,
                onValueChange = { stockSymbol = it },
                label = { Text("Stock Symbol") },
                modifier = Modifier.fillMaxWidth()
            )

            // Company Name input field
            OutlinedTextField(
                value = companyName,
                onValueChange = { companyName = it },
                label = { Text("Company Name") },
                modifier = Modifier.fillMaxWidth()
            )

            // Stock Quote input field
            OutlinedTextField(
                value = stockQuote,
                onValueChange = { stockQuote = it },
                label = { Text("Stock Quote") },
                modifier = Modifier.fillMaxWidth()
            )

            // Insert Stocks button
            Button(
                onClick = {
                    if (stockSymbol.isNotEmpty() && companyName.isNotEmpty() && stockQuote.isNotEmpty()) {
                        val newStock = StockInfo(
                            stockSymbol = stockSymbol,
                            companyName = companyName,
                            stockQuote = stockQuote.toDoubleOrNull() ?: 0.0
                        )
                        vm.insertToDB(newStock)
                        stockSymbol = ""
                        companyName = ""
                        stockQuote = ""
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Insert Stocks")
            }
        }

        // Table section takes up the other half of the screen
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
        ) {
            items(list.size) { id ->
                val stock = list[id] // Get the stock item from the list
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Display the stock details
                    Text(text = stock.stockSymbol, style = MaterialTheme.typography.bodyMedium)
                    Text(text = stock.companyName, style = MaterialTheme.typography.bodyMedium)
                    Text(
                        text = stock.stockQuote.toString(),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}
