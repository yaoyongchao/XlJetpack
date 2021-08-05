package com.yyc.login

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel:ViewModel() {
    var name = MutableLiveData<String>().apply {
        value = "张三"
    }

    fun log() {
        Log.e("aabb","name:${name.value}")
    }
}