package com.yyc.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.yyc.baselib.ext.click
import com.yyc.baselib.ext.loge
import com.yyc.login.databinding.ActivityFlowBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlin.math.log

class FlowActivity : AppCompatActivity() {
    lateinit var binding : ActivityFlowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_flow)
        initView()
    }

    private fun initView() {
        binding.btn.click {
            test1()

        }
    }

    fun test1() {
        GlobalScope.launch {
            flow {
                emit(1)
                emit(2)
            }.map {
                "map $it"
            }.collect {
                loge("flow---value: $it")

            }
        }
    }
}