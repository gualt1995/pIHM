package com.tndnc.freshfood.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private static volatile Map<MenuItem,String> cart = null;
    private static double somme = 0;

    private Cart() {
        cart = new HashMap<>();
    }

    public static void add(MenuItem i,String s){
        if (cart == null) new Cart();
        cart.put(i,s);
        somme += Double.parseDouble(i.getPrice());
    }

    public static void remove(MenuItem i){
        somme -= Double.parseDouble(i.getPrice());
        cart.remove(i);
    }


    public static void initiate(){
        if (cart == null) new Cart();
    }

    public static String getDecription(MenuItem i){
        return cart.get(i);
    }

    /*public static void printCart(){
        if (cart == null) return;
        for(MenuItem i : cart)
            System.out.println(i.getName() + "\t" + i.getPrice());
        System.out.println("Total : "+somme);
    }*/


    public static int numberOfItem(){
        return cart.size();
    }

    public static List<MenuItem> getCart(){
        List<MenuItem> l = new ArrayList<>();
        l.addAll(cart.keySet());
        return l;
    }

    public static  double price(){
        return somme;
    }


    /*
    This method is used by the waiter by giving a password in order to reset the table when there're new clients
    public void reset(){
        cart = null;
        somme = 0;
    }*/
}
