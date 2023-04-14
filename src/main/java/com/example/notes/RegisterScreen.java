package com.example.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class RegisterScreen extends AppCompatActivity {

    AppSharedPref sharedPref;
    final androidx.fragment.app
            .FragmentManager mFragmentManager
            = getSupportFragmentManager();
    final androidx.fragment.app
            .FragmentTransaction mFragmentTransaction
            = mFragmentManager.beginTransaction();
    final ProfileFragment mFragment = new ProfileFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button btnregister = findViewById(R.id.btnLogin);
        // sharedPreferences = getSharedPreferences("Register", MODE_PRIVATE);


        if (AppSharedPref.isUserLogin(this)) {
            startActivity(new Intent(RegisterScreen.this, MainScreen.class));
        }

        EditText name = findViewById(R.id.edtname);
        EditText email = findViewById(R.id.edtemail);
        EditText phone = findViewById(R.id.edtphone);
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_data = name.getText().toString();
                String email_data = email.getText().toString();
                String phone_data = phone.getText().toString();

                if (!name_data.isEmpty() && !email_data.isEmpty() && !phone_data.isEmpty()) {

                    AppSharedPref.writeToSharedPref(RegisterScreen.this, name_data, email_data, phone_data);
                    Intent intent = new Intent(RegisterScreen.this, MainScreen.class);
                    // intent.putExtra("name", name_data);
                    // intent.putExtra("email", email_data);
                    // intent.putExtra("phone", phone_data);
                    // Bundle mBundle = new Bundle();
                    //  mBundle.putString("mname", name_data);
                    // mBundle.putString("memail", email_data);
                    //mBundle.putString("mphone", phone_data);
                    // mFragment.setArguments(mBundle);
                    // mFragmentTransaction.add(R.id.fragmentContainerView, mFragment).commit();
                    startActivity(intent);


                } else {
                    Toast.makeText(RegisterScreen.this, "All Data is Required there is wrong data", Toast.LENGTH_SHORT).show();

                }


            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {// of dark /light sceen
        getMenuInflater().inflate(R.menu.testlight, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {////light dark sceen

        int id = item.getItemId();
        switch (id) {

            case R.id.ll: {/// check


                if (item.isChecked() && item.isCheckable()) {
                    item.setChecked(false);
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    Toast.makeText(this, "now not checked icon", Toast.LENGTH_SHORT).show();
                    item.setTitle("lightmood");


                } else {
                    item.setChecked(true);
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    Toast.makeText(this, "checked icon", Toast.LENGTH_SHORT).show();
                    item.setTitle("nifhtmood");
                }

                //  Toast.makeText(this,"false icon",Toast.LENGTH_SHORT).show();
                break;
            }

        }
        return true;
    }
}