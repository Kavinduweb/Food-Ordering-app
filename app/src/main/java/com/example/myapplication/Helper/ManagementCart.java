package com.example.myapplication.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.myapplication.Domain.FoodDomain;
import com.example.myapplication.Interface.ChangeNumberItemsListner;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertFood(FoodDomain item) {
        ArrayList<FoodDomain> listfood = getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < listfood.size(); i++) {
            if (listfood.get(i).getTitle().equals(item.getTitle())) {
                existAlready = true;
                n = i;
                break;
            }
        }
        if (existAlready) {
            listfood.get(n).setNumberInCard(item.getNumberInCard());
        } else {
            listfood.add(item);
        }
        tinyDB.putListObject("CartList", listfood);
        Toast.makeText(context, "Added To Your Cart", Toast.LENGTH_SHORT).show();

    }

    public ArrayList<FoodDomain> getListCart() {

        return tinyDB.getListObject("CartList");
    }

    public void plusNumberFood(ArrayList<FoodDomain> listfood, int position, ChangeNumberItemsListner changeNumberItemsListner) {
        listfood.get(position).setNumberInCard(listfood.get(position).getNumberInCard() + 1);
        tinyDB.putListObject("CartList", listfood);
        changeNumberItemsListner.changed();
    }

    public void MinusNumber(ArrayList<FoodDomain> listfood, int position, ChangeNumberItemsListner changeNumberItemsListner) {
        if (listfood.get(position).getNumberInCard() == 1) {
            listfood.remove(position);
        } else {
            listfood.get(position).setNumberInCard(listfood.get(position).getNumberInCard() - 1);
        }
        tinyDB.putListObject("CartList", listfood);
        changeNumberItemsListner.changed();
    };

    public Double getTotalFee(){
        ArrayList<FoodDomain> listFood2=getListCart();
        double fee=0;
        for (int i =0; i < listFood2.size(); i++) {
            fee=fee+(listFood2.get(i).getFee()*listFood2.get(i).getNumberInCard());
        }
        return fee;
    }
}

