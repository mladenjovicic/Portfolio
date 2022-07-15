package com.mladenjovicic.portfolio

import android.app.Application

class PortfolioApplication:Application(){

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: PortfolioApplication
    }
}