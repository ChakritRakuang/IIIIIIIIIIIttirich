package com.example.nilecon.ittirich.Fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nilecon.ittirich.Custom.AbstractFragment;
import com.example.nilecon.ittirich.R;

public class AboutUsFragment extends AbstractFragment {
    @Override
    protected int setContentView() {
        return R.layout.layout_aboutus;
    }

    @Override
    protected void bindActionbar(ImageView menuLeft, ImageView menuRight, RelativeLayout bg, TextView txtLogo) {
        bg.setBackgroundResource(R.drawable.img_iph_header2x);
        txtLogo.setText("เกี่ยวกับเรา");
    }

    @Override
    protected void BindUI(View v) {

    }

    @Override
    protected void setupUI() {

    }
}