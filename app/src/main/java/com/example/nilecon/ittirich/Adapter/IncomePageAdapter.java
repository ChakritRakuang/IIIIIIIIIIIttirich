package com.example.nilecon.ittirich.Adapter;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nilecon.ittirich.R;

/**
 * Created by admin on 10/3/2016 AD.
 */

public class IncomePageAdapter extends RecyclerView.Adapter<IncomePageAdapter.ViewHolder> {

    public Activity activity;
    public IncomePageAdapter(Activity activity){
        this.activity=activity;
    }

    @Override
    public IncomePageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.income_row,parent,false);
        IncomePageAdapter.ViewHolder vh = new IncomePageAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(IncomePageAdapter.ViewHolder holder, int position) {
        if (position == 0 || position % 2 == 0) {
            holder.linerIncome.setBackgroundColor(Color.rgb(103,188,88));
        } else {
        }

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView incomeIcon;
        private TextView incomeDesc,incomeValue;
        private LinearLayout linerIncome;
        public ViewHolder(View itemView) {
            super(itemView);
            incomeIcon = (ImageView) itemView.findViewById(R.id.incomeIcon);
            incomeDesc = (TextView) itemView.findViewById(R.id.incomeDesc);
            incomeValue = (TextView) itemView.findViewById(R.id.incomeValue);
            linerIncome = (LinearLayout) itemView.findViewById(R.id.linerIncome);
        }
    }
}
