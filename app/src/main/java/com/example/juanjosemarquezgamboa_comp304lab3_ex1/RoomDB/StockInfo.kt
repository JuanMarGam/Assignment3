package com.example.juanjosemarquezgamboa_comp304lab3_ex1.RoomDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class StockInfo(
    @PrimaryKey val stockSymbol: String,
    @ColumnInfo("stock")
    val companyName: String,
    @ColumnInfo("quote")
    val stockQuote: Double
    ){

}


