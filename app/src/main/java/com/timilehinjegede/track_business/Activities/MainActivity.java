package com.timilehinjegede.track_business.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.timilehinjegede.track_business.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.firstCardView:
                startActivity(new Intent(MainActivity.this,InventoryActivity.class));
                break;
            case R.id.secondCardView:
                startActivity(new Intent(MainActivity.this, VoucherActivity.class));
                break;
            case R.id.thirdCardView:
                startActivity(new Intent(MainActivity.this, SalesActivity.class));
                break;
            case R.id.forthCardView:
                startActivity(new Intent(MainActivity.this, SaleHistoryActivity.class));
                break;
            case R.id.fifthCardView:
                startActivity(new Intent(MainActivity.this, PurchaseActivity.class));
                break;
            case R.id.sixthCardView:
                startActivity(new Intent(MainActivity.this, PurchaseHistoryActivity.class));
                break;
        }
    }
}
