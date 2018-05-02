package com.tndnc.freshfood.utils;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.tndnc.freshfood.R;
import com.tndnc.freshfood.activities.MenuSelectActivity;
import com.tndnc.freshfood.models.Cart;
import com.tndnc.freshfood.views.MenuButtonView;

public class AddListener implements View.OnClickListener {
    @Override
    public void onClick(final View view) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext(), R.style.MyDialogTheme);
        final EditText input = new EditText(view.getContext());
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        builder.setTitle("Any Special Request ?")
                .setView(input)
                .setPositiveButton(R.string.button_add, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Cart.add(((MenuButtonView)view).getItem(),input.getText().toString());
                        MenuSelectActivity menuSelectActivity = (MenuSelectActivity) view.getContext();
                        menuSelectActivity.updateCart();
                        dialogInterface.cancel();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .show();
    }
}
