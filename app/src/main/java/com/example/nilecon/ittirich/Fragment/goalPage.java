package com.example.nilecon.ittirich.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.crashlytics.android.Crashlytics;
import com.example.nilecon.ittirich.Acitivity.BudgetActivity;
import com.example.nilecon.ittirich.Custom.AbstractFragment;
import com.example.nilecon.ittirich.Acitivity.EditGoalActivity;
import com.example.nilecon.ittirich.R;

import io.fabric.sdk.android.Fabric;

public class goalPage extends AbstractFragment implements View.OnClickListener {
    private RoundCornerProgressBar progressbar1;
    private RoundCornerProgressBar progressbar2;
    private RoundCornerProgressBar progressbar3;
    private ImageView editHouseBtn;

    @Override
    protected int setContentView() {
        return R.layout.goal_page;
    }

    @Override
    protected void bindActionbar(ImageView menuLeft, ImageView menuRight, RelativeLayout bg, TextView txtLogo) {
        txtLogo.setText("เป้าหมาย");
        menuRight.setVisibility(View.VISIBLE);
        bg.setBackgroundColor(Color.rgb(255, 105, 180));
    }

    @Override
    protected void BindUI(View v) {
        Fabric with = Fabric.with(getActivity(), new Crashlytics());
        /*Button btnDialog = (Button) findViewById(R.id.);*/
        progressbar1 = (RoundCornerProgressBar) v.findViewById(R.id
                .depositProgressbar);
        progressbar2 = (RoundCornerProgressBar) v.findViewById(R.id
                .goalProgressbar);
        progressbar3 = (RoundCornerProgressBar) v.findViewById(R.id
                .budgetProgressbar);
        editHouseBtn = (ImageView) v.findViewById(R.id.edithouseBtn);
        editHouseBtn.setOnClickListener(this);
        progressbar3.setOnClickListener(this);

    }

    @Override
    protected void setupUI() {

        //   hideActionBar();
        progressbar1.setProgressColor(Color.parseColor("#F88FAF"));
        progressbar1.setProgressBackgroundColor(Color.parseColor("#FFFFFF"));
        progressbar1.setMax(100);
        progressbar1.setProgress(100);

        progressbar2.setProgressColor(Color.parseColor("#F88FAF"));
        progressbar2.setProgressBackgroundColor(Color.parseColor("#FFFFFF"));
        progressbar2.setMax(100);
        progressbar2.setProgress((float) 67.5);

        progressbar3.setProgressColor(Color.parseColor("#CB252D"));
        progressbar3.setProgressBackgroundColor(Color.parseColor("#FFFFFF"));
        progressbar3.setMax(100);
        progressbar3.setProgress(100);
    }

    @Override
    public void onClick(View v) {
        if(v == editHouseBtn){
            /*replaceChlidFragment(new BudgetFragment(), null);*/
            Intent intent = new Intent(getActivity(), BudgetActivity.class);
            getActivity().startActivity(intent);
        }else if (v == progressbar3){
            /*replaceChlidFragment(new EditGoalFragment(),null);*/
            Intent intent = new Intent(getActivity(), EditGoalActivity.class);
            getActivity().startActivity(intent);
        }
    }
}

