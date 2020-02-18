package com.timilehinjegede.track_business.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
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
        TextView knowYouTextView = findViewById(R.id.knowYouTextView);

        String myString = "Let's \nget to \nknow \nyour Business";

        SpannableString spannableString = new SpannableString(myString);

        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getResources().getColor(R.color.colorPrimary));

        spannableString.setSpan(foregroundColorSpan,9,myString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        knowYouTextView.setText(spannableString);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KnowYouActivity.this,MainActivity.class));
            }
        });
    }
}
