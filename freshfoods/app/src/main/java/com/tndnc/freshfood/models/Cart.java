package com.tndnc.freshfood.models;

import java.util.ArrayList;
import com.tndnc.freshfood.activities.MenuSelectActivity;

public class Cart {
    private static volatile ArrayList<MenuItem> cart = null;
    private static double somme = 0;

    private Cart() {
        cart = new ArrayList<>();
    }

    public static void add(MenuItem i){
        if (cart == null) new Cart();
        cart.add(i);
        somme += Double.parseDouble(i.getPrice());
        printCart();
    }

    public static void initiate(){
        if (cart == null) new Cart();
    }


    public static void printCart(){
        if (cart == null) return;
        for(MenuItem i : cart)
            System.out.println(i.getName() + "\t" + i.getPrice());
        System.out.println("Total : "+somme);
    }


    public static int numberOfItem(){
        return cart.size();
    }
    /*
    This method is used by the waiter by giving a password in order to reset the table when there're new clients
     */
    public void reset(){
        cart = null;
        somme = 0;
    }
}
