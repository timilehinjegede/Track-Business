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
import com.timilehinjegede.track_business.db.SalesHistory;

public class SalesActivity extends AppCompatActivity {

    EditText salesNameOfProduct,salesQuantityOfProduct,salesUnitPriceOfProduct,salesDiscountOfProduct,salesTotalPriceOfProduct,salesCustomerSoldTo,salesPassword,salesConfirmPassword;
    Button salesCancelButton, salesRecordButton;
    ProductViewModel productViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);

        initializeViews();

        salesRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = salesNameOfProduct.getText().toString().toUpperCase().trim();
                String quantity = salesQuantityOfProduct.getText().toString().toUpperCase().trim();
                String unitPrice = salesUnitPriceOfProduct.getText().toString().toUpperCase().trim();
                String discount = salesDiscountOfProduct.getText().toString().toUpperCase().trim();
                String totalPrice = salesTotalPriceOfProduct.getText().toString().toUpperCase().trim();
                String customerSoldTo = salesCustomerSoldTo.getText().toString().toUpperCase().trim();
                String password = salesPassword.getText().toString().toUpperCase().trim();
                String confirmPassword = salesConfirmPassword.getText().toString().toUpperCase().trim();


                SalesHistory salesHistory = new SalesHistory(
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
                    productViewModel = ViewModelProviders.of(SalesActivity.this).get(ProductViewModel.class);
                    productViewModel.insert(salesHistory);
                    startActivity(new Intent(SalesActivity.this,MainActivity.class));
                    finish();
                    Toast.makeText(SalesActivity.this,"Successfully recorded purchases",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(SalesActivity.this,"Incorrect Password, Cannot record Sales",Toast.LENGTH_LONG).show();
                }
            }
        });

        salesCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SalesActivity.this,MainActivity.class));
                finish();
            }
        });

    }

    private void initializeViews() {
        salesNameOfProduct = findViewById(R.id.salesNameOfProduct);
        salesQuantityOfProduct = findViewById(R.id.salesQuantityOfProduct);
        salesUnitPriceOfProduct = findViewById(R.id.salesUnitPriceOfProduct);
        salesDiscountOfProduct = findViewById(R.id.salesDiscountOfProduct);
        salesTotalPriceOfProduct = findViewById(R.id.salesTotalPriceOfProduct);
        salesCustomerSoldTo = findViewById(R.id.salesCustomerSoldTo);
        salesPassword = findViewById(R.id.salesPassword);
        salesConfirmPassword = findViewById(R.id.salesConfirmPassword);
        salesCancelButton = findViewById(R.id.salesCancelButton);
        salesRecordButton = findViewById(R.id.salesRecordButton);
    }
}
