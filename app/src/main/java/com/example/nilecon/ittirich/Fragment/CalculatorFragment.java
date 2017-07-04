package com.example.nilecon.ittirich.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nilecon.ittirich.Adapter.EditExpendAdapter;
import com.example.nilecon.ittirich.Custom.AbstractFragment;
import com.example.nilecon.ittirich.R;
import com.felipecsl.asymmetricgridview.library.widget.AsymmetricGridView;

public class CalculatorFragment extends AbstractFragment {
    private RecyclerView rvEdit_expend_add_icon;

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
    protected void BindUI(View v) {
        rvEdit_expend_add_icon = (RecyclerView) v.findViewById(R.id.rvEdit_expend_add_icon);

    }

    @Override
    protected void setupUI() {
        rvEdit_expend_add_icon.setLayoutManager(new LinearLayoutManager(activity
                ,LinearLayoutManager.HORIZONTAL,false));
        EditExpendAdapter editExpendAdapter = new EditExpendAdapter(activity);
        rvEdit_expend_add_icon.setAdapter(editExpendAdapter);
    }
}