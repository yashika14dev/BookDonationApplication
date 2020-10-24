package com.practical.work;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    private EditText name;
    private EditText password;
    private TextView info;
    private Button login;
    private int counter =5 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.lname);
        password=(EditText)findViewById(R.id.lpass);
        login=(Button)findViewById(R.id.llogin);
        info = (TextView)findViewById(R.id.linfo);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uservalid(name.getText().toString() , password.getText().toString());
            }
        });
    }
    private void uservalid(String username , String userpassword){
        if(username.equals("admin")&&userpassword.equals("me")){
            Intent i = new Intent(MainActivity.this , ChoosePage.class);
            startActivity(i);
        }
        else {
            counter--;
            name.setText("");
            password.setText("");
            Toast.makeText(this,"No. of attempts remaining: "+counter,Toast.LENGTH_LONG);
            info.setText("Invalid username or password");
            if(counter==0){
                login.setEnabled(false);
            }
        }

    }





}
