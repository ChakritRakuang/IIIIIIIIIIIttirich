package com.example.nilecon.ittirich.Fragment;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nilecon.ittirich.Acitivity.EditGoalActivity;
import com.example.nilecon.ittirich.Acitivity.ExpendCalculatorActivity;
import com.example.nilecon.ittirich.Adapter.EditExpendAdapter;
import com.example.nilecon.ittirich.Custom.AbstractFragment;
import com.example.nilecon.ittirich.R;

/**
 * Created by admin on 9/30/2016 AD.
 */

public class EditExpendFragment extends AbstractFragment implements View.OnClickListener {
    private RecyclerView rvEdit_expend_add_icon;
    private EditExpendAdapter editExpendAdapter;

    private LinearLayout lltoCalculator;

    @Override
    protected int setContentView() {
        return R.layout.edit_expend;
    }

    @Override
    protected void bindActionbar(ImageView menuLeft, ImageView menuRight, RelativeLayout bg, TextView txtLogo) {
        txtLogo.setText(getString(R.string.expendTitle));
        bg.setBackgroundColor(ContextCompat.getColor(activity, R.color.red1));
    }

    @Override
    protected void BindUI(View v) {
        rvEdit_expend_add_icon = (RecyclerView) v.findViewById(R.id.rvEdit_expend_add_icon);
        lltoCalculator = (LinearLayout) v.findViewById(R.id.lltoCalculator);
    }

    @Override
    protected void setupUI() {
        rvEdit_expend_add_icon.setLayoutManager(new LinearLayoutManager(activity,
                LinearLayoutManager.HORIZONTAL,false));
        editExpendAdapter = new EditExpendAdapter(activity);
        rvEdit_expend_add_icon.setAdapter(editExpendAdapter);

        lltoCalculator.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == lltoCalculator) {
            Intent intent = new Intent(getActivity(), ExpendCalculatorActivity.class);
            getActivity().startActivity(intent);
        }

    }
}
