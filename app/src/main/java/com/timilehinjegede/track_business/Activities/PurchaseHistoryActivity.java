package com.timilehinjegede.track_business.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.timilehinjegede.track_business.Adapter.PurchasesAdapter;
import com.timilehinjegede.track_business.Dialogs.ViewHistoryDialog;
import com.timilehinjegede.track_business.R;
import com.timilehinjegede.track_business.ViewModel.ProductViewModel;
import com.timilehinjegede.track_business.db.PurchasesHistory;

import java.util.List;

public class PurchaseHistoryActivity extends AppCompatActivity {

    RecyclerView pRecyclerView;
    PurchasesAdapter purchasesAdapter;
    ProductViewModel productViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_history);

        pRecyclerView = findViewById(R.id.purchaseHistoryRecyclerView);
        pRecyclerView.setLayoutManager(new LinearLayoutManager(this,
                RecyclerView.VERTICAL,
                false));

        purchasesAdapter = new PurchasesAdapter(this);
        productViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);
        productViewModel.getAllPurchasesHistory().observe(this, new Observer<List<PurchasesHistory>>() {
            @Override
            public void onChanged(List<PurchasesHistory> purchasesHistories) {
                purchasesAdapter.setProductHistoryList(purchasesHistories);
                pRecyclerView.setAdapter(purchasesAdapter);
            }
        });

        purchasesAdapter.setOnPurchaseClickListener(new PurchasesAdapter.onPurchaseClickListener() {
            @Override
            public void onPurchaseHistoryClicked(PurchasesHistory purchasesHistory) {
                String name = purchasesHistory.getName();
                double quantity = purchasesHistory.getQuantityPurchased();
                String quantityType = purchasesHistory.getQuantityType();
                double unitPrice = purchasesHistory.getUnitPricePurchased();
                double discount = purchasesHistory.getDiscountPurchased();
                double totalPrice = purchasesHistory.getTotalPrice();
                String purchasedFrom = purchasesHistory.getPurchasedFrom();
                String goodsCategory = purchasesHistory.getGoodsCategory();
                String date = purchasesHistory.getDate();
                String time = purchasesHistory.getTime();

                ViewHistoryDialog viewHistoryDialog = new ViewHistoryDialog(
                        name,
                        String.valueOf(quantity),
                        quantityType,
                        String.valueOf(unitPrice),
                        String.valueOf(discount),
                        String.valueOf(totalPrice),
                        purchasedFrom,
                        "12th December, 2020",
                        "12:34pm",
                        "Purchase History"
                );

                viewHistoryDialog.show(getSupportFragmentManager(),"view history");
            }
        });

    }
}
