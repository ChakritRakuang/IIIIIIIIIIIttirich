package com.example.nilecon.ittirich;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.nilecon.ittirich.Fragment.ExpendFragment;
import com.example.nilecon.ittirich.Fragment.MissionFragment;
import com.example.nilecon.ittirich.Fragment.RecordFragment;
import com.example.nilecon.ittirich.Fragment.TotalResultFragment;
import com.example.nilecon.ittirich.Fragment.goalPage;

public class IttirichMainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView goal_tab, save_tab, mission_tab, final_tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ittirich_main);
        BindUI();
    }

    private void BindUI() {
        goal_tab = (ImageView) findViewById(R.id.goal_tab);
        save_tab = (ImageView) findViewById(R.id.save_tab);
        mission_tab = (ImageView) findViewById(R.id.mission_tab);
        final_tab = (ImageView) findViewById(R.id.result_tab);

        goal_tab.setOnClickListener(this);
        save_tab.setOnClickListener(this);
        mission_tab.setOnClickListener(this);
        final_tab.setOnClickListener(this);
        goal_tab.performClick();
    }

    @Override
    public void onClick(View v) {
        if (v == goal_tab) {
            goal_tab.setSelected(true);
            save_tab.setSelected(false);
            mission_tab.setSelected(false);
            final_tab.setSelected(false);
            switchContent(new goalPage());
        } else if (v == save_tab) {
            save_tab.setSelected(true);
            goal_tab.setSelected(false);
            mission_tab.setSelected(false);
            final_tab.setSelected(false);
            switchContent(new ExpendFragment());
        } else if (v == mission_tab) {
            mission_tab.setSelected(true);
            goal_tab.setSelected(false);
            save_tab.setSelected(false);
            final_tab.setSelected(false);
            switchContent(new MissionFragment());
        } else if (v == final_tab) {
            final_tab.setSelected(true);
            goal_tab.setSelected(false);
            save_tab.setSelected(false);
            mission_tab.setSelected(false);
            switchContent(new TotalResultFragment());
        }
    }

    private void switchContent(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        for (int i = 0; i < fm.getBackStackEntryCount(); i++) {
            fm.popBackStack();
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.tab_content_main, fragment).commit();
    }
}