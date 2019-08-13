package com.example.androidplayground.Fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidplayground.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {
    private EditText editText;
    private Button button;
    OnMessageReadListener onMessageReadListener;


    public MessageFragment() {
        // Required empty public constructor
    }

    public interface OnMessageReadListener {
        public void onMessageRead(String Message);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);

        editText = view.findViewById(R.id.etfragmentcom);
        button = view.findViewById(R.id.btnfragmentcom);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String message = editText.getText().toString();
                onMessageReadListener.onMessageRead(message);

            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try {
            onMessageReadListener = (OnMessageReadListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must Override OnMessageRead..");
        }

    }
}
