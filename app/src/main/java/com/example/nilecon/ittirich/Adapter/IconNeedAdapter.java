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


public class IconNeedAdapter extends RecyclerView.Adapter<IconNeedAdapter.ViewHolder> {
    private Context mContext;

    public IconNeedAdapter(Context c) {
        mContext = c;
    }

    @Override
    public IconNeedAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.edit_categories_row, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(IconNeedAdapter.ViewHolder vh, int position) {
        // vh.imgProfile.setImageURI(Uri.parse(mBudgetRows.get(position).getImage()));
        if (position == 0) {
            vh.cateIcon.setImageResource(R.drawable.img_iph_ico_unactive_cost_vital_curr2x);
            vh.cateTag.setText("อาหาร");
        }else if(position ==1){
            vh.cateIcon.setImageResource(R.drawable.img_iph_ico_unactive_cost_vital_water2x);
            vh.cateTag.setText("สาธารณูปโภค");
        }else if(position ==2){
            vh.cateIcon.setImageResource(R.drawable.img_iph_ico_unactive_cost_vital_bus2x);
            vh.cateTag.setText("เดินทาง");
        }else if(position ==3){
            vh.cateIcon.setImageResource(R.drawable.img_iph_ico_unactive_cost_vital_insure2x);
            vh.cateTag.setText("ข็อปปิ้ง");
        }
        //vh.linerBudget.setBackgroundColor(Integer.parseInt(mBudgetRows.get(position).getBGcolor()));
    }


    @Override
    public int getItemCount() {
        return 4;
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
