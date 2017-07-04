package com.example.nilecon.ittirich.Fragment;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nilecon.ittirich.Adapter.MissionGridViewAdapter;
import com.example.nilecon.ittirich.Custom.AbstractFragment;
import com.example.nilecon.ittirich.Dialog.fullMissionDialog;
import com.example.nilecon.ittirich.Dialog.missionDialog;
import com.example.nilecon.ittirich.R;

/**
 * Created by nilecon on 9/27/16 AD.
 */
public class MissionFragment extends AbstractFragment {
    private TextView missionScore;
    private GridView gridViewMission;
    Activity activity;

    @Override
    protected int setContentView() {
        return R.layout.layout_mission;
    }

    @Override
    protected void bindActionbar(ImageView menuLeft, ImageView menuRight, RelativeLayout bg, TextView txtLogo) {
        txtLogo.setText("ภารกิจ");
        menuRight.setVisibility(View.VISIBLE);
    }

    @Override
    protected void BindUI(View v) {
        missionScore = (TextView) v.findViewById(R.id.mission_score);
        gridViewMission = (GridView) v.findViewById(R.id.missionGrid);


    }

    @Override
    protected void setupUI() {
        missionScore.setText("3 / 12");
        gridViewMission.setAdapter(new MissionGridViewAdapter(getActivity()));

        gridViewMission.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("click", String.valueOf(position));
                if (position == 0) {
                    fullMissionDialog fullMissionDialog = new fullMissionDialog(getActivity(), "1");
                    fullMissionDialog.show();
                } else if (position == 1) {
                    fullMissionDialog fullMissionDialog = new fullMissionDialog(getActivity(), "1");
                    fullMissionDialog.show();
                } else if (position == 2) {
                    missionDialog missionDialog = new missionDialog(getActivity());
                    missionDialog.show();
                } else if (position == 3) {
                    missionDialog missionDialog = new missionDialog(getActivity());
                    missionDialog.show();
                }
            }
        });
    }
}
