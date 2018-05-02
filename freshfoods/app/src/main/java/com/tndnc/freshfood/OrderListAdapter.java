package com.tndnc.freshfood;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.ViewHolder> {
    private MenuApplication app;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView itemSizeView;
        RecyclerView itemListView;
        ViewHolder(CardView cardView, TextView itemSizeView, RecyclerView itemListView) {
            super(cardView);
            this.cardView = cardView;
            this.itemListView = itemListView;
            this.itemSizeView = itemSizeView;
        }
    }

    public OrderListAdapter(MenuApplication app) {
        this.app = app;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public OrderListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_list_card, parent, false);

        ConstraintLayout rootLayout = (ConstraintLayout) cardView.getChildAt(0);
        TextView itemSizeView = (TextView) rootLayout.getChildAt(0);
        RecyclerView itemListView = (RecyclerView) rootLayout.getChildAt(1);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(app);
        itemListView.setLayoutManager(mLayoutManager);

        return new ViewHolder(cardView, itemSizeView, itemListView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1,"Your Food");

        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        TextView t = holder.itemSizeView;
        // Number of agents starts at 3 and position at 0.
        int number_of_agent = position+1;
        t.setText(map.get(number_of_agent));

        holder.itemListView.setAdapter(app.getOrderItemListAdapter(position+1));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return 1;
    }
}
