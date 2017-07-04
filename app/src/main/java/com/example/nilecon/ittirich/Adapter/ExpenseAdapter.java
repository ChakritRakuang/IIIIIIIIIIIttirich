package com.example.nilecon.ittirich.Adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nilecon.ittirich.R;

/**
 * Created by nilecon on 9/29/16 AD.
 */
public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ViewHolder> {
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.expense_item_recycler, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position == 0 || position % 2 == 0) {
            holder.llBackground.setBackgroundColor(Color.rgb(233, 166, 167));
        } else {
        }
        holder.expenseType.setText("ค่าอาหาร");
        holder.expensePercent.setText("38%");
        holder.expenseValue.setText("225,770.88 THB");
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        private TextView expenseType, expensePercent, expenseValue;
        private LinearLayout llBackground;

        public ViewHolder(View v) {
            super(v);
            expenseType = (TextView) v.findViewById(R.id.expenseType);
            expensePercent = (TextView) v.findViewById(R.id.expensePercent);
            expenseValue = (TextView) v.findViewById(R.id.expenseValue);
            llBackground = (LinearLayout) v.findViewById(R.id.llBackground);
        }


    }
}
