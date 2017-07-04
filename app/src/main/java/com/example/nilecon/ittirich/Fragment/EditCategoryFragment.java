package com.example.nilecon.ittirich.Fragment;

import android.graphics.Color;
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
import com.example.nilecon.ittirich.Custom.AbstractFragment;
import com.example.nilecon.ittirich.R;

/**
 * Created by nilecon on 9/30/16 AD.
 */
public class EditCategoryFragment extends AbstractFragment implements View.OnClickListener {
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
    protected void BindUI(View v) {
        horizSalaryRV = (RecyclerView) v.findViewById(R.id.horizSalaryRV);
        horizBusinessRV = (RecyclerView) v.findViewById(R.id.horizBusinessRV);
        horizInvestRV = (RecyclerView) v.findViewById(R.id.horizInvestRV);
        horizNeedExpendRV = (RecyclerView) v.findViewById(R.id.horizNeedExpendRV);
        horizUnneedExpendRV = (RecyclerView) v.findViewById(R.id.horizUnneedExpendRV);

        btnaddsalary = (ImageButton) v.findViewById(R.id.btnAddSalary);
        btnaddbusiness = (ImageButton) v.findViewById(R.id.btnAddBusiness);
        btnaddinvest = (ImageButton) v.findViewById(R.id.btnAddInvest);
        btnaddneed = (ImageButton) v.findViewById(R.id.btnAddNeed);
        btnaddunneed = (ImageButton) v.findViewById(R.id.btnAddUnneed);
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
        if(v == btnaddsalary){
            replaceChlidFragment(new AddCategoriesFragment(),null);
        }else if(v == btnaddbusiness){
            replaceChlidFragment(new AddCategoriesFragment(),null);
        }else if(v == btnaddinvest){
            replaceChlidFragment(new AddCategoriesFragment(),null);
        }else if(v == btnaddneed){
            replaceChlidFragment(new AddCategoriesFragment(),null);
        }else if(v == btnaddunneed){
            replaceChlidFragment(new AddCategoriesFragment(),null);
        }

    }
}
