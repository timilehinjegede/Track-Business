package com.timilehinjegede.track_business.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.timilehinjegede.track_business.db.Product;
import com.timilehinjegede.track_business.db.ProductHistory;
import com.timilehinjegede.track_business.db.ProductDao;
import com.timilehinjegede.track_business.db.ProductDatabase;

import java.util.List;

public class ProductRepository {

    private ProductDao productDao;
    private LiveData<List<Product>> allProducts;
    private LiveData<List<Product>> thisProduct;

    public ProductRepository(Application application){
        ProductDatabase productDatabase = ProductDatabase.getInstance(application);
        productDao = productDatabase.productDao();
        allProducts = productDao.getAllProducts();
//        thisProduct = productDao.getThisProduct();
    }

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
