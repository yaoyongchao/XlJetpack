package com.yyc.login

import com.yyc.baselib.XlBaseApplication
import com.yyc.login.di.loginAppMoudle
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class XlLoginApplication : XlBaseApplication() {
    override fun initApp() {
        startKoin {
            androidLogger()
            androidContext(this@XlLoginApplication)
            modules(loginAppMoudle)
        }

    }
}