package com.tndnc.freshfood;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tndnc.freshfood.models.MenuItem;
import com.tndnc.freshfood.utils.OrderListener;
import com.tndnc.freshfood.views.MenuButtonView;
import com.tndnc.freshfood.utils.InfoListener;

import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ViewHolder> {

    private List<MenuItem> menuItems;
    private final View.OnClickListener infoListener = new InfoListener();
    private final View.OnClickListener orderListener = new OrderListener();

    static class ViewHolder extends RecyclerView.ViewHolder {
        MenuButtonView buttonInfoView,buttonOrderView;
        TextView FoodName, FoodDesc;
        ViewHolder(ConstraintLayout root, TextView l, MenuButtonView v, TextView lc, MenuButtonView v1) {
            super(root);
            FoodName = l;
            FoodDesc = lc;
            buttonInfoView = v;
            buttonOrderView = v1;
        }
    }

    ItemListAdapter(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ConstraintLayout rootLayout = (ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_item, parent, false);

        TextView foodName = (TextView) rootLayout.getChildAt(0);
        TextView foodDesc = (TextView) rootLayout.getChildAt(1);
        MenuButtonView buttonViewInfo = (MenuButtonView) rootLayout.getChildAt(2);
        MenuButtonView buttonViewOrder = (MenuButtonView) rootLayout.getChildAt(3);

        buttonViewInfo.setOnClickListener(infoListener);
        buttonViewOrder.setOnClickListener(orderListener);

        return new ViewHolder(rootLayout, foodName, buttonViewInfo, foodDesc,buttonViewOrder);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MenuItem l = this.menuItems.get(position);
        holder.buttonInfoView.setItem(l);
        String str = menuItems.get(position).getName() + " : $" + menuItems.get(position).getPrice() ;
        holder.FoodName.setText( str );
        holder.FoodDesc.setText(menuItems.get(position).getShortdes());
        holder.buttonInfoView.setTitle(menuItems.get(position).getName());
        holder.buttonInfoView.setLongDes(menuItems.get(position).getLongdes());
        holder.buttonInfoView.setIngredients(menuItems.get(position).getContain());
        holder.buttonOrderView.setItem(menuItems.get(position));
    }

    @Override
    public int getItemCount() {
        return this.menuItems.size();
    }
}
