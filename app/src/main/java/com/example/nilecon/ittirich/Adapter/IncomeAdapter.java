package com.example.nilecon.ittirich.Adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nilecon.ittirich.Custom.CustomColor;
import com.example.nilecon.ittirich.R;

/**
 * Created by nilecon on 9/29/16 AD.
 */
public class IncomeAdapter extends RecyclerView.Adapter<IncomeAdapter.ViewHolder> {
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.icome_item_recycler, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position == 0 || position % 2 == 0) {
            holder.llBackground.setBackgroundColor(Color.rgb(157, 200, 124));
        } else {
            //    holder.llBackground.setBackgroundColor();//Color.green(R.color.lightGreen)
        }
        holder.incomeType.setText("เงินเดือน");
        holder.incomePercent.setText("68%");
        holder.incomeValue.setText("225,770.88 THB");
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        private TextView incomeType, incomePercent, incomeValue;
        private LinearLayout llBackground;

        public ViewHolder(View v) {
            super(v);
            incomeType = (TextView) v.findViewById(R.id.incomeType);
            incomePercent = (TextView) v.findViewById(R.id.incomePercent);
            incomeValue = (TextView) v.findViewById(R.id.incomeValue);
            llBackground = (LinearLayout) v.findViewById(R.id.llBackground);
        }


    }
}
