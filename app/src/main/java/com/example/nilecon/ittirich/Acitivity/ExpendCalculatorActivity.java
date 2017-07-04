package com.example.nilecon.ittirich.Acitivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nilecon.ittirich.Adapter.EditExpendAdapter;
import com.example.nilecon.ittirich.Custom.AbstractActivity;
import com.example.nilecon.ittirich.R;

/**
 * Created by admin on 10/6/2016 AD.
 */

public class ExpendCalculatorActivity extends AbstractActivity implements View.OnClickListener{

    private RecyclerView rvEdit_expend_add_icon;
    private EditExpendAdapter editExpendAdapter;

    @Override
    protected int setContentView() {
        return R.layout.expend_calculator;
    }

    @Override
    protected void bindActionbar(ImageView menuLeft, ImageView menuRight, RelativeLayout bg, TextView txtLogo) {
        txtLogo.setText(getString(R.string.expendTitle));
        bg.setBackgroundColor(ContextCompat.getColor(activity, R.color.red1));
    }

    @Override
    protected void BindUI() {
        rvEdit_expend_add_icon = (RecyclerView) findViewById(R.id.rvEdit_expend_add_icon);

    }

    @Override
    protected void setupUI() {
        rvEdit_expend_add_icon.setLayoutManager(new LinearLayoutManager(activity
                ,LinearLayoutManager.HORIZONTAL,false));
        editExpendAdapter = new EditExpendAdapter(activity);
        rvEdit_expend_add_icon.setAdapter(editExpendAdapter);
    }

    @Override
    public void onClick(View v) {
    }
}