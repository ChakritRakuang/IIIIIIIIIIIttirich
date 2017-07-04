package com.example.nilecon.ittirich.Fragment;


import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nilecon.ittirich.Custom.AbstractFragment;
import com.example.nilecon.ittirich.R;

/**
 * Created by nilecon on 9/30/16 AD.
 */
public class QuizFragment extends AbstractFragment implements View.OnClickListener {
    private LinearLayout llNext;

    @Override
    protected int setContentView() {
        return R.layout.layout_quiz;
    }

    @Override
    protected void bindActionbar(ImageView menuLeft, ImageView menuRight, RelativeLayout bg, TextView txtLogo) {
        txtLogo.setText("แบบทดสอบ");
        //  bg.setBackgroundResource(R.drawable.img_iph_bg_blue2x);
        bg.setBackgroundColor(Color.GRAY);
        menuRight.setVisibility(View.VISIBLE);
    }

    @Override
    protected void BindUI(View v) {
        llNext = (LinearLayout) v.findViewById(R.id.ll_Next);
    }

    @Override
    protected void setupUI() {
        llNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        replaceChlidFragment(new TotalQuizFragment(), null);
    }
}
