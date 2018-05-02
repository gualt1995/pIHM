package com.tndnc.freshfood;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tndnc.freshfood.models.Cart;
import com.tndnc.freshfood.models.MenuItem;
import com.tndnc.freshfood.utils.RemoveListener;
import com.tndnc.freshfood.views.MenuButtonView;

import java.util.List;

public class OrderItemListAdapter extends RecyclerView.Adapter<OrderItemListAdapter.ViewHolder> {

    private List<MenuItem> menuItems;
    private final View.OnClickListener RemoveListener = new RemoveListener();

    static class ViewHolder extends RecyclerView.ViewHolder {
        MenuButtonView buttonOrderView;
        TextView FoodName,FoodDesc;
        ViewHolder(ConstraintLayout root, TextView l,TextView lc, MenuButtonView v1) {
            super(root);
            FoodName = l;
            FoodDesc = lc;
            buttonOrderView = v1;
        }
    }

    OrderItemListAdapter(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ConstraintLayout rootLayout = (ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item, parent, false);

        TextView foodName = (TextView) rootLayout.getChildAt(0);
        TextView foodDesc = (TextView) rootLayout.getChildAt(1);
        MenuButtonView buttonViewOrder = (MenuButtonView) rootLayout.getChildAt(2);

        buttonViewOrder.setOnClickListener(RemoveListener);

        return new ViewHolder(rootLayout, foodName,foodDesc,buttonViewOrder);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MenuItem l = this.menuItems.get(position);
        String str = menuItems.get(position).getName() + " : $" + menuItems.get(position).getPrice() ;
        holder.FoodName.setText( str );
        str = Cart.getDecription(l);
        if (!str.equals("")) holder.FoodDesc.setText(str);

        holder.buttonOrderView.setItem(menuItems.get(position));
    }

    @Override
    public int getItemCount() {
        return this.menuItems.size();
    }
}
