package com.programadorandroid.roomsample.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.programadorandroid.roomsample.data.entity.Place;

import java.util.List;

@Dao
public interface PlaceDao {
    @Insert
    void insertAll(Place... places);

    @Delete
    void delete(Place place);

    @Query("SELECT * FROM place")
    List<Place> getAll();
}
