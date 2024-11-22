package com.example.juanjosemarquezgamboa_comp304lab3_ex1.viewModel

import com.example.juanjosemarquezgamboa_comp304lab3_ex1.RoomDB.City
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.RoomDB.CityDAO
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.data.RetrofitClass
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.data.WeatherObject

class AppRepository(private val cityDao: CityDAO) {

    private val apiService = RetrofitClass.api
    private val weatherApiService = RetrofitClass.weatherApi

    suspend fun getCities(query: String): List<String>{
        return apiService.getCities(query)
    }

    suspend fun getWeather(city: String): WeatherObject?{
        return  weatherApiService.getWeather(city,"792f14eb6564aee06df20a8df81495cb", "metric")

    }

    suspend fun getCitiesFromDB(): List<City>{
        return cityDao.getAllCities()
    }

    suspend fun insertCity(c:City){
        cityDao.insertCityToDB(c)
    }

    suspend fun deleteCity(c:City){
        cityDao.deleteCity(c)
    }

    suspend fun searchForCityInDB(term:String) : List<City>{
        return cityDao.getCityNamed(term)
    }

    suspend fun update(newCity: City){
        return cityDao.updateCity(newCity)
    }


}