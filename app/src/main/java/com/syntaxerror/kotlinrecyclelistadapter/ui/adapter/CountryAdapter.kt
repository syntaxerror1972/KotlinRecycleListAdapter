package com.syntaxerror.kotlinrecyclelistadapter.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.syntaxerror.kotlinrecyclelistadapter.R
import com.syntaxerror.kotlinrecyclelistadapter.data.model.Country

/**
 **************************************************************************************
 *
 *** Project Details ***
 *
 * Project Name : KotlinRecycleListAdapter.
 * Package Id : com.syntaxerror.kotlinrecyclelistadapter.ui.adapter
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

class CountryAdapter : ListAdapter<Country, CountryAdapter.CountryViewHolder>(DiffUtil()) {

    class CountryViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val countryName = view.findViewById<TextView>(R.id.txtCountryName)
        val countryCapitalName = view.findViewById<TextView>(R.id.txtCountryCapital)

        fun bind(item : Country){
            countryName.text = item.countryName
            countryCapitalName.text = item.countryCapital
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.country,parent,false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class DiffUtil: androidx.recyclerview.widget.DiffUtil.ItemCallback<Country>(){
        override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
            return oldItem == newItem
        }
    }

}