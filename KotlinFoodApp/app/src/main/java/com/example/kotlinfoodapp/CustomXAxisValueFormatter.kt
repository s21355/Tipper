package com.example.kotlinfoodapp

import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.formatter.ValueFormatter

class CustomXAxisValueFormatter(private val labels: Array<String>) : ValueFormatter() {
    override fun getAxisLabel(value: Float, axis: AxisBase): String {
        // Ensure the value is within range
        val index = value.toInt().coerceAtMost(labels.size - 1)
        return labels[index]
    }
}





