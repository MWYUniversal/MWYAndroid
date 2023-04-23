package com.owner.room_db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.owner.room_db.entity.Person;

import java.util.List;

@Dao
public interface PersonDao {
    @Insert
    void insert(Person... persons);

    @Delete
    void delete(Person person);

    @Update
    void update(Person... persons);

    @Query("SELECT * FROM person")
    List<Person> query();
}
