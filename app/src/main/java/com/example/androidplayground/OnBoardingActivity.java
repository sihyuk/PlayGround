package com.example.androidplayground;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.androidplayground.Adapter.SliderAdapter;
import com.example.androidplayground.Model.ModelItem;

import java.util.ArrayList;
import java.util.List;

public class OnBoardingActivity extends AppCompatActivity {
private ViewPager viewPager;
private LinearLayout linearLayout;
private SliderAdapter sliderAdapter;
    List<ModelItem> modelItems = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);
        viewPager = findViewById(R.id.viewPager);
        linearLayout = findViewById(R.id.oblinearlayout);

        sliderAdapter = new SliderAdapter(this,getData());
        viewPager.setAdapter(sliderAdapter);

    }
    private List<ModelItem> getData(){

        modelItems.add(new ModelItem(R.drawable.war_and_peace,"War and Peace"));
        modelItems.add(new ModelItem(R.drawable.angels_and_demon,"Angels and Demon"));
        modelItems.add(new ModelItem(R.drawable.game_of_thrones1,"Game of throne"));
        modelItems.add(new ModelItem(R.drawable.shadow_of_the_wind,"Shadow of the wind"));
        modelItems.add(new ModelItem(R.drawable.song_of_solomon,"Song of Solomon"));
        modelItems.add(new ModelItem(R.drawable.the_culling_trial,"The Culling Trial"));
        modelItems.add(new ModelItem(R.drawable.the_da_vinci_code,"Da Vinci Code"));
        modelItems.add(new ModelItem(R.drawable.the_name_of_the_wind,"Name of Wind"));
        modelItems.add(new ModelItem(R.drawable.to_kill_a_mockingbird,"Mockingbird"));
        modelItems.add(new ModelItem(R.drawable.ulysses1,"Ulysses"));
        return  modelItems;
    }
}
