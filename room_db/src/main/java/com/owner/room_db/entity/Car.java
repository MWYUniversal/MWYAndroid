package com.owner.room_db.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Car {
    @PrimaryKey(autoGenerate = true) //可设置主键自增长
    public int uid;

    @ColumnInfo
    public String brand;

    @ColumnInfo
    public String displacement;

    public Car(String brand, String displacement) {
        this.brand = brand;
        this.displacement = displacement;
    }
}
