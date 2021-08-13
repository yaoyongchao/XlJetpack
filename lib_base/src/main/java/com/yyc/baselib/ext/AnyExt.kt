package com.yyc.baselib.ext

import android.util.Log
import android.view.View
import com.yyc.baselib.XlNetWork

/**
 * @author: gold
 * @time: 2021/7/29 上午10:01
 * @description: 超类扩展函数
 * @copyright (C) 2019-2021, XiaoLiu All Rights Reserved
 */

/**
 * 创建API
 */
fun <T> Any.initAPI(url: String, cla: Class<T>): T = XlNetWork.initRetrofit(url).create(cla)


/**
 * View点击事件扩展函数   防止快速点击处理
 */
inline fun View.click(crossinline onclick: (View) -> Unit) {
    val minTime = 500L
    var lastTime = 0L
    this.setOnClickListener {
        val tmpTime = System.currentTimeMillis()
        if (tmpTime - lastTime > minTime) {
            lastTime = tmpTime
            onclick.invoke(this)
        } else {
//            Log.d("click""点击过快，取消触发")
        }
    }
}

/**
 * View点击事件扩展函数   防止快速点击处理
 */
inline fun Any.loge(tag: String,strLog: String) {
    Log.e(tag,strLog)
}

/**
 * View点击事件扩展函数   防止快速点击处理
 */
inline fun Any.loge(strLog: String) {
    Log.e("aabb",strLog)
}