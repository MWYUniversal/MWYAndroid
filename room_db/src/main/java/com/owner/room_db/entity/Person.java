package com.owner.room_db.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "person")
public class Person {
    @PrimaryKey(autoGenerate = true) //可设置主键自增长
    public int uid;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "age")
    public int age;

    @ColumnInfo(name = "height")
    public double height;

    @ColumnInfo(name = "test")
    public double test;

    @Ignore
    public Person() {
    }

    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}
