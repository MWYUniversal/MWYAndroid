package com.owner.store.base

import android.app.Application

class StoreApp :Application(){
    companion object{
        lateinit var appInstance:StoreApp
    }

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }
}