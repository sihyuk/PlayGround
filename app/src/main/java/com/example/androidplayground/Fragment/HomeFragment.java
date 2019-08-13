package com.example.androidplayground.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.androidplayground.FragmentOnRuntimeActivity;
import com.example.androidplayground.MainActivity;
import com.example.androidplayground.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

private Button button;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        button = view.findViewById(R.id.homefragmentbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentOnRuntimeActivity.fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container,new FirstFragment(),null)
                            .addToBackStack(null)
                                .commit();
            }
        });
        return view;
    }

}
