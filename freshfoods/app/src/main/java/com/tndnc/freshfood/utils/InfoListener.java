package com.tndnc.freshfood.utils;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;

import com.tndnc.freshfood.R;
import com.tndnc.freshfood.views.MenuButtonView;

public class InfoListener implements View.OnClickListener { ;

    @Override
    public void onClick(View view) {
        MenuButtonView menuButtonView = (MenuButtonView) view;
        final AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext(), R.style.MyDialogTheme);
        builder.setMessage(view.getContentDescription())
                .setTitle(menuButtonView.getTitle())
                .setMessage(menuButtonView.getLongDes()+"\n\nIngredients : "+menuButtonView.getIngredients())
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).show();
    }
}
