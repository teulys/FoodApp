package com.tjsoft.foodapp.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.ListView;

import com.tjsoft.foodapp.Model.Entities.MealCategory;
import com.tjsoft.foodapp.R;
import com.tjsoft.foodapp.View.Adapters.MealAdapter;
import com.tjsoft.foodapp.ViewModel.CategoryViewModel;
import com.tjsoft.foodapp.ViewModel.MealCategoryVM;

import java.util.List;

public class ActivityMealList extends AppCompatActivity {

    private ListView listView;
    private MealCategoryVM viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_list);

        String categoryName = getIntent().getStringExtra("categoryName");

        listView = findViewById(R.id.lvMeals);

        viewModel = ViewModelProviders.of(this).get(MealCategoryVM.class);

        viewModel.getMealCategoryList(categoryName).observe(this, new Observer<List<MealCategory>>() {
            @Override
            public void onChanged(List<MealCategory> mealCategories) {
                MealAdapter mealAdapter = new MealAdapter(mealCategories);
                listView.setAdapter(mealAdapter);
            }
        });
    }
}
