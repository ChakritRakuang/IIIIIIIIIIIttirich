package com.example.nilecon.ittirich.Dialog;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.example.nilecon.ittirich.R;

/**
 * Created by nilecon on 9/28/16 AD.
 */
public class fullMissionDialog extends Dialog implements View.OnClickListener {
    Activity activity;
    String data;
    ImageView closeBtn,btnOk;

    public fullMissionDialog(Activity activity, String data) {
        super(activity);
        this.activity = activity;
        this.data = data;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().getAttributes().gravity = Gravity.CENTER;
        getWindow().setBackgroundDrawable(
                new ColorDrawable(Color.TRANSPARENT));

        final View dialogview = activity.getLayoutInflater().inflate(
                R.layout.full_mission_dialog, null);
        setContentView(dialogview);
        getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        closeBtn = (ImageView) findViewById(R.id.closeBtn);
        btnOk =(ImageView)findViewById(R.id.btnOk);
        closeBtn.setOnClickListener(this);
        btnOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == closeBtn) {
            dismiss();
        }else if(v== btnOk){
            dismiss();
        }
    }
}
