package com.yyc.baselib.ext

import com.yyc.baselib.XlNetWork

/**
 * 创建API
 */
fun <T> Any.initAPI(url: String, cla: Class<T>): T = XlNetWork.initRetrofit(url).create(cla)