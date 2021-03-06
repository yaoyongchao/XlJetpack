package com.yyc.baselib.bean

data class XlBaseBean<T>(
    val data: T,
    val msg: String,
    val status: Int
) {
    /**
     * 网络数据请求成功
     */
    inline fun y(func: () -> Unit) {
        if (this.status == 200) func()
    }

    /**
     * 网络数据请求失败
     */
    inline fun n(func: () -> Unit) {
        if (this.status != 200) func()
    }
}