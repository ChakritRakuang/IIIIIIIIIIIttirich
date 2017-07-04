package com.example.nilecon.ittirich.Fragment;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nilecon.ittirich.Custom.AbstractFragment;
import com.example.nilecon.ittirich.R;

/**
 * Created by nilecon on 9/30/16 AD.
 */
public class RecordFragment extends AbstractFragment {
    private RecyclerView recyclerViewRecord;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected int setContentView() {
        return R.layout.expend_page;
    }

    @Override
    protected void bindActionbar(ImageView menuLeft, ImageView menuRight, RelativeLayout bg, TextView txtLogo) {
        txtLogo.setText("รายจ่าย");
        bg.setBackgroundColor(Color.rgb(233, 157, 136));

    }

    @Override
    protected void BindUI(View v) {
        recyclerViewRecord = (RecyclerView) v.findViewById(R.id.recyclerExpense);
    }

    @Override
    protected void setupUI() {

    }
}
