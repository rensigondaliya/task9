package com.example.task9;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ShareActionProvider;
import android.widget.Toast;

public class loginactivity extends AppCompatActivity {
EditText etemail,etpassword;
Button btnsignin,btnsignup;


    public static final String main_key="mypref";

    public static final String email_key="emailkey";
    public static final String password_key="passwordkey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
etemail=findViewById(R.id.etemail);
etpassword=findViewById(R.id.etpassword);
btnsignin=findViewById(R.id.btnsignin);
btnsignup=findViewById(R.id.btnsignup);


btnsignin.setOnClickListener(new View.OnClickListener() {@Override
    public void onClick(View view) {
        String useremail, userpassword;
        useremail = etemail.getText().toString();
        userpassword = etpassword.getText().toString();

        SharedPreferences preferences = getSharedPreferences(main_key, MODE_PRIVATE);
        String email = preferences.getString(email_key, "");
        SharedPreferences preferences1 = getSharedPreferences(password_key, MODE_PRIVATE);
        String password = preferences.getString(password_key, "");

        if (useremail.equals(email) && userpassword.equals(password))
        {
            Intent intent = new Intent(loginactivity.this, homeactivity.class);
            startActivity(intent);

        }
        else
        {
            Toast.makeText(loginactivity.this, "invalid", Toast.LENGTH_SHORT).show();
        }
    }
});

     btnsignup.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent = new Intent(loginactivity.this,MainActivity.class);
             startActivity(intent);
         }
     });

    }
}