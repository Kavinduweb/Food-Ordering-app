package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.CategoryAdapter;
import com.example.myapplication.Adapter.PopularAdapter;
import com.example.myapplication.Domain.CategoryDomain;
import com.example.myapplication.Domain.FoodDomain;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewCategoryList,recyclerViewPopularlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();
    }

    private void bottomNavigation() {
        FloatingActionButton floatingActionButton=findViewById(R.id.cart_btn);
        LinearLayout homeBtn=findViewById(R.id.homeBtn);

        LinearLayout requestBtn=findViewById(R.id.requestBtn);
        LinearLayout feedbackbtn1=findViewById(R.id.feedbackbtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, com.example.myapplication.CartListActivity.class));
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });



        requestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RequestMainActivity.class));
            }
        });
        feedbackbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,FeedbackMainActivity.class));
            }
        });
    }

    private void recyclerViewPopular() {

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularlist=findViewById(R.id.recyclerView2);
        recyclerViewPopularlist.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodlist = new ArrayList<>();
        foodlist.add(new FoodDomain("Pepperoni Pizza","pizza1","Slices Pepporoni, Mozzerella Cheese, Fresh Oregano, Ground Black Pepper, Pizza Sause",890.26));
        foodlist.add(new FoodDomain("Cheese Burger","burger","Beef, Gouda Cheese, Special Sauce, Lettuce, Tomato",480.52));
        foodlist.add(new FoodDomain("Vegetable Pizza","pizza2","Olive Oil, Vegetable Oil, Pitted Kalamata, Cherry Tomatoes, Fresh Oregano, Basil",650.42));

        foodlist.add(new FoodDomain("Sausage HotDog","hotdog1","Sausage Made From Pork, Beef, Chicken, Turkey or Combinations Thereof and a Bun",890.26));
        foodlist.add(new FoodDomain("Soft Drinks","sdrink1","Carbonated Water, High Fructose Corn Syrup (Sugar), Caramel Color, Caffeine, Natural Flavors",380.52));
        foodlist.add(new FoodDomain("Creamy Doughnut","doughnut1","Milk, Eggs, Vanila, Dry Yeast, Hot Water",250.42));

        adapter2 = new PopularAdapter(foodlist);
        recyclerViewPopularlist.setAdapter(adapter2);
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList=findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList=new ArrayList<>();
        categoryList.add(new CategoryDomain("Pizza","cat_1"));
        categoryList.add(new CategoryDomain("Burger","cat_2"));
        categoryList.add(new CategoryDomain("Hotdog","cat_3"));
        categoryList.add(new CategoryDomain("Drink","cat_4"));
        categoryList.add(new CategoryDomain("Doughnut","cat_5"));

        adapter=new CategoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(adapter);
        }
}