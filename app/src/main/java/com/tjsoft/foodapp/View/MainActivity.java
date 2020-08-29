package com.tjsoft.foodapp.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;

import com.tjsoft.foodapp.Model.Entities.Category;
import com.tjsoft.foodapp.R;
import com.tjsoft.foodapp.View.Adapters.CategoryAdapter;
import com.tjsoft.foodapp.ViewModel.CategoryViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private CategoryViewModel categoryViewModel;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gvCategory);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Category category = categoryViewModel.getCategoryList().getValue().get(position);

                Intent intent = new Intent(getApplicationContext(), ActivityMealList.class);
                intent.putExtra("categoryName", category.getStrCategory());
                startActivity(intent);
            }
        });

        progressBar = findViewById(R.id.pbCategory);

        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);

        categoryViewModel.getCategoryList().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                if (categories.size() > 0) {
                    progressBar.setVisibility(View.INVISIBLE);
                    CategoryAdapter adapter = new CategoryAdapter(categories);
                    gridView.setAdapter(adapter);
                }
            }
        });
    }
}
