package com.example.androidplayground;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

import com.example.androidplayground.Fragment.MessageFragment;

public class FragmentCommunication extends AppCompatActivity implements MessageFragment.OnMessageReadListener {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_communication);
        if (findViewById(R.id.framelayout1) != null) {
            if (savedInstanceState != null) {
                return;
            }
            MessageFragment messageFragment = new MessageFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.framelayout1, messageFragment, null);
            fragmentTransaction.commit();

        }
    }

    @Override
    public void onMessageRead(String Message) {
        textView = findViewById(R.id.textviewFC);
        textView.setText(Message);
    }
}
