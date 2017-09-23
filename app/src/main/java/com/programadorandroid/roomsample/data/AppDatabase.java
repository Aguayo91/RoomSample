package com.programadorandroid.roomsample.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.programadorandroid.roomsample.data.dao.CityDao;
import com.programadorandroid.roomsample.data.dao.PlaceDao;
import com.programadorandroid.roomsample.data.entity.City;
import com.programadorandroid.roomsample.data.entity.Place;

@Database(entities = {Place.class,City.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public final static String DATABASE_NAME = "places_db";

    public abstract PlaceDao placeDao();
    public abstract CityDao cityDao();

}
