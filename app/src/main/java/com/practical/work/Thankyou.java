package com.practical.work;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class Thankyou extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou);
        ImageView imgView = (ImageView) findViewById(R.id.thanku);

        String visibilityStr = PublicSharedPreferences.getDefaults("keyVisibility", getApplicationContext());

        if (visibilityStr.equals("0"))
            imgView.setVisibility(View.INVISIBLE);
        else
            imgView.setVisibility(View.VISIBLE);

        Button btn = (findViewById(R.id.btntobl));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Thankyou.this , Booklist.class);
                startActivity(i);
            }
        });
    }
}
