package com.example.juanjosemarquezgamboa_comp304lab3_ex1.RoomDB

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface StockInfoDAO {
    @Query("select * from StockInfo")
    suspend fun getAllStocks() : List<StockInfo>

    @Insert
    suspend fun insertStockToDB(s: StockInfo);

    @Delete
    suspend fun deleteStock(s:StockInfo);

    @Query("select * from StockInfo where stock LIKE :companyName ")
    suspend fun getStockNamed( companyName: String) : List<StockInfo>

    @Update
    suspend fun updateStock( stockToUpdate: StockInfo)
}