package com.yyc.login.net

import com.yyc.baselib.bean.XlBaseBean
import com.yyc.login.model.LoginResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface LoginApiService {
    @POST("doctor/login")
    suspend fun login(@Query("phone") phone: String, @Query("captcha") captcha: String): XlBaseBean<LoginResponse>
}