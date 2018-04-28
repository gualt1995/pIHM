package com.tndnc.freshfood.utils;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;

public class InfoListener implements View.OnClickListener { ;

    @Override
    public void onClick(View view) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setMessage(view.getContentDescription())
                .setTitle("This dish made with love may contain :")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).show();
    }
}
