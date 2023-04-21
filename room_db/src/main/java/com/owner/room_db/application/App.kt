package com.owner.room_db.application

import android.app.Application



class App : Application() {
    companion object {
        lateinit var app: App

        init {
            fun getApp(): App {
                return app
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        app = this
    }

}