package com.example.nilecon.ittirich.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nilecon.ittirich.R;

/**
 * Created by admin on 10/5/2016 AD.
 */

public class SubCategoriesAdapter extends RecyclerView.Adapter<SubCategoriesAdapter.ViewHolder> {
    private Activity activity;
    public SubCategoriesAdapter(Activity activity){this.activity=activity;}
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.sub_catergories_row,parent,
                false);
        SubCategoriesAdapter.ViewHolder vh = new SubCategoriesAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
