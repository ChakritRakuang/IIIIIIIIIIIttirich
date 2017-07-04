package com.example.nilecon.ittirich.Fragment;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.nilecon.ittirich.Custom.AbstractFragment;
import com.example.nilecon.ittirich.R;

/**
 * Created by admin on 10/3/2016 AD.
 */

public class ClockAlertFragment extends AbstractFragment{

    private TimePicker timePicker;
    @Override
    protected int setContentView() {
        return R.layout.clock_alert ;
    }

    @Override
    protected void bindActionbar(ImageView menuLeft, ImageView menuRight, RelativeLayout bg, TextView txtLogo) {
        txtLogo.setText("ตั้งเวลาแจ้งเตือน");
        bg.setBackgroundColor(Color.rgb(238,157,70));
        menuLeft.setVisibility(View.VISIBLE);
    }

    @Override
    protected void BindUI(View v) {
        timePicker = (TimePicker) v.findViewById(R.id.timepicker);
    }

    @Override
    protected void setupUI() {
        timePicker.setIs24HourView(true);
    }
}
