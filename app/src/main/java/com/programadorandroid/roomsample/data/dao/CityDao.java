package com.programadorandroid.roomsample.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;

import com.programadorandroid.roomsample.data.entity.City;

@Dao
public interface CityDao {

    @Insert
    void insertAll(City... cities);

    @Delete
    void delete(City city);
}
