package com.example.nilecon.ittirich.Fragment;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nilecon.ittirich.Custom.AbstractFragment;
import com.example.nilecon.ittirich.R;

/**
 * Created by admin on 10/3/2016 AD.
 */

public class AddCategoriesFragment extends AbstractFragment implements View.OnClickListener{
    private ImageButton btntosub;
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
    protected void BindUI(View v) {
        btntosub = (ImageButton) v.findViewById(R.id.btntoSubCate);

    }

    @Override
    protected void setupUI() {
        btntosub.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==btntosub){
            replaceChlidFragment(new AddSubCategoriesFragment(),null);
        }
    }
}
