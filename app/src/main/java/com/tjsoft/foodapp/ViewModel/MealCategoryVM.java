package com.tjsoft.foodapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.tjsoft.foodapp.Model.Dao.MealCategoryDao;
import com.tjsoft.foodapp.Model.Entities.MealCategory;

import java.util.ArrayList;
import java.util.List;

public class MealCategoryVM extends AndroidViewModel {

    private MutableLiveData<List<MealCategory>> mealCategoryList;

    public MealCategoryVM(@NonNull Application application) {
        super(application);
        mealCategoryList = new MutableLiveData<>();
        mealCategoryList.setValue(new ArrayList<MealCategory>());
    }

    public MutableLiveData<List<MealCategory>> getMealCategoryList(String categoryName) {
        MealCategoryDao dao = new MealCategoryDao(mealCategoryList,categoryName);
        return mealCategoryList;
    }
}
