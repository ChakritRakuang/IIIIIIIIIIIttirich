package com.example.nilecon.ittirich.Acitivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nilecon.ittirich.Adapter.NeedBudgetAdapter;
import com.example.nilecon.ittirich.Adapter.UnneedBudgetAdapter;
import com.example.nilecon.ittirich.Custom.AbstractActivity;
import com.example.nilecon.ittirich.R;

/**
 * Created by admin on 10/6/2016 AD.
 */

public class BudgetActivity extends AbstractActivity implements View.OnClickListener{

    private RecyclerView NeedBudget,Unneedbudget;
    private NeedBudgetAdapter needBudgetAdapter;
    private UnneedBudgetAdapter unneedBudgetAdapter;

    @Override
    protected int setContentView() {
        return R.layout.budget;
    }

    @Override
    protected void bindActionbar(ImageView menuLeft, ImageView menuRight, RelativeLayout bg, TextView txtLogo) {
        txtLogo.setText("งบใช้จ่าย");
        menuRight.setVisibility(View.VISIBLE);
        menuLeft.setVisibility(View.VISIBLE);
        bg.setBackgroundColor(Color.rgb(236,132,74));
    }

    @Override
    protected void BindUI() {
        NeedBudget = (RecyclerView) findViewById(R.id.recyclerNeedBudget);
        Unneedbudget = (RecyclerView) findViewById(R.id.recyclerUnneedBudget);

    }

    @Override
    protected void setupUI() {
        needBudgetAdapter = new NeedBudgetAdapter(activity);
        unneedBudgetAdapter = new UnneedBudgetAdapter(activity);

        NeedBudget.setLayoutManager(new LinearLayoutManager(activity));
        NeedBudget.setAdapter(needBudgetAdapter);

        Unneedbudget.setLayoutManager(new LinearLayoutManager(activity));
        Unneedbudget.setAdapter(unneedBudgetAdapter);
    }

    @Override
    public void onClick(View v) {
    }
}
