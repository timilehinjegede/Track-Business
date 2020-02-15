package com.timilehinjegede.track_business.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.timilehinjegede.track_business.R;

public class KnowYouActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_know_you);

        Button button = findViewById(R.id.getStartedButton);
        TextView textView = findViewById(R.id.knowYouTextView);

        String myString = "Let's get to know your Business";

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KnowYouActivity.this,MainActivity.class));
            }
        });
    }
}
