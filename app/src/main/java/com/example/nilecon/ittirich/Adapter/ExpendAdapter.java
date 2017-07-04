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
 * Created by admin on 9/30/2016 AD.
 */

public class ExpendAdapter extends RecyclerView.Adapter<ExpendAdapter.ViewHolder>  {

    private Activity activity;
    public ExpendAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.expend_row, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position == 0 || position % 2 == 0) {
            holder.linerExpend.setBackgroundColor(Color.rgb(239,154,157));
        } else {
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView expendIcon;
        private TextView expendDesc,expendValue;
        private LinearLayout linerExpend;

        public ViewHolder(View itemView) {
            super(itemView);
            expendIcon = (ImageView) itemView.findViewById(R.id.expendIcon);
            expendDesc = (TextView) itemView.findViewById(R.id.expendDesc);
            expendValue = (TextView) itemView.findViewById(R.id.expendValue);
            linerExpend = (LinearLayout) itemView.findViewById(R.id.linerExpend);
        }
    }
}
