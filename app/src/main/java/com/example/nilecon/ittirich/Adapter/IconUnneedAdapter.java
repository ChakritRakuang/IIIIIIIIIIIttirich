package com.example.nilecon.ittirich.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nilecon.ittirich.R;


public class IconUnneedAdapter extends RecyclerView.Adapter<IconUnneedAdapter.ViewHolder> {
    private Context mContext;

    public IconUnneedAdapter(Context c) {
        mContext = c;
    }

    @Override
    public IconUnneedAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.edit_categories_row, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(IconUnneedAdapter.ViewHolder vh, int position) {
        // vh.imgProfile.setImageURI(Uri.parse(mBudgetRows.get(position).getImage()));
        if (position == 0) {
            vh.cateIcon.setImageResource(R.drawable.img_iph_ico_unactive_novital_movie2x);
            vh.cateTag.setText( "ดูหนัง");
        }
        //vh.linerBudget.setBackgroundColor(Integer.parseInt(mBudgetRows.get(position).getBGcolor()));
    }


    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView cateIcon;
        private TextView cateTag;

        public ViewHolder(View itemView) {
            super(itemView);
            cateIcon = (ImageView) itemView.findViewById(R.id.CateIcon);
            cateTag = (TextView) itemView.findViewById(R.id.CateTag);
        }
    }

}
