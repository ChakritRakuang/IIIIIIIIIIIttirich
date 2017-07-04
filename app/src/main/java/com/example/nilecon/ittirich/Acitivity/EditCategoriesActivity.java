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

import com.example.nilecon.ittirich.Adapter.IconBusinessAdapter;
import com.example.nilecon.ittirich.Adapter.IconInvestAdapter;
import com.example.nilecon.ittirich.Adapter.IconNeedAdapter;
import com.example.nilecon.ittirich.Adapter.IconSalaryAdapter;
import com.example.nilecon.ittirich.Adapter.IconUnneedAdapter;
import com.example.nilecon.ittirich.Custom.AbstractActivity;
import com.example.nilecon.ittirich.R;

public class EditCategoriesActivity extends AbstractActivity implements View.OnClickListener{

    private RecyclerView horizSalaryRV,horizBusinessRV, horizInvestRV, horizNeedExpendRV,
            horizUnneedExpendRV;
    private IconSalaryAdapter iconSalaryAdapter;
    private IconBusinessAdapter iconBusinessAdapter;
    private IconInvestAdapter iconInvestAdapter;
    private IconNeedAdapter iconNeedAdapter;
    private IconUnneedAdapter iconUnneedAdapter;
    private ImageButton btnaddsalary,btnaddbusiness,btnaddinvest,btnaddneed,btnaddunneed;

    @Override
    protected int setContentView() {
        return R.layout.edit_categories;
    }

    @Override
    protected void bindActionbar(ImageView menuLeft, ImageView menuRight, RelativeLayout bg, TextView txtLogo) {
        bg.setBackgroundColor(Color.rgb(105, 105, 105));
        txtLogo.setText("ตั้งค่าหมวดหมู่");
        menuLeft.setVisibility(View.VISIBLE);
    }

    @Override
    protected void BindUI() {
        horizSalaryRV = (RecyclerView) findViewById(R.id.horizSalaryRV);
        horizBusinessRV = (RecyclerView) findViewById(R.id.horizBusinessRV);
        horizInvestRV = (RecyclerView) findViewById(R.id.horizInvestRV);
        horizNeedExpendRV = (RecyclerView) findViewById(R.id.horizNeedExpendRV);
        horizUnneedExpendRV = (RecyclerView) findViewById(R.id.horizUnneedExpendRV);

        btnaddsalary = (ImageButton) findViewById(R.id.btnAddSalary);
        btnaddbusiness = (ImageButton) findViewById(R.id.btnAddBusiness);
        btnaddinvest = (ImageButton) findViewById(R.id.btnAddInvest);
        btnaddneed = (ImageButton) findViewById(R.id.btnAddNeed);
        btnaddunneed = (ImageButton) findViewById(R.id.btnAddUnneed);

    }

    @Override
    protected void setupUI() {
        horizSalaryRV.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager
                .HORIZONTAL,false));
        iconSalaryAdapter = new IconSalaryAdapter(activity);
        horizSalaryRV.setAdapter(iconSalaryAdapter);

        horizBusinessRV.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager
                .HORIZONTAL,false));
        iconBusinessAdapter = new IconBusinessAdapter(activity);
        horizBusinessRV.setAdapter(iconBusinessAdapter);

        horizInvestRV.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager
                .HORIZONTAL,false));
        iconInvestAdapter = new IconInvestAdapter(activity);
        horizInvestRV.setAdapter(iconInvestAdapter);

        horizNeedExpendRV.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager
                .HORIZONTAL,false));
        iconNeedAdapter = new IconNeedAdapter(activity);
        horizNeedExpendRV.setAdapter(iconNeedAdapter);

        horizUnneedExpendRV.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager
                .HORIZONTAL,false));
        iconUnneedAdapter = new IconUnneedAdapter(activity);
        horizUnneedExpendRV.setAdapter(iconUnneedAdapter);

        btnaddsalary.setOnClickListener(this);
        btnaddbusiness.setOnClickListener(this);
        btnaddinvest.setOnClickListener(this);
        btnaddneed.setOnClickListener(this);
        btnaddunneed.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnaddsalary) {
            Intent intent = new Intent(this, AddCategoriesIconActivity.class);
            this.startActivity(intent);
        }else if (v == btnaddbusiness) {
            Intent intent = new Intent(this, AddCategoriesIconActivity.class);
            this.startActivity(intent);
        }else if (v == btnaddinvest) {
            Intent intent = new Intent(this, AddCategoriesIconActivity.class);
            this.startActivity(intent);
        }else if (v == btnaddneed) {
            Intent intent = new Intent(this, AddCategoriesIconActivity.class);
            this.startActivity(intent);
        }else if (v == btnaddunneed) {
            Intent intent = new Intent(this, AddCategoriesIconActivity.class);
            this.startActivity(intent);
        }

    }
}