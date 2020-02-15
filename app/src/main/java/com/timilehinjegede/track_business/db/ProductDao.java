package com.timilehinjegede.track_business.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProductDao {

    @Insert
    void insert(Product product);

    @Update
    void update(Product product);

    @Delete
    void delete(Product product);

    @Query("SELECT * FROM product")
    LiveData<List<Product>> getAllProducts();

//    @Query("SELECT * FROM product WHERE product.name = :product")
//    LiveData<List<Product>> getThisProduct(Product product);
}
