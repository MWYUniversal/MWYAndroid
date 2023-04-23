package com.owner.room_db.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.owner.room_db.dao.CarDao
import com.owner.room_db.dao.PersonDao
import com.owner.room_db.dao.UserDao
import com.owner.room_db.entity.Car
import com.owner.room_db.entity.Person
import com.owner.room_db.entity.User

@Database(entities = [User::class, Car::class,Person::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun carDao():CarDao
    abstract fun personDao():PersonDao

    companion object {
        private var instance: AppDatabase? = null

        private val TAG: String? = AppDatabase::class.simpleName

        fun getInstance(context: Context ,callback: RoomDatabase.Callback): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context, AppDatabase::class.java, "user_.db")
                    .fallbackToDestructiveMigration()

                    //是否允许在主线程进行查询
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
//                    .addMigrations(ADD_FIELD_MIGRATION_1_2)
                    .addCallback(callback)
                    .build()
            }
            return instance!!
        }
    }
}