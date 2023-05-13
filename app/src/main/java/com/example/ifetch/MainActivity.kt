package com.example.ifetch

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.DropBoxManager
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.viewpager.widget.ViewPager
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.google.android.material.tabs.TabLayout
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var chart: LineChart
    lateinit var name : TextView
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //for Greeting msg
        val now = LocalDateTime.now()

        // Determine the greeting based on the time of day
        val greeting = when (now.hour) {
            in 0..11 -> "Good morning!"
            in 12..16 -> "Good afternoon!"
            in 17..23 -> "Good evening!"
            else -> "Welcome!"
        }

        // Display the greeting
        findViewById<TextView>(R.id.greeting).text = greeting

        //to display name
        name = findViewById(R.id.name)
        name.text = "Dhruv Agrawal"
        //for line chart
        chart = findViewById(R.id.lineChart)
        //fragments
        val fragmentManager = supportFragmentManager
        val buttonFragment1 = findViewById<Button>(R.id.button_fragment1)
        buttonFragment1.setOnClickListener {
            val fragment1 = TopLinks()
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, fragment1)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        val buttonFragment2 = findViewById<Button>(R.id.button_fragment2)
        buttonFragment2.setOnClickListener {
            val fragment2 = RecentLinks()
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, fragment2)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        // customize chart properties
        chart.setDrawGridBackground(false)
        chart.description = Description().apply {
            text = "My Chart"
            textColor = Color.BLACK
            textSize = 16f
        }
//        chart.axisLeft.setDrawGridLines(false)
//        chart.axisRight.setDrawGridLines(false)
//        chart.xAxis.setDrawGridLines(false)
//        chart.legend.isEnabled = false
//
//        // get data from API or local source
//        val data = mapOf(
//            "2023-04-12" to 0,
//            "2023-04-13" to 0,
//            "2023-04-14" to 0,
//            "2023-04-15" to 0,
//            "2023-04-16" to 0,
//            "2023-04-17" to 0,
//            "2023-04-18" to 0,
//            "2023-04-19" to 0,
//            "2023-04-20" to 0,
//            "2023-04-21" to 0,
//            "2023-04-22" to 0,
//            "2023-04-23" to 0,
//            "2023-04-24" to 0,
//            "2023-04-25" to 0,
//            "2023-04-26" to 1,
//            "2023-04-27" to 0,
//            "2023-04-28" to 5,
//            "2023-04-29" to 0,
//            "2023-04-30" to 0,
//            "2023-05-01" to 0,
//            "2023-05-02" to 0,
//            "2023-05-03" to 0,
//            "2023-05-04" to 0,
//            "2023-05-05" to 0,
//            "2023-05-06" to 0,
//            "2023-05-07" to 0,
//            "2023-05-08" to 0,
//            "2023-05-09" to 0,
//            "2023-05-10" to 0,
//            "2023-05-11" to 0,
//            "2023-05-12" to 1
//        )
//
//        // create entries list from data
//        val entries = ArrayList<Entry>()
//        val dateParser = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
//        for ((dateStr, value) in data) {
//            val date = dateParser.parse(dateStr)
//            val millis = date?.time?.toFloat() ?: 0f
//            entries.add(Entry(millis, value.toFloat()))
//        }
//
//        // sort entries by date
//        entries.sortBy { it.x }
//
//        // create data set and add to chart
//        val dataSet = LineDataSet(entries, "My Data Set").apply {
//            color = Color.BLUE
//            fillColor = Color.BLUE
//            fillAlpha = 50
//            setDrawFilled(true)
//            setDrawValues(false)
//            setDrawCircles(false)
//        }
//
//        val lineData = LineData(dataSet)
//        chart.data = lineData
//        chart.invalidate()
    }
}