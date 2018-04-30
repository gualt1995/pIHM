package com.tndnc.freshfood.views;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.View;

import com.tndnc.freshfood.models.MenuItem;


public class MenuButtonView extends AppCompatButton {

    private MenuItem l;
    private String title;
    private String longDes;
    private String ingredients;

    public MenuButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setItem(MenuItem l) {
        this.l = l;
    }

    public MenuItem getItem(){ return l; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLongDes() {
        return longDes;
    }

    public void setLongDes(String longDes) {
        this.longDes = longDes;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
