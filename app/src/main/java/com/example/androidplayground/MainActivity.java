package com.example.androidplayground;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SharedPreferenceconfig sharedPreferenceconfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferenceconfig = new SharedPreferenceconfig(getApplicationContext());

    }

    /* public void sendMessage(View view) {
        EditText editText = findViewById(R.id.user_message);
        String message = editText.getText().toString();
        Intent intent = new Intent(this, DisplayActivity.class);
        intent.putExtra("Extra_Message", message);
        startActivity(intent);
    }*/

    public void FragmentButton(View view) {
        startActivity(new Intent(this, FragmentExample.class));
    }

    public void FragmentOnRuntime(View view) {
        startActivity(new Intent(this, FragmentOnRuntimeActivity.class));
    }

    public void FragmentCommunication(View view) {
        startActivity(new Intent(this, FragmentCommunication.class));
    }

    public void RecyclerViewExample(View view) {
        startActivity(new Intent(this, RecyclerViewExample.class));
    }

    public void Onboardingclick(View view) {
        startActivity(new Intent(this, OnBoardingActivity.class));
    }

    public void OnClickLogout(View view) {
        sharedPreferenceconfig.WriteLoginStatus(false);
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void sqliteDB(View view) {
        startActivity(new Intent(this,SqlDatabase.class));
    }

    public void onClickRetrofit(View view) {
        startActivity(new Intent(this,RetrofitActivity.class));
    }
}
