package com.tndnc.freshfood.utils;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.tndnc.freshfood.R;
import com.tndnc.freshfood.activities.CartActivity;
import com.tndnc.freshfood.activities.MenuSelectActivity;
import com.tndnc.freshfood.models.Cart;
import com.tndnc.freshfood.views.MenuButtonView;

public class RemoveListener implements View.OnClickListener {
    @Override
    public void onClick(final View view) {
        Cart.remove(((MenuButtonView)view).getItem());
        CartActivity cartActivity = (CartActivity) view.getContext();
        cartActivity.updateCart();

    }
}
