package com.owner.room_db.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.owner.room_db.dao.UserDao
import com.owner.room_db.entity.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private var instance: AppDatabase? = null

        private val TAG: String? = AppDatabase::class.simpleName

        fun get(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context, AppDatabase::class.java, "user_.db")
                    .fallbackToDestructiveMigration()

                    //是否允许在主线程进行查询
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
//                    .addMigrations(ADD_FIELD_MIGRATION_1_2)
                    .addCallback(object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            Log.e(TAG, "onCreate db_name is=" + db.path)
                        }
                    })
                    .build()
            }
            return instance!!
        }
    }
}