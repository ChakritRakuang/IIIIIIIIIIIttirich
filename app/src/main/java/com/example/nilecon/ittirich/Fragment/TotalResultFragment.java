package com.example.nilecon.ittirich.Fragment;

import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nilecon.ittirich.Adapter.ExpenseAdapter;
import com.example.nilecon.ittirich.Adapter.IncomeAdapter;
import com.example.nilecon.ittirich.Custom.AbstractFragment;
import com.example.nilecon.ittirich.Custom.DemoBase;
import com.example.nilecon.ittirich.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.AxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by nilecon on 9/28/16 AD.
 */
public class TotalResultFragment extends AbstractFragment implements OnChartValueSelectedListener {
    private CombinedChart combinedChart;
    private final int itemcount = 12;
    private String[] mMonths = new String[]{
            "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dec"
    };

    private String[] mParties = new String[]{
            "หัุนสามัญ", "ตราสารหนี้", "เงินเดือน", "กองทุน", "ขายเสื้อ", "Party F", "Party G", "Party H",
            "Party I", "Party J", "Party K", "Party L", "Party M", "Party N", "Party O", "Party P",
            "Party Q", "Party R", "Party S", "Party T", "Party U", "Party V", "Party W", "Party X",
            "Party Y", "Party Z"
    };
    private String[] dataExpense = new String[]{
            "ค่าสาธารณูปโภค", "ค่าอารหาร", "บันเทิง", "ท่องเที่ยว", "เสื้อผ้า"};
    //  private String[] mLabels = new String[] { "Company A", "Company B", "Company C", "Company D", "Company E", "Company F" };
    private String[] mLabels = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dec"};

    private String getLabel(int i) {
        return mLabels[i];
    }

    private PieChart pieChart, pieChartExpense;
    private RecyclerView incomeList;
    private IncomeAdapter incomeAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private RecyclerView expenseList;
    private ExpenseAdapter expenseAdapter;
    private RecyclerView.LayoutManager expenseLayoutManager;

    private BarChart barChartDeposit, multiBarchart;

    @Override
    protected int setContentView() {
        return R.layout.total_result;
    }

    @Override
    protected void bindActionbar(ImageView menuLeft, ImageView menuRight, RelativeLayout bg, TextView txtLogo) {
        txtLogo.setText("สรุปผล");
        menuRight.setVisibility(View.VISIBLE);
        menuRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceChlidFragment(new SettingFragment(), null);
            }
        });
    }

    @Override
    protected void BindUI(View v) {
        combinedChart = (CombinedChart) v.findViewById(R.id.barLineChart);
        pieChart = (PieChart) v.findViewById(R.id.pieChart);
        incomeList = (RecyclerView) v.findViewById(R.id.incomeRecycler);
        expenseList = (RecyclerView) v.findViewById(R.id.expanseRecycler);
        barChartDeposit = (BarChart) v.findViewById(R.id.barChartDeposit);
        multiBarchart = (BarChart) v.findViewById(R.id.barChartCompare);
        pieChartExpense = (PieChart) v.findViewById(R.id.pieChartExpense);
    }

    @Override
    protected void setupUI() {

        combinedChart.setDrawGridBackground(false);
        combinedChart.setDrawBarShadow(false);
        combinedChart.setHighlightFullBarEnabled(false);
        combinedChart.setDrawOrder(new CombinedChart.DrawOrder[]{
                CombinedChart.DrawOrder.BAR, CombinedChart.DrawOrder.LINE});

        Legend l = combinedChart.getLegend();
        l.setWordWrapEnabled(true);
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);

        YAxis rightAxis = combinedChart.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setAxisMinValue(0f);

        YAxis leftAxis = combinedChart.getAxisLeft();
        leftAxis.setDrawGridLines(false);
        leftAxis.setAxisMinValue(0f);


        XAxis xAxis = combinedChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);
        xAxis.setAxisMinValue(0f);
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(new AxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return mMonths[(int) value % mMonths.length];
            }

            @Override
            public int getDecimalDigits() {
                return 0;
            }
        });


        CombinedData data = new CombinedData();
        data.setData(generateLineData());
        data.setData(generateBarData());

        combinedChart.setData(data);
        combinedChart.invalidate();

        //** PieChart
        pieChart.setUsePercentValues(true);
        pieChart.setDescription("");
        pieChart.setCenterText(generateCenterText());
//        pieChart.drawableHotspotChanged(5, 19);
        pieChart.setDrawCenterText(false);

//        Paint piePaint = new Paint();
//        piePaint.setAntiAlias(true);
//        piePaint.setDither(true);
//        pieChart.setStyle(Paint.Style.FILL);

        pieChart.setHoleRadius(58f);
        pieChart.setTransparentCircleRadius(61f);

        Legend lPie = pieChart.getLegend();
        lPie.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        lPie.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        lPie.setOrientation(Legend.LegendOrientation.VERTICAL);
        lPie.setDrawInside(false);

        setData(5, 100);

        //*** RecyclerIncome
        incomeList.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        incomeList.setLayoutManager(layoutManager);

        incomeAdapter = new IncomeAdapter();
        incomeList.setAdapter(incomeAdapter);

        //*** RecyclerExpense
        expenseList.setHasFixedSize(true);
        expenseLayoutManager = new LinearLayoutManager(getActivity());
        expenseList.setLayoutManager(expenseLayoutManager);

        expenseAdapter = new ExpenseAdapter();
        expenseList.setAdapter(expenseAdapter);

        //** BarChartDeposit
        barChartDeposit.setDescription("");
        barChartDeposit.setMaxVisibleValueCount(60);
        // scaling can now only be done on x- and y-axis separately
        barChartDeposit.setPinchZoom(false);
        barChartDeposit.setDrawGridBackground(false);


        XAxis xAxisDeposit = barChartDeposit.getXAxis();
        xAxisDeposit.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxisDeposit.setDrawGridLines(false);
        xAxisDeposit.setGranularity(1f); // only intervals of 1 day
        xAxisDeposit.setLabelCount(7);
        xAxisDeposit.setValueFormatter(new AxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return mMonths[(int) value % mMonths.length];
            }

            @Override
            public int getDecimalDigits() {
                return 0;
            }
        });

        YAxis leftAxisDeposit = barChartDeposit.getAxisLeft();
        leftAxisDeposit.setAxisMinValue(0f); // this replaces setStartAtZero(true)

        barChartDeposit.getAxisRight().setEnabled(false);


        barChartDeposit.setFitBars(true);
        //barChartDeposit.setData(generateBarData(1, 20000, 5));
        setBarData(12, 50);
        // barChartDeposit.setData(setBarData(12, 50));

        //**MultiBarChart
        multiBarchart.setDescription("");
        multiBarchart.setPinchZoom(false);
        multiBarchart.setDrawGridBackground(false);
        XAxis xAxisCompare = multiBarchart.getXAxis();
        xAxisCompare.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxisCompare.setDrawGridLines(false);
        xAxisCompare.setGranularity(1f); // only intervals of 1 day
        xAxisCompare.setLabelCount(7);
        xAxisCompare.setValueFormatter(new AxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return mMonths[(int) value % mMonths.length];
            }

            @Override
            public int getDecimalDigits() {
                return 0;
            }
        });

        YAxis leftAxisCompare = multiBarchart.getAxisLeft();
        leftAxisCompare.setAxisMinValue(0f);
        setBarMultiData(100, 50);


        //** PieChartExpense
        pieChartExpense.setUsePercentValues(true);
        pieChartExpense.setDescription("");
        pieChartExpense.setCenterText(generateCenterText());
      //  pieChartExpense.drawableHotspotChanged(5, 19);
        pieChartExpense.setDrawCenterText(false);

//        Paint piePaint = new Paint();
//        piePaint.setAntiAlias(true);
//        piePaint.setDither(true);
//        pieChart.setStyle(Paint.Style.FILL);

        pieChartExpense.setHoleRadius(58f);
        pieChartExpense.setTransparentCircleRadius(61f);

        Legend lPieExpense = pieChartExpense.getLegend();
        lPie.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        lPie.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        lPie.setOrientation(Legend.LegendOrientation.VERTICAL);
        lPie.setDrawInside(false);

        setDataExpense(5, 100);

    }

    private SpannableString generateCenterText() {
        SpannableString s = new SpannableString("Revenues\nQuarters 2015");
        s.setSpan(new RelativeSizeSpan(2f), 0, 8, 0);
        s.setSpan(new ForegroundColorSpan(Color.GRAY), 8, s.length(), 0);
        return s;
    }

    private LineData generateLineData() {

        LineData d = new LineData();

        ArrayList<Entry> entries = new ArrayList<Entry>();

        for (int index = 0; index < itemcount; index++)
            entries.add(new Entry(index + 0.5f, getRandom(15, 5)));

        LineDataSet set = new LineDataSet(entries, "Line DataSet");
        set.setColor(Color.rgb(240, 238, 70));
        set.setLineWidth(2.5f);
        set.setCircleColor(Color.rgb(240, 238, 70));
        set.setCircleRadius(5f);
        set.setFillColor(Color.rgb(240, 238, 70));
        set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        set.setDrawValues(true);
        set.setValueTextSize(10f);
        set.setValueTextColor(Color.rgb(240, 238, 70));

        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        d.addDataSet(set);

        return d;
    }

    private BarData generateBarData() {

        ArrayList<BarEntry> entries1 = new ArrayList<BarEntry>();
        ArrayList<BarEntry> entries2 = new ArrayList<BarEntry>();

        for (int index = 0; index < itemcount; index++) {
            entries1.add(new BarEntry(0, getRandom(25, 25)));

            // stacked
            entries2.add(new BarEntry(0, new float[]{getRandom(13, 12), getRandom(13, 12)}));
        }

        BarDataSet set1 = new BarDataSet(entries1, "Bar 1");
        set1.setColor(Color.rgb(60, 220, 78));
        set1.setValueTextColor(Color.rgb(60, 220, 78));
        set1.setValueTextSize(10f);
        set1.setAxisDependency(YAxis.AxisDependency.LEFT);

        BarDataSet set2 = new BarDataSet(entries2, "");
        set2.setStackLabels(new String[]{"Stack 1", "Stack 2"});
        set2.setColors(new int[]{Color.rgb(61, 165, 255), Color.rgb(23, 197, 255)});
        set2.setValueTextColor(Color.rgb(61, 165, 255));
        set2.setValueTextSize(10f);
        set2.setAxisDependency(YAxis.AxisDependency.LEFT);

        float groupSpace = 0.06f;
        float barSpace = 0.02f; // x2 dataset
        float barWidth = 0.45f; // x2 dataset
        // (0.45 + 0.02) * 2 + 0.06 = 1.00 -> interval per "group"

        BarData d = new BarData(set1, set2);
        d.setBarWidth(barWidth);

        // make this BarData object grouped
        d.groupBars(0, groupSpace, barSpace); // start at x = 0

        return d;
    }

    private float getRandom(float range, float startsfrom) {
        return (float) (Math.random() * range) + startsfrom;
    }

    private void setData(int count, float range) {

        float mult = range;

        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (int i = 0; i < count; i++) {
            entries.add(new PieEntry((float) ((Math.random() * mult) + mult / 5), mParties[i % mParties.length]));
        }

        PieDataSet dataSet = new PieDataSet(entries, "");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);

        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<Integer>();

        colors.add(Color.rgb(98, 165, 179)); //old blue
        colors.add(Color.rgb(233, 158, 136)); //orut
        colors.add(Color.rgb(232, 205, 115)); //yellow
        colors.add(Color.rgb(126, 192, 165)); //blue
        colors.add(Color.rgb(244, 212, 170)); //light yellow

        dataSet.setColors(colors);
        dataSet.setSelectionShift(0f);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        pieChart.setData(data);


        // undo all highlights
        pieChart.highlightValues(null);

        pieChart.invalidate();
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }

    private BarData generateBarData(int dataSets, float range, int count) {

        ArrayList<IBarDataSet> sets = new ArrayList<IBarDataSet>();

        for (int i = 0; i < dataSets; i++) {

            ArrayList<BarEntry> entries = new ArrayList<BarEntry>();

            for (int j = 0; j < count; j++) {
                entries.add(new BarEntry(j, (float) (Math.random() * range) + range / 4));
            }

            BarDataSet ds = new BarDataSet(entries, getLabel(i));
            ds.setColors(ColorTemplate.MATERIAL_COLORS);//ColorTemplate.VORDIPLOM_COLORS
            sets.add(ds);
        }

        BarData d = new BarData(sets);
        return d;
    }

    private void setBarData(int count, float range) {

        float barWidth = 9f;
        float spaceForBar = 10f;
        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * range);
            yVals1.add(new BarEntry(i * spaceForBar, val));
        }

        BarDataSet set1;

        if (barChartDeposit.getData() != null &&
                barChartDeposit.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) barChartDeposit.getData().getDataSetByIndex(0);
            set1.setValues(yVals1);
            barChartDeposit.getData().notifyDataChanged();
            barChartDeposit.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, "DataSet 1");
            set1.setColor(Color.rgb(0, 191, 255));

            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);

            BarData data = new BarData(dataSets);
            data.setValueTextSize(10f);
            data.setBarWidth(barWidth);
            barChartDeposit.setData(data);
        }
    }

    private void setBarMultiData(int count, float range) {

        float barWidth = 9f;
        float spaceForBar = 2f;
        float groupSpace = 10f;
        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();
        ArrayList<BarEntry> yVals2 = new ArrayList<BarEntry>();

        float mult = 100 * 100000f;

        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * range);
//            float val = (float) (Math.random() * mult) + 3;
//            yVals1.add(new BarEntry(i, val));
            yVals1.add(new BarEntry(i * spaceForBar, val));
        }
        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * range);
            yVals2.add(new BarEntry(i * spaceForBar, val));
//            float val = (float) (Math.random() * mult) + 3;
//            yVals2.add(new BarEntry(i, val));

        }

        BarDataSet set1, set2;

        if (multiBarchart.getData() != null &&
                multiBarchart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) multiBarchart.getData().getDataSetByIndex(0);
            set2 = (BarDataSet) multiBarchart.getData().getDataSetByIndex(1);
            set1.setValues(yVals1);
            set2.setValues(yVals2);
            multiBarchart.getData().notifyDataChanged();
            multiBarchart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, "DataSet 1");
            set1.setColor(Color.rgb(233, 158, 136));
            set2 = new BarDataSet(yVals2, "DataSet 2");
            set2.setColor(Color.rgb(169,169,169));

            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);
            dataSets.add(set2);

            BarData data = new BarData(dataSets);
            data.setValueTextSize(10f);
            //  data.setBarWidth(barWidth);

            multiBarchart.setData(data);
            multiBarchart.getBarData().setBarWidth(barWidth);
            multiBarchart.groupBars(0, groupSpace, spaceForBar);
            multiBarchart.invalidate();
        }
    }

    private void setDataExpense(int count, float range) {

        float mult = range;

        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (int i = 0; i < count; i++) {
            entries.add(new PieEntry((float) ((Math.random() * mult) + mult / 5), dataExpense[i % dataExpense.length]));
        }

        PieDataSet dataSet = new PieDataSet(entries, "");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);

        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<Integer>();

        colors.add(Color.rgb(127, 192, 164)); //old green
        colors.add(Color.rgb(225, 170, 94)); //old yellow
        colors.add(Color.rgb(233, 157, 136)); //orut
        colors.add(Color.rgb(237, 236, 235)); //lightgray
        colors.add(Color.rgb(119, 187, 230)); //blue

        dataSet.setColors(colors);
        dataSet.setSelectionShift(0f);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        pieChartExpense.setData(data);


        // undo all highlights
        pieChartExpense.highlightValues(null);

        pieChartExpense.invalidate();
    }
}
