package com.tjsoft.foodapp.Model.Entities;

import java.util.List;

public class MealCategory {
    private String strMeal;
    private String strMealThumb;
    private String idMeal;

    public MealCategory(String strMeal, String strMealThumb, String idMeal) {
        this.strMeal = strMeal;
        this.strMealThumb = strMealThumb;
        this.idMeal = idMeal;
    }

    public MealCategory() {
    }

    // Getter Methods

    public String getStrMeal() {
        return strMeal;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public String getIdMeal() {
        return idMeal;
    }

    // Setter Methods

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }

    public void setIdMeal(String idMeal) {
        this.idMeal = idMeal;
    }

    public class MealCategoryArray{
        private List<MealCategory> meals;

        public MealCategoryArray(List<MealCategory> meals) {
            this.meals = meals;
        }

        public MealCategoryArray() {
        }

        public List<MealCategory> getMeals() {
            return meals;
        }

        public void setMeals(List<MealCategory> meals) {
            this.meals = meals;
        }
    }

}
