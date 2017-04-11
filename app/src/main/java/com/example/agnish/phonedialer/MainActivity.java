package com.example.agnish.phonedialer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.agnish.phonedialer.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText screen;
    private static final int MY_PERMISSIONS_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeView();

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)){
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST);
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode){
            case MY_PERMISSIONS_REQUEST: {
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(MainActivity.this, "Permission Granted!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "No Permission Granted!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }
    }

    private void initializeView() {
        screen = (EditText)findViewById(R.id.screen);
        int idList[] = {R.id.btn1,R.id.btn2,R.id.btn3,
                R.id.btn4,R.id.btn5,R.id.btn6,
                R.id.btn7,R.id.btn8,R.id.btn9,
                R.id.btnDial,R.id.btnDel,R.id.btnStar,
                R.id.btn0,R.id.btnHash};

        for(int d: idList){
            View v = (View)findViewById(d);
            v.setOnClickListener(this);
        }
    }

    public void display(String val){
        screen.append(val);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn1:
                display("1");
                break;
            case R.id.btn2:
                display("2");
                break;
            case R.id.btn3:
                display("3");
                break;
            case R.id.btn4:
                display("4");
                break;
            case R.id.btn5:
                display("5");
                break;
            case R.id.btn6:
                display("6");
                break;
            case R.id.btn7:
                display("7");
                break;
            case R.id.btn8:
                display("8");
                break;
            case R.id.btn9:
                display("9");
                break;
            case R.id.btn0                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          :
                display("0");
                break;
            case R.id.btnStar:
                display("*");
                break;
            case R.id.btnHash:
                display("#");
                break;
            case R.id.btnDial:
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel: " + screen.getText()));
                startActivity(intent);
                break;
            case R.id.btnDel:
                if(screen.getText().toString().length()>=1) {
                    String newScreen = screen.getText().toString().substring(0, screen.getText().toString().length() - 1);
                    screen.setText(newScreen);
                }
                break;
            case R.id.btnClr:
                screen.setText(" ");
                break;
            default:
                break;
        }
    }
}