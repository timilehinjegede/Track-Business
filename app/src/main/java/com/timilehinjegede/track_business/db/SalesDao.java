package com.timilehinjegede.track_business.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SalesDao {

    @Insert
    void insert(SalesHistory salesHistory);

    @Query("SELECT * FROM saleshistory")
    LiveData<List<SalesHistory>> getAllSalesHistory();

//    LiveData<List<SalesHistory>> getThisProductSalesHistory(Product product);
}
