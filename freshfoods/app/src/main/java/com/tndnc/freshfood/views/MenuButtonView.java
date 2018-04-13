package com.tndnc.freshfood.views;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.View;

import com.tndnc.freshfood.models.MenuItem;


public class MenuButtonView extends AppCompatButton {

    private MenuItem l;

    public MenuButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                Context ctx = view.getContext();
                while (ctx instanceof ContextWrapper) {
                    if (ctx instanceof Activity) {
                        break;
                    }
                    ctx = ((ContextWrapper)ctx).getBaseContext();
                }
            }
        });
    }

    public void setItem(MenuItem l) {
        this.l = l;
    }

}
