package com.timilehinjegede.track_business.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.timilehinjegede.track_business.Adapter.PurchasesAdapter;
import com.timilehinjegede.track_business.R;
import com.timilehinjegede.track_business.ViewModel.ProductViewModel;
import com.timilehinjegede.track_business.db.PurchasesHistory;

import java.util.List;

public class VoucherActivity extends AppCompatActivity {

    RecyclerView viewVoucherRecyclerView;
    PurchasesAdapter purchaseOrSalesAdapter;
    ProductViewModel productViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voucher);

        viewVoucherRecyclerView = findViewById(R.id.viewVoucherRecyclerView);

        viewVoucherRecyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));

        purchaseOrSalesAdapter = new PurchasesAdapter(this);
        productViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);
        viewVoucherRecyclerView.setAdapter(purchaseOrSalesAdapter);
        productViewModel.getAllPurchasesHistory().observe(this, new Observer<List<PurchasesHistory>>() {
            @Override
            public void onChanged(List<PurchasesHistory> productHistories) {
                purchaseOrSalesAdapter.setProductHistoryList(productHistories);
            }
        });
    }
}
