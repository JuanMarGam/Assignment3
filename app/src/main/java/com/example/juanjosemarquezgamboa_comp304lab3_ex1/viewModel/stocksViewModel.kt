package com.example.juanjosemarquezgamboa_comp304lab3_ex1.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.RoomDB.City
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.RoomDB.StockInfo
import kotlinx.coroutines.launch

class stocksViewModel (private val repository: AppRepository) : ViewModel() {



    var dbstocks by mutableStateOf<List<StockInfo>>(emptyList())
        private set

    init {
        viewModelScope.launch {
            val citiesFromDB = repository.getStocksFromDB()
            dbstocks = citiesFromDB
        }
    }

    fun getDBStocks(): List<StockInfo> {
        viewModelScope.launch {
            val dbfetchStocks = repository.getStocksFromDB()
            dbstocks = dbfetchStocks
        }
        return dbstocks
    }

    fun insertToDB(s: StockInfo) {
        viewModelScope.launch {
            repository.insertStock(s)
            val dbfetchStocks = repository.getStocksFromDB()
            dbstocks = dbfetchStocks
        }
    }

    fun update(newStock: StockInfo) {
        viewModelScope.launch {
            repository.update(newStock)
            val dbfetchStocks = repository.getStocksFromDB()
            dbstocks = dbfetchStocks
        }
    }

    fun deleteOneStock(s: StockInfo) {
        viewModelScope.launch {
            repository.deleteStock(s)
            val dbfetchStocks = repository.getStocksFromDB()
            dbstocks = dbfetchStocks
        }
    }

}