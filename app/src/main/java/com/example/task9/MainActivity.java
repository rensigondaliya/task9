package com.example.task9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
 EditText etname,etnum,etpassword,etemail;
 Button button;
 public static final String main_key="mypref";
    public static final String name_key="namekey";
    public static final String email_key="emailkey";
    public static final String password_key="passwordkey";
    public static final String num_key="numkey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etemail=findViewById(R.id.etemail);
        etname=findViewById(R.id.etname);
        etnum=findViewById(R.id.etnum);
        etpassword=findViewById(R.id.etpassword);
        button=findViewById(R.id.button);


                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        SharedPreferences Preferences= getSharedPreferences(main_key,MODE_PRIVATE);
                        String name,email,password,num;
                        name=etname.getText().toString();
                        email=etemail.getText().toString();
                        password=etpassword.getText().toString();
                        num=etnum.getText().toString();

                        SharedPreferences.Editor editor= Preferences.edit();
                        editor.putString(name_key,name);
                        editor.putString(email_key,email);
                        editor.putString(num_key,num);
                        editor.putString(password_key,password);

                        editor.commit();

                        Intent intent = new Intent(MainActivity.this,loginactivity.class);
                        startActivity(intent);

                    }
                });
    }

}