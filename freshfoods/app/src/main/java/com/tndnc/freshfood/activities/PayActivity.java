package com.tndnc.freshfood.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.tndnc.freshfood.R;
import com.tndnc.freshfood.models.Cart;

public class PayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
    }

    public void callWaiterToPay(View v){
        final Snackbar snackbar = Snackbar.make(findViewById(R.id.pay_layout), v == findViewById(R.id.paypal)? R.string.paypal_call : R.string.pay_call, Snackbar.LENGTH_LONG);
        snackbar.setAction("Ok", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snackbar.dismiss();
                finish();
            }
        });
        snackbar.show();
        Cart.reset();
    }
}
