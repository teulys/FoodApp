package com.tjsoft.foodapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.tjsoft.foodapp.Model.Dao.CategoryDao;
import com.tjsoft.foodapp.Model.Entities.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryViewModel extends AndroidViewModel {

    private MutableLiveData<List<Category>> categoryList;

    public CategoryViewModel(@NonNull Application application) {
        super(application);
        categoryList = new MutableLiveData<>();
        categoryList.setValue(new ArrayList<Category>());
        CategoryDao dao = new CategoryDao(categoryList);
    }

    public LiveData<List<Category>> getCategoryList() {
        return categoryList;
    }
}
