package com.yyc.baselib

import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object XlNetWork {
    private val timeUnit: TimeUnit = TimeUnit.SECONDS
    private const val connectTimeOut: Long = 10
    private const val readTimeOut: Long = 30
    private const val writeTimeOut: Long = 30

    /**
     * 初始化Retrofit
     */
    fun initRetrofit(url: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .client(initHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /**
     * 初始化OkHttpClient
     */
    private fun initHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(connectTimeOut, timeUnit)
            .readTimeout(readTimeOut, timeUnit)
            .writeTimeout(writeTimeOut, timeUnit)
            .addInterceptor { chain ->
                val original = chain.request()
                val newOriginal = addParam(original)
                val request = newOriginal.newBuilder()
                    .header("NAME", "VALUE")
                    .header("Authorization","")
                    .method(newOriginal.method, newOriginal.body)
                    .build()
                chain.proceed(request)
            }
            .addInterceptor(OkHttpProfilerInterceptor())
            .build()
    }


    /**
     * 统一添加参数
     */
    private fun addParam(oldRequest: Request): Request {
        var builder = oldRequest.url
            .newBuilder()
//            .setEncodedQueryParameter(
//                "app_token",
//                ""
//            )
        return oldRequest.newBuilder()
            .method(oldRequest.method, oldRequest.body)
            .url(builder.build())
            .build()
    }
}