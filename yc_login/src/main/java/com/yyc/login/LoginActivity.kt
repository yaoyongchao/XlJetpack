package com.yyc.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.yyc.login.model.LoginRespModel
import org.koin.android.ext.android.inject


class LoginActivity : AppCompatActivity() {
    val loginresp by inject<LoginRespModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Log.e("aabb","-----" + loginresp + "*** ")
    }
}