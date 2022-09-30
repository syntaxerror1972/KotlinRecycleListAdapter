package com.syntaxerror.kotlinrecyclelistadapter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.syntaxerror.kotlinrecyclelistadapter.R
import com.syntaxerror.kotlinrecyclelistadapter.data.model.Country
import com.syntaxerror.kotlinrecyclelistadapter.ui.adapter.CountryAdapter

/**
 **************************************************************************************
 *
 *** Project Details ***
 *
 * Project Name : KotlinRecycleListAdapter.
 * Package Id : com.syntaxerror.kotlinrecyclelistadapter.ui
 * Created By :  Shrawan Shinde
 * Created Date :  01,October,2022
 *
 *** Contact Details ***
 *
 * Name : Shrawan B. Shinde
 * Email : syntaxerror1972@gmail.com
 * Github Link : https://github.com/syntaxerror1972/KotlinRecycleListAdapter
 * LinkedIn Link : https://in.linkedin.com/in/shrawan-shinde-59ba57a1
 * Copyright (c) 2022. All rights reserved.
 *
 **************************************************************************************
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCountry)
        val adapter = CountryAdapter()

        val countryList = listOf<Country>(
            Country(1,"India","Delhi"),
            Country(2,"Pakistan","Karachi"),
            Country(3,"Bangladesh","Dhaka"),
        )

        adapter.submitList(countryList)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        Handler(Looper.getMainLooper()).postDelayed({
            val countryList = listOf<Country>(
                Country(3,"Bangladesh","Dhaka"),
                Country(4,"USA","New York"),
                Country(5,"Japan","Tokyo"),
            )

            adapter.submitList(countryList)
        },5000)

    }
}