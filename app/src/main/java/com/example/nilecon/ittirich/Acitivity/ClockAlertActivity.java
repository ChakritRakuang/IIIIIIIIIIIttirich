package com.example.nilecon.ittirich.Acitivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.nilecon.ittirich.Custom.AbstractActivity;
import com.example.nilecon.ittirich.R;

/**
 * Created by admin on 10/6/2016 AD.
 */

public class ClockAlertActivity extends AbstractActivity implements View.OnClickListener{

    private TimePicker timePicker;

    @Override
    protected int setContentView() {
        return R.layout.clock_alert;
    }

    @Override
    protected void bindActionbar(ImageView menuLeft, ImageView menuRight, RelativeLayout bg, TextView txtLogo) {
        txtLogo.setText("ตั้งเวลาแจ้งเตือน");
        bg.setBackgroundColor(Color.rgb(238,157,70));
        menuLeft.setVisibility(View.VISIBLE);
    }

    @Override
    protected void BindUI() {
        timePicker = (TimePicker) findViewById(R.id.timepicker);

    }

    @Override
    protected void setupUI() {
        timePicker.setIs24HourView(true);
    }

    @Override
    public void onClick(View v) {

    }
}
