package com.yyc.login

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.yyc.login.databinding.ActivityLoginBinding
import com.yyc.login.model.LoginRespModel
import com.yyc.login.net.API
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject


class LoginActivity : AppCompatActivity() {
//    val loginresp by inject<LoginRespModel>()
    lateinit  var dialog : AlertDialog
    lateinit var builder : AlertDialog.Builder
    val mModel by inject<LoginViewModel>()

    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        Log.e("aabb","----:" + API)

//        startActivity(Intent(this,FlowActivity::class.java))
//        finish()


        builder = AlertDialog.Builder(this)
        builder.setIcon(R.mipmap.ic_launcher)
        builder.setTitle("标题栏")
        builder.setMessage("打发顺丰撒风")


        dialog = builder.create()

        binding.lifecycleOwner = this
        binding.model = mModel


        binding.btnLogin.setOnClickListener {
//            coroutineTwo()
//            flowOne()
//            flowTwo()
            mModel.log()
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
        val aa = GlobalScope.launch {
            flow {
                val result = API.login("17600636720","666666")
                log("resule: ${result.msg}")
                emit(result)
            }.flowOn(Dispatchers.Main)
                .onStart {
                    log("onStart：${Thread.currentThread().name}" )
                    // 主线程中更新UI
                    withContext(Dispatchers.Main) {
                        if (dialog.isShowing.not())
                            dialog.show()
                    }
                }
                .onCompletion {
                    log("onCompletion：${Thread.currentThread().name}")
                    // 主线程中更新UI
                    withContext(Dispatchers.Main) {
                        if (dialog.isShowing)
                            dialog.dismiss()
                    }
                }
                .catch {
                    log("catch== ： ${Thread.currentThread().name}" )
                    // 主线程中更新UI
                    withContext(Dispatchers.Main) {
                        if (dialog.isShowing)
                            dialog.dismiss()
                    }
                }
                .collect {
                    log("collect:$it")
                    it.n {  }
                    if (it.status == 200) {
                        log("请求成功：$it")
                    } else {
                        log("请求失败：$it")
                    }
                }
        }

        log("aa:$aa")

    }

    fun flowTwo1() {
        val aa = GlobalScope.launch {
            API.login1("17600636720","666666")
                .flowOn(Dispatchers.Main)
                .onStart {
                    log("onStart：${Thread.currentThread().name}" )
                    // 主线程中更新UI
                    withContext(Dispatchers.Main) {
                        if (dialog.isShowing.not())
                            dialog.show()
                    }
                }
                .onCompletion {
                    log("onCompletion：${Thread.currentThread().name}")
                    // 主线程中更新UI
                    withContext(Dispatchers.Main) {
                        if (dialog.isShowing)
                            dialog.dismiss()
                    }
                }
                .catch {
                    log("catch== ： ${Thread.currentThread().name}" )
                    // 主线程中更新UI
                    withContext(Dispatchers.Main) {
                        if (dialog.isShowing)
                            dialog.dismiss()
                    }
                }
                .collect {
                    log("collect:$it")
                    it.n {  }
                    if (it.status == 200) {
                        log("请求成功：$it")
                    } else {
                        log("请求失败：$it")
                    }
                }
        }

        log("aa:$aa")
    }

    fun log(msg: String) {
        Log.e("aabb",msg)
    }

    fun flow3() {

    }
}