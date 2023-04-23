package com.owner.room_db.dao

import androidx.room.*
import com.owner.room_db.entity.Car

@Dao
interface CarDao {

    @Insert
    fun insert(vararg car: Car)

    @Delete
    fun delete(car: Car)

    @Update
    fun update(history: Car)

    @Query("SELECT * FROM car ")
    fun getAllHistory(): List<Car>?

}