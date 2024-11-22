package com.example.juanjosemarquezgamboa_comp304lab3_ex1.Views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.juanjosemarquezgamboa_comp304lab3_ex1.viewModel.WeatherViewModel

@Composable
fun WeatherView(vm: WeatherViewModel) {
    Column(Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally ,
        verticalArrangement = Arrangement.Center) {
        var wo = vm.weatherO
        if (wo != null) {
            if (wo.weather?.size != 0){
                Text( text = wo.name,
                    fontSize = 40.sp,)
                Spacer(Modifier.fillMaxHeight(0.2f))
                wo.weather?.get(0)?.let {
                    AsyncImage(
                        model = "https://openweathermap.org/img/wn/${it.icon}@2x.png",
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(0.4f)
                    )
                }
                Spacer(Modifier.fillMaxHeight(0.2f))
                wo.weather?.get(0)?.let {
                    Text(
                        fontSize = 30.sp,
                        text = it.main
                    )
                }
                Spacer(Modifier.fillMaxHeight(0.1f))
                Text(
                    fontSize = 30.sp,
                    text = wo.main?.temp.toString()

                )
                Text(
                    fontSize = 30.sp,
                    text = "Feels Like " + wo.main?.feels_like.toString()

                )
            }
        }

    }
}