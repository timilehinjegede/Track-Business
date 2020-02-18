package com.timilehinjegede.track_business.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.timilehinjegede.track_business.db.Product;
import com.timilehinjegede.track_business.db.PurchasesHistory;
import com.timilehinjegede.track_business.db.ProductDao;
import com.timilehinjegede.track_business.db.ProductDatabase;
import com.timilehinjegede.track_business.db.PurchasesDao;
import com.timilehinjegede.track_business.db.SalesDao;
import com.timilehinjegede.track_business.db.SalesHistory;

import java.util.List;

public class ProductRepository {

    private ProductDao productDao;
    private LiveData<List<Product>> allProducts;
    private LiveData<List<Product>> thisProduct;
    private PurchasesDao purchasesDao;
    private LiveData<List<PurchasesHistory>> allPurchasesHistory;
    private SalesDao salesDao;
    private LiveData<List<SalesHistory>> allSalesHistory;

    public ProductRepository(Application application){
        ProductDatabase productDatabase = ProductDatabase.getInstance(application);
        productDao = productDatabase.productDao();
        purchasesDao = productDatabase.productHistoryDao();
        salesDao = productDatabase.salesDao();
        allProducts = productDao.getAllProducts();
        allPurchasesHistory = purchasesDao.getAllPurchasesHistory();
        allSalesHistory = salesDao.getAllSalesHistory();
//        thisProduct = productDao.getThisProduct();
    }

    //For product
    public void insert(Product product){
        new InsertProductAsyncTask(productDao).execute(product);
    }

    public void update(Product product){
        new UpdateProductAsyncTask(productDao).execute(product);
    }

    public void delete(Product product){
        new DeleteProductAsyncTask(productDao).execute(product);
    }

    public LiveData<List<Product>> getAllProducts(){
        return allProducts;
    }

    public LiveData<List<Product>> getThisProduct(Product product){
        return thisProduct;
    }

    //For purchases History
    public void insert(PurchasesHistory purchasesHistory){
        new InsertPurchasesHistoryAsyncTask(purchasesDao).execute(purchasesHistory);
    }

    public LiveData<List<PurchasesHistory>> getAllPurchasesHistory(){
        return allPurchasesHistory;
    }


    //For saleshistory History
    public void insert(SalesHistory salesHistory){
        new InsertSalesHistoryAsyncTask(salesDao).execute(salesHistory);
    }

    public LiveData<List<SalesHistory>> getAllSalesHistory(){
        return allSalesHistory;
    }


    //Async task for purchases history
    private static class InsertPurchasesHistoryAsyncTask extends  AsyncTask<PurchasesHistory,Void,Void>{

        private PurchasesDao purchasesDao;

        public InsertPurchasesHistoryAsyncTask(PurchasesDao purchasesDao) {
            this.purchasesDao = purchasesDao;
        }

        @Override
        protected Void doInBackground(PurchasesHistory... productHistories) {
            purchasesDao.insert(productHistories[0]);
            return null;
        }
    }

    //Async task for saleshistory history
    private static class InsertSalesHistoryAsyncTask extends  AsyncTask<SalesHistory,Void,Void>{

        private SalesDao salesDao;

        public InsertSalesHistoryAsyncTask(SalesDao salesDao) {
            this.salesDao = salesDao;
        }

        @Override
        protected Void doInBackground(SalesHistory... salesHistories) {
            salesDao.insert(salesHistories[0]);
            return null;
        }
    }

    private static class InsertProductAsyncTask extends AsyncTask<Product,Void,Void>{

        private ProductDao productDao;

        public InsertProductAsyncTask(ProductDao productDao) {
            this.productDao = productDao;
        }

        @Override
        protected Void doInBackground(Product... products) {
            productDao.insert(products[0]);
            return null;
        }
    }

    private static class DeleteProductAsyncTask extends  AsyncTask<Product,Void,Void>{

        private ProductDao productDao;

        public DeleteProductAsyncTask(ProductDao productDao) {
            this.productDao = productDao;
        }

        @Override
        protected Void doInBackground(Product... products) {
            productDao.delete(products[0]);
            return null;
        }
    }

    private static  class UpdateProductAsyncTask extends AsyncTask<Product,Void,Void>{

        private ProductDao productDao;

        public UpdateProductAsyncTask(ProductDao productDao) {
            this.productDao = productDao;
        }

        @Override
        protected Void doInBackground(Product... products) {
            productDao.update(products[0]);
            return null;
        }
    }

}
