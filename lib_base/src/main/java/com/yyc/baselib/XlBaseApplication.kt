package com.yyc.baselib

import android.app.Application
import org.koin.core.context.startKoin

open abstract class XlBaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initApp()
    }

    abstract fun initApp()

}