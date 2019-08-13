package com.example.androidplayground.Adapter;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.androidplayground.Model.ModelItem;
import com.example.androidplayground.R;

import java.util.List;

public class SliderAdapter extends PagerAdapter {
   Context context;
    private List<ModelItem> modelItems;

   public SliderAdapter(Context context, List<ModelItem> modelItems){
       this.context = context;
       this.modelItems = modelItems;
   }


    @Override
    public int getCount() {
        return modelItems.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView imageView = view.findViewById(R.id.obimageView);
        TextView tvtitle = view.findViewById(R.id.tvtitle);
        TextView tvauthor = view.findViewById(R.id.tvauthor);

        imageView.setImageResource(modelItems.get(position).getImageResources());
        tvtitle.setText(modelItems.get(position).getTitle());

        container.addView(view);
        return  view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
