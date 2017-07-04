package com.example.nilecon.ittirich.Fragment;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nilecon.ittirich.Custom.AbstractFragment;
import com.example.nilecon.ittirich.R;

/**
 * Created by admin on 10/3/2016 AD.
 */

public class EditGoalFragment extends AbstractFragment implements View.OnClickListener  {

    @Override
    protected int setContentView() {
        return R.layout.edit_goal;
    }

    @Override
    protected void bindActionbar(ImageView menuLeft, ImageView menuRight, RelativeLayout bg, TextView txtLogo) {
        bg.setBackgroundColor(Color.rgb(235,137,166));
        txtLogo.setText("เป้าหมาย");
        menuRight.setVisibility(View.VISIBLE);
        menuLeft.setVisibility(View.VISIBLE);
    }

    @Override
    protected void BindUI(View v) {

    }

    @Override
    protected void setupUI() {

    }

    @Override
    public void onClick(View v) {

    }

}
