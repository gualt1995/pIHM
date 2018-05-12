package com.tndnc.freshfood.activities;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.tndnc.freshfood.OrderListAdapter;
import com.tndnc.freshfood.MenuApplication;
import com.tndnc.freshfood.R;
import com.tndnc.freshfood.models.Cart;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        RecyclerView mRecyclerView = findViewById(R.id.level_card_list);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

//        LinearSnapHelper snapHelper = new LinearSnapHelper();

//        snapHelper.attachToRecyclerView(mRecyclerView);
        // specify an adapter (see also next example)
        RecyclerView.Adapter mAdapter = new OrderListAdapter(
                (MenuApplication) this.getApplication());
        mRecyclerView.setAdapter(mAdapter);

        TextView ordertext = findViewById(R.id.textView2);
        Cart.initiate();
        String str = "Items in cart : " + String.valueOf(Cart.numberOfItem())+"\n"+"Your total is : "+ Cart.price()+" $";
        ordertext.setText(str);
    }


    public void updateCart(){
        RecyclerView mRecyclerView = findViewById(R.id.level_card_list);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        RecyclerView.Adapter mAdapter = new OrderListAdapter(
                (MenuApplication) this.getApplication());
        mRecyclerView.setAdapter(mAdapter);

        TextView ordertext = findViewById(R.id.textView2);
        String str = "Items in cart : " + String.valueOf(Cart.numberOfItem())+"\n"+"Your total is : "+ Cart.price()+" $";
        ordertext.setText(str);
    }

    public void pay(View view) {
        if(Cart.numberOfItem() == 0){
            final Snackbar snackbar = Snackbar.make(findViewById(R.id.cart_layout),"Your Cart is empty !", Snackbar.LENGTH_LONG);
            snackbar.setAction("Ok", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    snackbar.dismiss();
                    finish();
                }
            });
            snackbar.show();
        }else{
            Intent intent = new Intent(this, PayActivity.class);
            startActivity(intent);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        updateCart();
    }
}
