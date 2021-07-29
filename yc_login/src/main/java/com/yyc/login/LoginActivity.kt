package com.yyc.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.yyc.baselib.bean.XlBaseBean
import com.yyc.login.databinding.ActivityLoginBinding
import com.yyc.login.model.LoginRespModel
import com.yyc.login.model.LoginResponse
import com.yyc.login.net.API
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.*
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
//            coroutineTwo()
//            flowOne()
            flowTwo()
        }

    }

    fun coroutineTwo() {
        GlobalScope.launch(Dispatchers.Main) {
            val loginRes = API.login("17600636720","666666")
            Log.e("aabb","res:${loginRes.data.toString()}")
        }

    }

    fun flowOne () {
        GlobalScope.launch {
            flow<Int> {
                emit(1)
                emit(2)

            }.collect {
                Log.e("aabb","flow-$it")
            }

        }
    }

    fun flowTwo() {
        GlobalScope.launch {
            flow {
                val result = API.login("17600636720","666666")
                log("resule: ${result.msg}")
                emit(result)
            }.flowOn(Dispatchers.IO)
                .onStart {
                    log("onStart")
                }
                .onCompletion {
                    log("onCompletion")
                }
                .catch {
                    log("catch== " + this)
                }
                .collect {
                    it.n {  }
                    if (it.status == 200) {
                        log("请求成功：$it")
                    } else {
                        log("请求失败：$it")
                    }
                }
        }

    }

    fun log(msg: String) {
        Log.e("aabb",msg)
    }

    fun flow3() {

    }
}