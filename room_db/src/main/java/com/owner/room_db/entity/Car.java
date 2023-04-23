package com.owner.room_db.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "car")
public class Car {
    @PrimaryKey(autoGenerate = true) //可设置主键自增长
    public int uid;

    @ColumnInfo
    public String brand;

    @ColumnInfo
    public String displacement;

    @Ignore
    public Car() {
    }

    public Car(String brand, String displacement) {
        this.brand = brand;
        this.displacement = displacement;
    }

    @Override
    public String toString() {
        return "Car{" +
                "uid=" + uid +
                ", brand='" + brand + '\'' +
                ", displacement='" + displacement + '\'' +
                '}';
    }
}
