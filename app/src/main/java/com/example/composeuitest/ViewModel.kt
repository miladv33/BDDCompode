package com.example.composeuitest

import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(): ViewModel() {
    val text = MutableLiveData<String>()

}