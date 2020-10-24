package com.practical.work;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChoosePage extends AppCompatActivity {
    private CardView donateCard, requestCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_page);
        //defining cards
        donateCard = (CardView) findViewById(R.id.donate_card);
        requestCard = (CardView) findViewById(R.id.request_card);
        //adding onclick

        requestCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(ChoosePage.this , Request.class);
                startActivity(i);

            }
        });
        donateCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;

                i = new Intent(ChoosePage.this, Donate.class);
                startActivity(i);

            }
        });
    }
}