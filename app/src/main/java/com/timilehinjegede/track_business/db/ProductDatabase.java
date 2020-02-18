package com.timilehinjegede.track_business.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Product.class, PurchasesHistory.class, SalesHistory.class},version = 1,exportSchema = false)
public abstract class ProductDatabase extends RoomDatabase {

    private static ProductDatabase productDatabase;

    public abstract ProductDao productDao();
    public abstract PurchasesDao productHistoryDao();
    public abstract SalesDao salesDao();

    public static synchronized  ProductDatabase getInstance(Context context){

        if (productDatabase == null){
            productDatabase = Room.databaseBuilder(
                    context.getApplicationContext(),
                    ProductDatabase.class,
                    "product_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return productDatabase;
    }
}
