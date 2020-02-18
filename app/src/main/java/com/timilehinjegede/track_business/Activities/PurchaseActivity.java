package com.timilehinjegede.track_business.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.timilehinjegede.track_business.R;
import com.timilehinjegede.track_business.ViewModel.ProductViewModel;
import com.timilehinjegede.track_business.db.PurchasesHistory;

public class PurchaseActivity extends AppCompatActivity {

    EditText purchasesNameOfProduct,purchasesQuantityOfProduct,purchasesUnitPriceOfProduct,purchasesDiscountOfProduct,purchasesTotalPriceOfProduct,purchasesCustomerPurchasedFrom,purchasesPassword,purchasesConfirmPassword;
    Button purchasesCancelButton, purchasesRecordButton;
    ProductViewModel productViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        initializeViews();

        purchasesRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = purchasesNameOfProduct.getText().toString().toUpperCase().trim();
                String quantity = purchasesQuantityOfProduct.getText().toString().toUpperCase().trim();
                String unitPrice = purchasesUnitPriceOfProduct.getText().toString().toUpperCase().trim();
                String discount = purchasesDiscountOfProduct.getText().toString().toUpperCase().trim();
                String totalPrice = purchasesTotalPriceOfProduct.getText().toString().toUpperCase().trim();
                String customerSoldTo = purchasesCustomerPurchasedFrom.getText().toString().toUpperCase().trim();
                String password = purchasesPassword.getText().toString().toUpperCase().trim();
                String confirmPassword = purchasesConfirmPassword.getText().toString().toUpperCase().trim();

                PurchasesHistory purchasesHistory = new PurchasesHistory(
                        name,
                        Double.parseDouble(quantity),
                        "Dozens",
                        Double.parseDouble(unitPrice),
                        Double.parseDouble(discount),
                        Double.parseDouble(totalPrice),
                        customerSoldTo,
                        "Sales",
                        "My Date",
                        "My Time"
                );

                if ((Integer.parseInt(password)==1234) && (Integer.parseInt(confirmPassword)==1234)){
                    productViewModel = ViewModelProviders.of(PurchaseActivity.this).get(ProductViewModel.class);
                    productViewModel.insert(purchasesHistory);
                    startActivity(new Intent(PurchaseActivity.this,MainActivity.class));
                    finish();
                    Toast.makeText(PurchaseActivity.this,"Successfully recorded purchases",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(PurchaseActivity.this,"Incorrect Password, Cannot record Purchases",Toast.LENGTH_LONG).show();
                }
            }
        });

        purchasesCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PurchaseActivity.this,MainActivity.class));
                finish();
            }
        });
    }

    private void initializeViews() {
        purchasesNameOfProduct = findViewById(R.id.purchasesNameOfProduct);
        purchasesQuantityOfProduct = findViewById(R.id.purchasesQuantityOfProduct);
        purchasesUnitPriceOfProduct = findViewById(R.id.purchasesUnitPriceOfProduct);
        purchasesDiscountOfProduct = findViewById(R.id.purchasesDiscountOfProduct);
        purchasesTotalPriceOfProduct = findViewById(R.id.purchasesTotalPriceOfProduct);
        purchasesCustomerPurchasedFrom = findViewById(R.id.customerPurchasedFrom);
        purchasesPassword = findViewById(R.id.purchasesPassword);
        purchasesConfirmPassword = findViewById(R.id.purchasesConfrimPassword);
        purchasesCancelButton = findViewById(R.id.purchasesCancelButton);
        purchasesRecordButton = findViewById(R.id.purchasesRecordButton);
    }
}
