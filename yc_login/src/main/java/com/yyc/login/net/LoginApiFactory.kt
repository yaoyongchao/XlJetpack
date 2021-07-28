package com.yyc.login.net

import com.yyc.baselib.ext.initAPI
import com.yyc.login.BuildConfig

/**
 * @author: gold
 * @time: 2021/7/28 下午7:36
 * @description: 创建请求Service
 * @copyright (C) 2019-2021, XiaoLiu All Rights Reserved
 */


var Any.API: LoginApiService
    set(value) {}
    get() = LoginApiFactory.api

object LoginApiFactory {
    // 域名
    const val DO_MAIN = BuildConfig.DO_MAIN
    // 接口路径
    const val LOGIN_URL = "$DO_MAIN/api/"

    val api: LoginApiService by lazy {
        initAPI(LOGIN_URL, LoginApiService::class.java)
    }
}