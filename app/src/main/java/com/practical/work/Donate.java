package com.practical.work;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

public class Donate extends AppCompatActivity {

    Button nxtbtn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        nxtbtn1 = (findViewById(R.id.nxtbtn1));
        nxtbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i ;
                i = new Intent(Donate.this , Donate2.class);
                startActivity(i);
            }
        });
    }
}
