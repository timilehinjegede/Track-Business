package com.timilehinjegede.track_business.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PurchasesDao {

    @Insert
    void insert(PurchasesHistory productHistory);

    @Query("SELECT * FROM purchaseshistory")
    LiveData<List<PurchasesHistory>> getAllPurchasesHistory();

//    @Query("SELECT * FROM PurchasesHistory WHERE goodsCategory=:category")
//    LiveData<List<PurchasesHistory>> getCategoryProductHistory(String category);

}
