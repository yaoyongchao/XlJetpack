package com.yyc.baselib.ext

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