package com.example.nilecon.ittirich.Acitivity;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nilecon.ittirich.Adapter.SubCategoriesAdapter;
import com.example.nilecon.ittirich.Custom.AbstractActivity;
import com.example.nilecon.ittirich.R;

public class AddSubCategoriesIconActivity extends AbstractActivity implements View.OnClickListener{

    private RecyclerView subCate_iconRV;

    @Override
    protected int setContentView() {
        return R.layout.add_subcategories_icon;
    }

    @Override
    protected void bindActionbar(ImageView menuLeft, ImageView menuRight, RelativeLayout bg, TextView txtLogo) {
        txtLogo.setText(getString(R.string.editCategories));
        bg.setBackgroundColor(Color.rgb(96,96,96));
        menuLeft.setVisibility(View.VISIBLE);
    }

    @Override
    protected void BindUI() {
        subCate_iconRV = (RecyclerView) findViewById(R.id.subCate_iconRV);
    }

    @Override
    protected void setupUI() {
        subCate_iconRV.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager
                .VERTICAL,false));
        SubCategoriesAdapter subCategoriesAdapter = new SubCategoriesAdapter(activity);
        subCate_iconRV.setAdapter(subCategoriesAdapter);
    }

    @Override
    public void onClick(View v) {

    }
}