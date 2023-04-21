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

    //数据库名
    private const val dbName: String = "zroom"

    //懒加载创建数据库
    val db: AppDatabase by lazy {
        Room.databaseBuilder(
            App.app.applicationContext, AppDatabase::class.java, dbName
        ).allowMainThreadQueries()//允许在主线程操作
            .addCallback(DbCreateCallBack)//增加回调监听
            .addMigrations(ZMigration)//增加数据库迁移
            .build()
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