package com.example.nilecon.ittirich.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nilecon.ittirich.Acitivity.AddCategoriesIconActivity;
import com.example.nilecon.ittirich.Acitivity.ClockAlertActivity;
import com.example.nilecon.ittirich.Acitivity.EditCategoriesActivity;
import com.example.nilecon.ittirich.Acitivity.EditGoalActivity;
import com.example.nilecon.ittirich.Acitivity.VideoACtivity;
import com.example.nilecon.ittirich.Custom.AbstractFragment;
import com.example.nilecon.ittirich.R;

/**
 * Created by nilecon on 9/30/16 AD.
 */
public class SettingFragment extends AbstractFragment implements View.OnClickListener {
    private RelativeLayout ll_Alert, ll_AlertTime, ll_Category, ll_Quiz;
    private RelativeLayout ll_Video, ll_AboutUs;
    private ImageView ActiveBtn;

    @Override
    protected int setContentView() {
        return R.layout.layout_setting;
    }

    @Override
    protected void bindActionbar(ImageView menuLeft, ImageView menuRight, RelativeLayout bg, TextView txtLogo) {
       // bg.setBackgroundResource(R.drawable.img_iph_header2x);
        bg.setBackgroundColor(Color.rgb(105,105,105));
        txtLogo.setText("ตั้งค่าหมวดหมู่");
    }

    @Override
    protected void BindUI(View v) {
        ll_Alert = (RelativeLayout) v.findViewById(R.id.ll_Alert);
        ll_AlertTime = (RelativeLayout) v.findViewById(R.id.ll_AlertTime);
        ll_Category = (RelativeLayout) v.findViewById(R.id.ll_Category);
        ll_Quiz = (RelativeLayout) v.findViewById(R.id.ll_Quiz);
        ll_Video = (RelativeLayout) v.findViewById(R.id.ll_video);
        ll_AboutUs = (RelativeLayout) v.findViewById(R.id.ll_AboutUs);
        ActiveBtn = (ImageView) v.findViewById(R.id.activeBtn);
    }

    @Override
    protected void setupUI() {
        ll_Alert.setOnClickListener(this);
        ll_AlertTime.setOnClickListener(this);
        ll_Category.setOnClickListener(this);
        ll_Quiz.setOnClickListener(this);
        ll_Video.setOnClickListener(this);
        ll_AboutUs.setOnClickListener(this);
        ActiveBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == ll_Alert) {

        } else if (v == ll_AlertTime) {
            Intent intent = new Intent(getActivity(), ClockAlertActivity.class);
            getActivity().startActivity(intent);
        } else if (v == ll_Category) {
            Intent intent = new Intent(getActivity(), EditCategoriesActivity.class);
            getActivity().startActivity(intent);
        } else if (v == ll_Quiz) {
            replaceChlidFragment(new QuizFragment(), null);
        } else if (v == ll_Video) {
            Intent intent = new Intent(getActivity(), VideoACtivity.class);
            getActivity().startActivity(intent);
        } else if (v == ll_AboutUs) {
            replaceChlidFragment(new AboutUsFragment(), null);
        } else if (v == ActiveBtn) {
            ActiveBtn.setImageResource(R.drawable.img_iph_ico_slide_active2x);
        }
    }
}
