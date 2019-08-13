package com.example.androidplayground.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidplayground.DisplayActivity;
import com.example.androidplayground.Model.ModelItem;
import com.example.androidplayground.R;

import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private final Context context;
    private List<ModelItem> modelItems;
    int resource;
    String title;

    public RecyclerAdapter(Context context,List<ModelItem> modelItems){
        this.context = context;
        this.modelItems = modelItems;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler,parent,false);
        return new MyViewHolder(view,context);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        resource= modelItems.get(position).getImageResources();
        title = modelItems.get(position).getTitle();
       holder.bind(resource,title);
    }

    @Override
    public int getItemCount() {
        return modelItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView;
        Context context;

        public MyViewHolder(@NonNull View itemView,Context context) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivrecyclerView);
            textView = itemView.findViewById(R.id.tvrecyclerview);
            itemView.setOnClickListener(this);
            this.context = context;

        }
        public void bind(int resource,String item){

            imageView.setImageResource(resource);
            textView.setText(item);
        }
        public void onClick(View view){
            Intent intent = new Intent(context, DisplayActivity.class);
            intent.putExtra("image_id",modelItems.get(getAdapterPosition()).getImageResources());
            intent.putExtra("title",modelItems.get(getAdapterPosition()).getTitle());
            context.startActivity(intent);

        }

    }

}
