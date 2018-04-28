package com.tndnc.freshfood;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.SparseArray;

import com.tndnc.freshfood.models.MenuItem;
import com.tndnc.freshfood.utils.MenuLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class MenuApplication extends Application {
    private String uniqueId;
    private SparseArray<List<MenuItem>> itemsBySize;
    private SparseArray<ItemListAdapter> cardAdapters;


    @Override
    public void onCreate() {
        super.onCreate();

        SharedPreferences userProfile = getSharedPreferences("user_profile", Context.MODE_PRIVATE);
        boolean userProfileSaved = userProfile.getBoolean("user_profile_saved", false);
        if (!userProfileSaved) {
            uniqueId = UUID.randomUUID().toString();
            SharedPreferences.Editor mEditor = userProfile.edit();
            mEditor.putString("uuid", uniqueId).apply();
        } else {
            uniqueId = userProfile.getString("uuid", "ANON");
        }

        // init itemsBySize container
        this.itemsBySize = new SparseArray<>();
        for (int i = 1; i <= 5; i++) {
            this.itemsBySize.put(i, new ArrayList<MenuItem>());
        }
        // load itemsBySize in container
        MenuLoader.loadAllMenu(this);
        // init list adapters for card views
        this.cardAdapters = new SparseArray<>();
        for (int i = 1; i <= 5; i++) {
            this.cardAdapters.put(i, new ItemListAdapter(this.getMenuBySize().get(i)));
        }
    }

    public String getUniqueId(){
        return uniqueId;
    }

    public SparseArray<List<MenuItem>> getMenuBySize() {
        return this.itemsBySize;
    }

    public ItemListAdapter getItemListAdapter(int numberOfAgents) {
        return this.cardAdapters.get(numberOfAgents);
    }
}