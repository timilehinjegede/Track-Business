package com.timilehinjegede.track_business.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.timilehinjegede.track_business.R;

import java.util.ArrayList;
import java.util.List;

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
                Toast.makeText(this,"Second",Toast.LENGTH_SHORT).show();
                break;
            case R.id.thirdCardView:
                Toast.makeText(this,"Third",Toast.LENGTH_SHORT).show();
                break;
            case R.id.forthCardView:
                Toast.makeText(this,"Forth",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
