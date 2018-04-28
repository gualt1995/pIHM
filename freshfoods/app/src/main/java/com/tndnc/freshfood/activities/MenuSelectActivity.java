package com.tndnc.freshfood.activities;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tndnc.freshfood.CardListAdapter;
import com.tndnc.freshfood.MenuApplication;
import com.tndnc.freshfood.R;

public class MenuSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_select);

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
        RecyclerView.Adapter mAdapter = new CardListAdapter(
                (MenuApplication) this.getApplication());
        mRecyclerView.setAdapter(mAdapter);
    }
}
