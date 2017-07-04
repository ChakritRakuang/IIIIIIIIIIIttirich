package com.example.nilecon.ittirich.Acitivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nilecon.ittirich.Custom.AbstractActivity;
import com.example.nilecon.ittirich.R;

public class AddCategoriesIconActivity extends AbstractActivity implements View.OnClickListener{

    private ImageButton btntosubCate;

    @Override
    protected int setContentView() {
        return R.layout.add_catergories_icon;
    }

    @Override
    protected void bindActionbar(ImageView menuLeft, ImageView menuRight, RelativeLayout bg, TextView txtLogo) {
        txtLogo.setText(getString(R.string.editCategories));
        bg.setBackgroundColor(Color.rgb(96,96,96));
        menuLeft.setVisibility(View.VISIBLE);
    }

    @Override
    protected void BindUI() {
        btntosubCate = (ImageButton) findViewById(R.id.btntoSubCate);

    }

    @Override
    protected void setupUI() {
        btntosubCate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this,AddSubCategoriesIconActivity.class);
        startActivity(i);
    }
}