package com.example.nilecon.ittirich.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.nilecon.ittirich.R;

/**
 * Created by nilecon on 9/27/16 AD.
 */
public class MissionGridViewAdapter extends BaseAdapter {
    private Context mContext;

    public MissionGridViewAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return mMissionImg.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;
        ImageView imageView;
        if (convertView == null) {
            gridView = new View(mContext);
            gridView = inflater.inflate(R.layout.layout_grid_item, null);
            imageView = (ImageView) gridView
                    .findViewById(R.id.itemGrid);
            imageView.setImageResource(mMissionImg[position]);

        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }

    private Integer[] mMissionImg = {
            R.drawable.img_iph_mainmission_character_1_2x, R.drawable.img_iph_mainmission_mission_default_2x,
            R.drawable.img_iph_mainmission_character_4_2x, R.drawable.img_iph_mainmission_mission_default_2x,
            R.drawable.img_iph_mainmission_mission_default_2x, R.drawable.img_iph_mainmission_mission_default_2x,
            R.drawable.img_iph_mainmission_character_3_2x, R.drawable.img_iph_mainmission_mission_default_2x,
            R.drawable.img_iph_mainmission_character_2_2x, R.drawable.img_iph_mainmission_mission_default_2x,
            R.drawable.img_iph_mainmission_mission_default_2x, R.drawable.img_iph_mainmission_mission_default_2x,
            R.drawable.img_iph_mainmission_mission_default_2x, R.drawable.img_iph_mainmission_mission_default_2x,
            R.drawable.img_iph_mainmission_mission_default_2x
    };
}
