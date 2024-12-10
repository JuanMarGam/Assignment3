package com.example.juanjosemarquezgamboa_comp304lab3_ex1.RoomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [StockInfo::class] , version = 1)
abstract class StockDataBase : RoomDatabase(){
    abstract fun getStockInfoDAO() : StockInfoDAO


    // multi-threading
    companion object{
        @Volatile
        private var INSTANCE : StockDataBase? = null
        fun getInstance(context: Context): StockDataBase {
            synchronized(this){//no  race conditions
                var inst = INSTANCE
                if (inst == null){
                    inst = Room.databaseBuilder(context,
                        StockDataBase::class.java,
                        "stocksDB").
                    build()
                }
                INSTANCE = inst
                return inst
            }


        }


    }


}
