package com.example.nilecon.ittirich.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nilecon.ittirich.Acitivity.ExpendCalculatorActivity;
import com.example.nilecon.ittirich.Adapter.EditExpendAdapter;
import com.example.nilecon.ittirich.Adapter.IncomePageAdapter;
import com.example.nilecon.ittirich.Custom.AbstractFragment;
import com.example.nilecon.ittirich.R;

/**
 * Created by admin on 10/3/2016 AD.
 */

public class IncomeFragment extends AbstractFragment implements View.OnClickListener {

    private ImageButton btntoCalculator,btntoExpend;

    private RecyclerView recyclerincome;
    private IncomePageAdapter incomepageAdapter;

    @Override
    protected int setContentView() {
        return R.layout.income_page;
    }

    @Override
    protected void bindActionbar(ImageView menuLeft, ImageView menuRight, RelativeLayout bg, TextView txtLogo) {
        bg.setBackgroundColor(Color.rgb(97,181,88));
        txtLogo.setText(getString(R.string.income));
    }

    @Override
    protected void BindUI(View v) {
        recyclerincome = (RecyclerView) v.findViewById(R.id.recyclerIncome);

        btntoCalculator = (ImageButton) v.findViewById(R.id.btntoCalculator);
        btntoExpend = (ImageButton) v.findViewById(R.id.btntoExpend);
    }

    @Override
    protected void setupUI() {
        recyclerincome.setLayoutManager(new LinearLayoutManager(activity,
                LinearLayoutManager.VERTICAL,false));
        incomepageAdapter = new IncomePageAdapter(activity);
        recyclerincome.setAdapter(incomepageAdapter);

        btntoCalculator.setOnClickListener(this);
        btntoExpend.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        if(v==btntoCalculator){
            Intent intent = new Intent(getActivity(), ExpendCalculatorActivity.class);
            getActivity().startActivity(intent);
        } else if (v==btntoExpend) {
            replaceChlidFragment(new ExpendFragment(),null);
        }
    }
}
