package com.example.nilecon.ittirich.Fragment;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nilecon.ittirich.Acitivity.EditExpendActivity;
import com.example.nilecon.ittirich.Acitivity.EditGoalActivity;
import com.example.nilecon.ittirich.Adapter.EditExpendAdapter;
import com.example.nilecon.ittirich.Adapter.ExpendAdapter;
import com.example.nilecon.ittirich.Custom.AbstractFragment;
import com.example.nilecon.ittirich.R;

/**
 * Created by admin on 9/30/2016 AD.
 */

public class ExpendFragment extends AbstractFragment implements View.OnClickListener {
    private RecyclerView recyclerExpense;
    private ExpendAdapter expendAdapter;
    private ImageButton btnAddExpend,BtnIncome;
    @Override
    protected int setContentView() {
        return R.layout.expend_page;
    }

    @Override
    protected void bindActionbar(ImageView menuLeft, ImageView menuRight, RelativeLayout bg, TextView txtLogo) {
        txtLogo.setText(getString(R.string.expendTitle));
        bg.setBackgroundColor(ContextCompat.getColor(activity, R.color.red1));
    }

    @Override
    protected void BindUI(View v) {
        recyclerExpense = (RecyclerView) v.findViewById(R.id.recyclerExpense);
        btnAddExpend = (ImageButton) v.findViewById(R.id.btnAddExpend);
        BtnIncome = (ImageButton) v.findViewById(R.id.BtnIncome);
    }

    @Override
    protected void setupUI() {
        recyclerExpense.setLayoutManager(new LinearLayoutManager(activity));
        expendAdapter = new ExpendAdapter(activity);
        recyclerExpense.setAdapter(expendAdapter);

        btnAddExpend.setOnClickListener(this);
        BtnIncome.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==btnAddExpend)
        {Intent intent = new Intent(getActivity(), EditExpendActivity.class);
            getActivity().startActivity(intent);
        } else if (v==BtnIncome) {
            replaceChlidFragment(new IncomeFragment(),null);

        }
    }
}
