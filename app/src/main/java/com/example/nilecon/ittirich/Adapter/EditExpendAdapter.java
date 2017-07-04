package com.example.nilecon.ittirich.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nilecon.ittirich.R;

/**
 * Created by admin on 9/30/2016 AD.
 */

public class EditExpendAdapter extends RecyclerView.Adapter<EditExpendAdapter.ViewHolder> {

    private Activity activity;
    public EditExpendAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public EditExpendAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.edit_categories_row, parent, false);
        EditExpendAdapter.ViewHolder vh = new EditExpendAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(EditExpendAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);

        }
    }
}

