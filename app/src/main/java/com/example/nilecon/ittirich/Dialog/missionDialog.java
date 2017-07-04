package com.example.nilecon.ittirich.Dialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.example.nilecon.ittirich.R;

public class missionDialog extends Dialog implements View.OnClickListener {

    private Activity activity;
    private ImageView btnClose, btnOk;

    public missionDialog(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().getAttributes().gravity = Gravity.CENTER;
        getWindow().setBackgroundDrawable(
                new ColorDrawable(Color.TRANSPARENT));

        @SuppressLint("InflateParams") final View dialogview = activity.getLayoutInflater().inflate(
                R.layout.layout_dialog_mission, null);
        setContentView(dialogview);
        getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        btnClose = (ImageView) findViewById(R.id.closeBtn);
        btnOk = (ImageView) findViewById(R.id.btnOk);
        btnClose.setOnClickListener(this);
        btnOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnClose) {
            dismiss();
        } else if (v == btnOk) {
            dismiss();
        }
    }
}