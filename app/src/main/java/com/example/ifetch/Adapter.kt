package com.example.ifetch



import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class Adapter(private val cntx: Context, private val list: ArrayList<Model>) :
    ArrayAdapter<Model>(cntx,R.layout.custom_row,list) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater :LayoutInflater = LayoutInflater.from(cntx)
        val view : View = inflater.inflate(R.layout.custom_row,null);
        val sample_link = view.findViewById<TextView>(R.id.sampleLink)
        val noClicks = view.findViewById<TextView>(R.id.noOfClick)
        val date = view.findViewById<TextView>(R.id.date)
        val link = view.findViewById<TextView>(R.id.link)
        sample_link.text = list[position].SampleLinks
        noClicks.text = list[position].Clicks
        date.text = list[position].Date
        link.text = list[position].link
        return view
    }
}