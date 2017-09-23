package com.programadorandroid.roomsample.data;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

public class AppRepository {
    private static final String LOG_TAG = "AppRepository";
    private static AppRepository ourInstance;
    private AppDatabase appDatabase;

    public static AppRepository getInstance(Context context) {
        if(ourInstance == null){
            ourInstance = new AppRepository(context);
        }
        return ourInstance;
    }

    private AppRepository(Context context) {
        appDatabase = Room
                .databaseBuilder(context,AppDatabase.class, AppDatabase.DATABASE_NAME)
                .addCallback(new RoomDatabase.Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        Log.d(LOG_TAG,"onCreate: the database has been created");

                        //Insert City
                        ContentValues contentValuesCity = new ContentValues();
                        contentValuesCity.put("name", "Murcia");
                        long murciaCityId = db.insert("city", OnConflictStrategy.IGNORE, contentValuesCity);
                        Log.d(LOG_TAG,"onCreate: city inserted with id="+murciaCityId);

                        //Insert Places
                        ContentValues contentValuesPlace1 = new ContentValues();
                        contentValuesPlace1.put("name", "Catedral de Murcia");
                        contentValuesPlace1.put("description", "La Catedral de Santa María es una pieza clave del barroco español, se encuentra en el casco antiguo de Murcia");
                        contentValuesPlace1.put("city_id", murciaCityId);
                        db.insert("place", OnConflictStrategy.IGNORE, contentValuesPlace1);

                        ContentValues contentValuesPlace2 = new ContentValues();
                        contentValuesPlace2.put("name", "Ayuntamiento de Murcia");
                        contentValuesPlace2.put("description", "El edificio del Ayuntamiento de la ciudad de Murcia o Casa Consistorial se encuentra ubicado en la Plaza de la Glorieta, frente al cauce del río Segura");
                        contentValuesPlace2.put("city_id", murciaCityId);
                        db.insert("place", OnConflictStrategy.IGNORE, contentValuesPlace2);
                    }
                })
                .build();
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }
}
