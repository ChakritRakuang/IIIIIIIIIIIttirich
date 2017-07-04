package com.example.nilecon.ittirich.Acitivity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.example.nilecon.ittirich.Custom.AbstractActivity;
import com.example.nilecon.ittirich.R;


/**
 * Created by admin on 10/5/2016 AD.
 */
public class EditGoalActivity extends AbstractActivity implements View.OnClickListener{

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
    protected void BindUI() {

    }

    @Override
    protected void setupUI() {

    }

    @Override
    public void onClick(View v) {

    }
}
