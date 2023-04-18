package com.example.tipper;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.ValueFormatter;

public class CustomXAxisValueFormatter extends ValueFormatter {

    private final String[] labels;

    public CustomXAxisValueFormatter(String[] labels) {
        this.labels = labels;
    }

    @Override
    public String getAxisLabel(float value, AxisBase axis) {
        // Ensure the value is within range
        int index = Math.min((int) value, labels.length - 1);
        return labels[index];
    }
}