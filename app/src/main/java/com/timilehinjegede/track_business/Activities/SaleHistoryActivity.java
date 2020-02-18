package com.timilehinjegede.track_business.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.timilehinjegede.track_business.Adapter.SalesAdapter;
import com.timilehinjegede.track_business.Dialogs.ViewHistoryDialog;
import com.timilehinjegede.track_business.R;
import com.timilehinjegede.track_business.ViewModel.ProductViewModel;
import com.timilehinjegede.track_business.db.SalesHistory;

import java.util.List;

public class SaleHistoryActivity extends AppCompatActivity {

    RecyclerView sRecyclerView;
    SalesAdapter salesAdapter;
    ProductViewModel productViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale_history);

        sRecyclerView = findViewById(R.id.saleHistoryRecyclerView);
        sRecyclerView.setLayoutManager(new LinearLayoutManager(this,
                RecyclerView.VERTICAL,
                false));

        salesAdapter = new SalesAdapter(this);
        productViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);
        productViewModel.getAllSalesHistory().observe(this, new Observer<List<SalesHistory>>() {
            @Override
            public void onChanged(List<SalesHistory> salesHistories) {
                salesAdapter.setSalesHistories(salesHistories);
                sRecyclerView.setAdapter(salesAdapter);
            }
        });

        salesAdapter.setOnSalesHistoryListener(new SalesAdapter.onSalesHistoryListener() {
            @Override
            public void onSalesHistoryClicked(SalesHistory salesHistory) {

                String name = salesHistory.getName();
                double quantity = salesHistory.getQuantitySold();
                String quantityType = salesHistory.getQuantityType();
                double unitPrice = salesHistory.getUnitPriceSold();
                double discount = salesHistory.getDiscountSold();
                double totalPrice = salesHistory.getTotalPrice();
                String category = salesHistory.getGoodsCategory();
                String soldTo = salesHistory.getSoldTo();
                String date = salesHistory.getDate();
                String time = salesHistory.getTime();

                ViewHistoryDialog viewHistoryDialog = new ViewHistoryDialog(
                    name,
                        String.valueOf(quantity),
                        quantityType,
                        String.valueOf(unitPrice),
                        String.valueOf(discount),
                        String.valueOf(totalPrice),
                        soldTo,
                        "12th December, 2020",
                        "12:34pm",
                        "Sale History"
                );

                viewHistoryDialog.show(getSupportFragmentManager(),"view history");
            }
        });
    }
}
