package com.yyc.login.di

import com.yyc.login.model.LoginRespModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginAppMoudle = module {
//    factory 每次被需要时都创建（获取）一个新的实例
    factory {
        LoginRespModel()
    }

//    而 single 会让 Koin 保留实例用于今后直接返回，类似于 Dagger 中 @Singleton 的作用。
    single {

    }
//    ViewModel 可以说是 Android 架构组件发布后最流行的部分了，幸运的是 Kolin 对其做了非常方便的适配,在 Activity 或 Fragment 中直接使用 by viewModel() 或 getViewModel() 来注入。
//    viewModel
}