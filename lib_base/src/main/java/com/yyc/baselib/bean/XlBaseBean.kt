package com.yyc.baselib.bean

data class XlBaseBean<T>(
    val data: T,
    val msg: String,
    val status: Int
)