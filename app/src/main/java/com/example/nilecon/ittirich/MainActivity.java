package com.example.nilecon.ittirich;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

        RoundCornerProgressBar progressbar1 = (RoundCornerProgressBar) findViewById(R.id.depositProgressbar);
        progressbar1.setProgressColor(Color.parseColor("#F88FAF"));
        progressbar1.setProgressBackgroundColor(Color.parseColor("#FFFFFF"));
        progressbar1.setMax(100);
        progressbar1.setProgress(100);
        int progressColor1 = progressbar1.getProgressColor();
        int backgroundColor1 = progressbar1.getProgressBackgroundColor();
        progressbar1.getMax();
        int progress1 = (int) progressbar1.getProgress();

        RoundCornerProgressBar progressbar2 = (RoundCornerProgressBar) findViewById(R.id.goalProgressbar);
        progressbar2.setProgressColor(Color.parseColor("#F88FAF"));
        progressbar2.setProgressBackgroundColor(Color.parseColor("#FFFFFF"));
        progressbar2.setMax(100);
        progressbar2.setProgress((float) 67.5);
        int progressColor2 = progressbar2.getProgressColor();
        int backgroundColor2 = progressbar2.getProgressBackgroundColor();
        int max2 = (int) progressbar2.getMax();
        int progress2 = (int) progressbar2.getProgress();

        RoundCornerProgressBar progressbar3 = (RoundCornerProgressBar) findViewById(R.id.budgetProgressbar);
        progressbar3.setProgressColor(Color.parseColor("#CB252D"));
        progressbar3.setProgressBackgroundColor(Color.parseColor("#FFFFFF"));
        progressbar3.setMax(100);
        progressbar3.setProgress(100);
        int progressColor3 = progressbar3.getProgressColor();
        int backgroundColor3 = progressbar3.getProgressBackgroundColor();
        int max3 = (int) progressbar3.getMax();
        int progress3 = (int) progressbar3.getProgress();
    }
}