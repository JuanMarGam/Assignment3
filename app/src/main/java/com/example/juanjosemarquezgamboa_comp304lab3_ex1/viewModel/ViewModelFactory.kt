package com.example.juanjosemarquezgamboa_comp304lab3_ex1.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras

class ViewModelFactory(private val repository: AppRepository):
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(stocksViewModel::class.java)){
            return stocksViewModel(repository) as T
        }else {
            throw IllegalArgumentException("Error")
        }
    }
}

