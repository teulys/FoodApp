package com.tjsoft.foodapp.View.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tjsoft.foodapp.Model.Entities.Category;
import com.tjsoft.foodapp.Model.Entities.MealCategory;
import com.tjsoft.foodapp.R;

import java.util.List;

public class MealAdapter extends BaseAdapter {

    private List<MealCategory> categoryList;


    public MealAdapter(List<MealCategory> categories){
        this.categoryList = categories;
    }


    @Override
    public int getCount() {
        return categoryList.size();
    }

    @Override
    public Object getItem(int position) {
        return categoryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Integer.valueOf(categoryList.get(position).getIdMeal());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MealCategory category = categoryList.get(position);

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food, null);

        ImageView ivCategory = view.findViewById(R.id.ivFood);
        TextView tvFoodName = view.findViewById(R.id.tvFoodName);

        tvFoodName.setText(category.getStrMeal());

        Glide
                .with(parent.getContext())
                .load(category.getStrMealThumb())
                .fitCenter()
                .placeholder(R.mipmap.loading)
                .into(ivCategory);

        return view;
    }
}
