package com.tjsoft.foodapp.Model.Dao;

import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.tjsoft.foodapp.Model.Entities.Category;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class CategoryDao {

    private MutableLiveData<List<Category>> categoryList;

    public CategoryDao(MutableLiveData<List<Category>> categoryList){
        this.categoryList = categoryList;
        new JsonTak().execute("");
    }

    private class JsonTak extends AsyncTask<String, String, String>{

        private final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/categories.php";

        @Override
        protected String doInBackground(String... strings) {

            HttpURLConnection connection = null;
            BufferedReader reader = null;
            try {
                URL url = new URL(BASE_URL);

                connection = (HttpURLConnection) url.openConnection();

                InputStream inputStream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line = "";
                StringBuffer buffer = new StringBuffer();

                while ((line = reader.readLine()) != null){
                    buffer.append(line + "\n");
                }

                return buffer.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null){
                    connection.disconnect();
                }

                if (reader != null){
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Gson gson = new Gson();

            Category.CategoryArray categoryArray = gson.fromJson(result, Category.CategoryArray.class);
            categoryList.setValue(categoryArray.getCategories());
        }
    }

}
