package com.example.juanjosemarquezgamboa_comp304lab3_ex1.viewModel

import com.example.juanjosemarquezgamboa_comp304lab3_ex1.RoomDB.City
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.RoomDB.CityDAO
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.RoomDB.StockInfo
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.RoomDB.StockInfoDAO

class AppRepository(private val stockDAO: StockInfoDAO) {

    suspend fun getStocksFromDB(): List<StockInfo>{
        return stockDAO.getAllStocks()
    }

    suspend fun insertStock(s:StockInfo){
        stockDAO.insertStockToDB(s)
    }

    suspend fun deleteStock(s:StockInfo){
        stockDAO.deleteStock(s)
    }

    suspend fun searchForStockInDB(term:String) : List<StockInfo>{
        return stockDAO.getStockNamed(term)
    }

    suspend fun update(newStock: StockInfo){
        return stockDAO.updateStock(newStock)
    }


}