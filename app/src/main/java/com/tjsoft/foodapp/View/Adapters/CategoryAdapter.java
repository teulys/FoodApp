package com.tjsoft.foodapp.View.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tjsoft.foodapp.Model.Entities.Category;
import com.tjsoft.foodapp.R;

import java.util.List;

public class CategoryAdapter extends BaseAdapter {

    private List<Category> categoryList;


    public CategoryAdapter(List<Category> categories){
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
        return Integer.valueOf(categoryList.get(position).getIdCategory());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Category category = categoryList.get(position);

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, null);

        ImageView ivCategory = view.findViewById(R.id.ivCategory);
        TextView tvCategoryName = view.findViewById(R.id.tvCategoryName);

        tvCategoryName.setText(category.getStrCategory());

        Glide
            .with(parent.getContext())
            .load(category.getStrCategoryThumb())
            .fitCenter()
            .placeholder(R.mipmap.loading)
            .into(ivCategory);

        return view;
    }
}
