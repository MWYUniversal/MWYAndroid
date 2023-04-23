package com.owner.room_db.utils

import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.owner.room_db.MainActivity
import com.owner.room_db.application.App
import com.owner.room_db.database.AppDatabase

/**
 * 数据库管理工具
 */
object DbManager {
    private val TagL = MainActivity::class.java.simpleName

    //懒加载创建数据库
    val db: AppDatabase by lazy {
        AppDatabase.getInstance(App.app.applicationContext,DbCreateCallBack)
    }

    private object DbCreateCallBack : RoomDatabase.Callback() {
        //第一次创建数据库时调用
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            Log.e(TagL, "first onCreate db version: " + db.version)
        }
    }

    /**
     * 数据库升级
     */
    private object ZMigration : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            Log.e(TagL, "执行数据库升级: ")
            //增加字段gender
            database.execSQL("ALTER TABLE loginUser ADD gender INTEGER Default 1 not null ")
        }
    }
}