package com.example.ifetch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ListView

class TopLinks : Fragment() {
    lateinit var list: ListView
    private var sample_link:String? = ""
    private var click:String? = ""
    private var date:String?=""
    private var link:String?=""
//    private lateinit var adapter:Adapter
    lateinit var arrayList: ArrayList<Model>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        arrayList = arrayListOf(
            Model("dhruv 1","100","24/05/2023","chcuctygcuyc"),
            Model("dhruv 2","100","24/05/2023","chcuctygcuyc"),
            Model("dhruv 3","100","24/05/2023","chcuctygcuyc"),
            Model("dhruv 4","100","24/05/2023","chcuctygcuyc")
        )

        return inflater.inflate(R.layout.fragment_top_links, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        list=view.findViewById(R.id.lstView)
        var adapter= Adapter(requireContext(),arrayList)
        list.adapter=adapter

    }


}