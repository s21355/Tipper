package com.example.kotlinfoodapp

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate

class GraphActivity : AppCompatActivity() {
    private var mChart: LineChart? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph)

        mChart = findViewById(R.id.chart)
        mChart?.setDragEnabled(true)
        mChart?.setScaleEnabled(false)

        val entries: MutableList<Entry> = ArrayList<Entry>()
        entries.add(Entry(0f, 25.5f))
        entries.add(Entry(1f, 25.8f))
        entries.add(Entry(2f, 26f))
        entries.add(Entry(3f, 26.1f))
        entries.add(Entry(4f, 25.9f))
        entries.add(Entry(5f, 25.9f))

        val lineDataSet = LineDataSet(entries, "BMI Values")
        lineDataSet.colors = ColorTemplate.COLORFUL_COLORS.toMutableList()
        lineDataSet.setValueTextColor(Color.BLACK)
        lineDataSet.setValueTextSize(20f)

        val xAxis: XAxis? = mChart?.xAxis
        xAxis?.position = XAxis.XAxisPosition.BOTTOM
        xAxis?.granularity = 1f
        xAxis?.valueFormatter = IndexAxisValueFormatter(
            arrayOf<String>(
                "Jan",
                "Feb",
                "Mar",
                "Apr",
                "May",
                "Jun"
            )
        )

        val yAxisLeft: YAxis? = mChart?.axisLeft
        yAxisLeft?.granularity = 1f
        yAxisLeft?.axisMinimum = 20f
        yAxisLeft?.axisMaximum = 35f

        val yAxisRight: YAxis? = mChart?.axisRight
        yAxisRight?.isEnabled = false

        val data = LineData(lineDataSet)
        mChart?.data = data
        mChart?.description?.isEnabled = false

        val legend: Legend? = mChart?.legend
        legend?.isEnabled = false

        mChart?.invalidate()
    }
}
