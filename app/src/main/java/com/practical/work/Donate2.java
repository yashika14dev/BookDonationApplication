package com.practical.work;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;

class PublicSharedPreferences {
    public static void setDefaults(String key, String value, Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getDefaults(String key, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, null);
    }
}
public class Donate2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ImageView imageView;
    public static final int RequestPermissionCode = 1;
    String[] options = { "1 star", "2 star", "3 star", "4 star", "5 star"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate2);
        Button btn2 = (Button) findViewById(R.id.upload);
        Button btn1 = (Button) findViewById(R.id.btn1);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String visibilityStr = PublicSharedPreferences.getDefaults("keyVisibility", getApplicationContext());

                if (visibilityStr != null) {
                    if (visibilityStr.equals("0")) {
                        visibilityStr = "1";
                    } else {
                        visibilityStr = "0";
                    }
                } else {
                    visibilityStr = "1";
                }

                PublicSharedPreferences.setDefaults("keyVisibility", visibilityStr, getApplicationContext());
                Toast.makeText(getApplicationContext(), "Successfully Submitted", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Donate2.this, Thankyou.class);
                Donate2.this.startActivity(intent);
            }
        });

        Spinner spin = (Spinner) findViewById(R.id.spin1);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, options);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
        EnableRuntimePermission();
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 7);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 7 && resultCode == RESULT_OK) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
        }
    }
    public void EnableRuntimePermission(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(Donate2.this,
                Manifest.permission.CAMERA)) {
            Toast.makeText(Donate2.this,"CAMERA permission allows us to Access CAMERA app",     Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(Donate2.this,new String[]{
                    Manifest.permission.CAMERA}, RequestPermissionCode);
        }
    }
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] result) {
        switch (requestCode) {
            case RequestPermissionCode:
                if (result.length > 0 && result[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(Donate2.this, "Permission Granted, Now your application can access CAMERA.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Donate2.this, "Permission Canceled, Now your application cannot access CAMERA.", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}


