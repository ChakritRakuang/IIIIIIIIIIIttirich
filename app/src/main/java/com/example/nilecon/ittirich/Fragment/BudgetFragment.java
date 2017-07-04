package com.example.nilecon.ittirich.Fragment;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nilecon.ittirich.Adapter.NeedBudgetAdapter;
import com.example.nilecon.ittirich.Adapter.UnneedBudgetAdapter;
import com.example.nilecon.ittirich.Custom.AbstractFragment;
import com.example.nilecon.ittirich.R;


public class BudgetFragment extends AbstractFragment {

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
    protected void BindUI(View v) {
        NeedBudget = (RecyclerView) v.findViewById(R.id.recyclerNeedBudget);
        Unneedbudget = (RecyclerView) v.findViewById(R.id.recyclerUnneedBudget);
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
}
