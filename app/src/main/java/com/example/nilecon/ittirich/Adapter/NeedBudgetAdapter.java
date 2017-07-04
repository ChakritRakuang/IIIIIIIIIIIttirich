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



public class NeedBudgetAdapter extends RecyclerView.Adapter<NeedBudgetAdapter.ViewHolder> {
    private Context mContext;

    public NeedBudgetAdapter(Context c) {
        mContext = c;
    }

    @Override
    public NeedBudgetAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.budget_row, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(NeedBudgetAdapter.ViewHolder vh, int position) {
        // vh.imgProfile.setImageURI(Uri.parse(mBudgetRows.get(position).getImage()));
        if (position == 0) {
            vh.linerBudget.setBackgroundColor(Color.rgb(237,156,185));
            vh.imgProfile.setImageResource(R.drawable.img_iph_ico_menu12x);
            vh.textName.setText("เสื้อผ้า");
            vh.textDesc1.setText("งบคงเหลือ                             1,600THB");
            vh.textDesc2.setText("งบทั้งหมด                              2,000THB");
        } else if(position ==1){
            vh.linerBudget.setBackgroundColor(Color.rgb(153,198,85));
            vh.imgProfile.setImageResource(R.drawable.img_iph_ico_menu22x);
            vh.textName.setText("หนังสือ");
            vh.textDesc1.setText("งบคงเหลือ                             1,600THB");
            vh.textDesc2.setText("งบทั้งหมด                              2,000THB");
        }else if(position ==2){
            vh.linerBudget.setBackgroundColor(Color.rgb(236,132,74));
            vh.imgProfile.setImageResource(R.drawable.img_iph_ico_menu32x);
            vh.textName.setText("อุปกรณ์เครื่องเขียน");
            vh.textDesc1.setText("งบคงเหลือ                             1,600THB");
            vh.textDesc2.setText("งบทั้งหมด                              2,000THB");
        }
        //vh.linerBudget.setBackgroundColor(Integer.parseInt(mBudgetRows.get(position).getBGcolor()));
    }


    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgProfile;
        private TextView textName;
        private TextView textDesc1,textDesc2;
        private LinearLayout linerBudget;

        public ViewHolder(View itemView) {
            super(itemView);
            imgProfile = (ImageView) itemView.findViewById(R.id.imgProfile);
            textName = (TextView) itemView.findViewById(R.id.textName);
            textDesc1 = (TextView) itemView.findViewById(R.id.textDesc1);
            textDesc2 = (TextView) itemView.findViewById(R.id.textDesc2);
            linerBudget = (LinearLayout) itemView.findViewById(R.id.linerBudget);
        }
    }

}
