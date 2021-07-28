package com.yyc.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.yyc.login.databinding.ActivityLoginBinding
import com.yyc.login.model.LoginRespModel
import com.yyc.login.net.API
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject


class LoginActivity : AppCompatActivity() {
    val loginresp by inject<LoginRespModel>()
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        Log.e("aabb","-----" + loginresp + "*** ")
        Log.e("aabb","----:" + API)

        binding.btnLogin.setOnClickListener {
            coroutineTwo()
        }

    }

    fun coroutineTwo() {
        GlobalScope.launch(Dispatchers.Main) {
            val loginRes = API.login("17600636720","666666")
            Log.e("aabb","res:${loginRes.data.toString()}")
        }

    }
}