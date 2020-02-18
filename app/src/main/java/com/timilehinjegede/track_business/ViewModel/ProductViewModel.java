package com.timilehinjegede.track_business.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.timilehinjegede.track_business.Repository.ProductRepository;
import com.timilehinjegede.track_business.db.Product;
import com.timilehinjegede.track_business.db.PurchasesHistory;
import com.timilehinjegede.track_business.db.SalesHistory;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {

    private ProductRepository productRepository;
    private LiveData<List<Product>> allProducts;
    private LiveData<List<PurchasesHistory>> allPurchasesHistory;
    private LiveData<List<SalesHistory>> allSalesHistory;


    public ProductViewModel(@NonNull Application application) {
        super(application);
        productRepository = new ProductRepository(application);
        allProducts = productRepository.getAllProducts();
        allPurchasesHistory = productRepository.getAllPurchasesHistory();
        allSalesHistory = productRepository.getAllSalesHistory();
    }

    public void insert(PurchasesHistory productHistory){
        productRepository.insert(productHistory);
    }

    public void insert(SalesHistory salesHistory){
        productRepository.insert(salesHistory);
    }

    public LiveData<List<SalesHistory>> getAllSalesHistory(){
        return allSalesHistory;
    }

    public LiveData<List<PurchasesHistory>> getAllPurchasesHistory(){
        return allPurchasesHistory;
    }

    public void insert(Product product){
        productRepository.insert(product);
    }

    public void update(Product product){
        productRepository.update(product);
    }

    public void delete(Product product){
        productRepository.delete(product);
    }

    public  LiveData<List<Product>> getAllProducts(){
        return allProducts;
    }
}
