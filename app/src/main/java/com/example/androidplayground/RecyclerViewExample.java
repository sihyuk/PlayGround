package com.example.androidplayground;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.androidplayground.Adapter.RecyclerAdapter;
import com.example.androidplayground.Model.ModelItem;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewExample extends AppCompatActivity {

    private int[] images = {R.drawable.angels_and_demon,R.drawable.game_of_thrones1,R.drawable.shadow_of_the_wind,
    R.drawable.song_of_solomon,R.drawable.the_name_of_the_wind,
    R.drawable.the_culling_trial,R.drawable.the_da_vinci_code,R.drawable.to_kill_a_mockingbird,
    R.drawable.ulysses1,R.drawable.war_and_peace};

    List<ModelItem> modelItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_example);
        RecyclerView recyclerView= findViewById(R.id.recyclerview);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this,getData());
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(recyclerAdapter);


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
