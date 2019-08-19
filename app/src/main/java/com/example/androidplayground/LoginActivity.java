package com.example.androidplayground;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidplayground.API.ApiClient;
import com.example.androidplayground.API.ApiInterface;
import com.example.androidplayground.Model.Contact;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private List<Contact> contactList;
    private ApiInterface apiInterface;
    Call<List<Contact>> call;

    private SharedPreferenceconfig sharedPreferenceconfig;
    TextInputEditText edusername;
    EditText eduserpwd;
    Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPreferenceconfig = new SharedPreferenceconfig(getApplicationContext());
        edusername = findViewById(R.id.username);
        eduserpwd = findViewById(R.id.password);
        loginbtn = findViewById(R.id.loginbtn);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        call = apiInterface.getContacts();


        if (sharedPreferenceconfig.ReadLoginStatus()) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = edusername.getText().toString();
                final String userpassword = eduserpwd.getText().toString();
                call.clone().enqueue(new Callback<List<Contact>>() {
                    @Override
                    public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                        contactList = response.body();
                        for (Contact c: contactList) {
                            if(c.getUsername().equals(username ) && c.getPassword().equals(userpassword)){
                                Log.e("TAG", "onResponse: user login success" );
                                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                                sharedPreferenceconfig.WriteLoginStatus(true);
                                finish();
                                return;
                            }

                        }
                        Toast.makeText(LoginActivity.this,"Invalid User",Toast.LENGTH_SHORT).show();
                    }


                    @Override
                    public void onFailure(Call<List<Contact>> call, Throwable t) {

                    }
                });

            }
        });



    }

//    public void Loginbutton(final View view, final int position) {
//        final String username = edusername.getText().toString();
//        final String userpassword = eduserpwd.getText().toString();
//        call.enqueue(new Callback<List<Contact>>() {
//            @Override
//            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
//                contactList = response.body();
//                if (username.equals(contactList.get(position).getUsername()) &&
//                        userpassword.equals(contactList.get(position).getPassword())) {
//                    startActivity(new Intent(view.getContext(), MainActivity.class));
//                    sharedPreferenceconfig.WriteLoginStatus(true);
//                    finish();
//                } else {
//                    Toast.makeText(view.getContext(), "Login Failed", Toast.LENGTH_SHORT).show();
//                    edusername.setText("");
//                    eduserpwd.setText("");
//                }
//            }
//
//
//            @Override
//            public void onFailure(Call<List<Contact>> call, Throwable t) {
//
//            }
//        });
//
//
////        if(username.equals(getResources().getString(R.string.username))
////                && userpassword.equals(getResources().getString(R.string.password))){
////            startActivity(new Intent(this,MainActivity.class));
////            sharedPreferenceconfig.WriteLoginStatus(true);
////            finish();
////        }
////        else{
////            Toast.makeText(this,"Login Failed",Toast.LENGTH_SHORT).show();
////            edusername.setText("");
////            eduserpwd.setText("");
////        }
//
//
//    }
}
