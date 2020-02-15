package com.timilehinjegede.track_business.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.timilehinjegede.track_business.Adapter.InventoryAdapter;
import com.timilehinjegede.track_business.Dialogs.AdddProductDialog;
import com.timilehinjegede.track_business.R;
import com.timilehinjegede.track_business.ViewModel.ProductViewModel;
import com.timilehinjegede.track_business.db.Product;

import java.util.List;

public class InventoryActivity extends AppCompatActivity implements AdddProductDialog.addProductListener {

    RecyclerView allInventoryRecyclerView;
    InventoryAdapter inventoryAdapter;
    FloatingActionButton floatingActionButton;
    View view;
    ProductViewModel productViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        floatingActionButton = findViewById(R.id.addProductFab);
        allInventoryRecyclerView = findViewById(R.id.allInventoryRecyclerView);
        view = findViewById(R.id.myView);

        inventoryAdapter = new InventoryAdapter(this);

        inventoryAdapter.setOnProductClickListener(new InventoryAdapter.onProductClickListener() {
            @Override
            public void onProductClicked(Product product, String viewFilter) {
                if (viewFilter.equals("purchases")){
                    Toast.makeText(InventoryActivity.this,"Purchases",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(InventoryActivity.this,"Sales",Toast.LENGTH_SHORT).show();
                }
            }
        });

        inventoryAdapter.setOnProductLongClickListener(new InventoryAdapter.onProductLongClickListener() {
            @Override
            public void onProductLongClicked(final Product product) {
                AlertDialog builder = new AlertDialog.Builder(InventoryActivity.this)
                        .setTitle("Are you sure you want to delete this product?")
                        .setMessage("If you click yes, you won't be able to undo this action")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                productViewModel.delete(product);
                            }
                        })
                        .setNegativeButton("No",null)
                        .show();
            }
        });

        allInventoryRecyclerView.setLayoutManager(new LinearLayoutManager(
                    this,
                RecyclerView.VERTICAL,
                false
                ));

        allInventoryRecyclerView.setAdapter(inventoryAdapter);

        productViewModel = ViewModelProviders.of(InventoryActivity.this).get(ProductViewModel.class);
        productViewModel.getAllProducts().observe(InventoryActivity.this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                inventoryAdapter.setProductList(products);
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdddProductDialog productDialog = new AdddProductDialog();
                productDialog.show(getSupportFragmentManager(),"addproduct");
            }
        });
    }

    @Override
    public void addProduct(String name, String quantity, String unitPrice, String quantityType) {
        Product product = new Product(name,Double.parseDouble(quantity),quantityType,Double.parseDouble(unitPrice));
        productViewModel.insert(product);
    }
}
