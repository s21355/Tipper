package com.example.tipper;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;
import java.util.List;

public class GraphActivity extends AppCompatActivity {

    private LineChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        mChart = findViewById(R.id.chart);
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(false);

        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 25.5f));
        entries.add(new Entry(1, 25.8f));
        entries.add(new Entry(2, 26f));
        entries.add(new Entry(3, 26.1f));
        entries.add(new Entry(4, 25.9f));
        entries.add(new Entry(5, 25.9f));

        LineDataSet lineDataSet = new LineDataSet(entries, "BMI Values");
        lineDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        lineDataSet.setValueTextColor(Color.BLACK);
        lineDataSet.setValueTextSize(20f);

        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun"}));

        YAxis yAxisLeft = mChart.getAxisLeft();
        yAxisLeft.setGranularity(1f);
        yAxisLeft.setAxisMinimum(20f);
        yAxisLeft.setAxisMaximum(35f);

        YAxis yAxisRight = mChart.getAxisRight();
        yAxisRight.setEnabled(false);

        LineData data = new LineData(lineDataSet);
        mChart.setData(data);
        mChart.getDescription().setEnabled(false);

        Legend legend = mChart.getLegend();
        legend.setEnabled(false);

        mChart.invalidate();
    }
}
