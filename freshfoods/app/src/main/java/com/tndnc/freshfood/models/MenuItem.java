package com.tndnc.freshfood.models;

public class MenuItem {

    private String name;
    private int size;
    private MenuItem nextMenuItem;
    private String price;
    private String shortdes;
    private String longdes;
    private String contain;

    public MenuItem(String name, int size, String price, String shortdes, String contain,String longdes) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.shortdes = shortdes;
        this.contain = contain;
        this.longdes =longdes;
    }

    public void setNextMenuItem(MenuItem l) {
        this.nextMenuItem = l;
    }

    public String getShortdes(){return this.shortdes;}

    public String getPrice(){return  this.price;}

    public MenuItem getNextMenuItem() {
        return this.nextMenuItem;
    }

    public String getName() {
        return name;
    }

    public String getContain() {return contain;}

    public int getSize() {
        return size;
    }

    public String getLongdes() {
        return longdes;
    }

    @Override
    public String toString() {
        return "[" + this.name + "/" + this.size + "]";
    }
}
