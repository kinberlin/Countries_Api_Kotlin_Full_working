package com.example.countries

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.countries.Countries.ListesItem
import com.example.countries.Country.CountryClassItem
import com.example.countries.adapters.countryAdapter
import com.example.countries.adapters.languageAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_country_details.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var c_s = CountryService();
        var next = findViewById<Button>(R.id.next_row)
        var prev= findViewById<Button>(R.id.previous_row)
        var country : MutableList<CountryClassItem> = mutableListOf()
        var countries : MutableList<ListesItem> = mutableListOf()
        var adapter : countryAdapter

        countries = c_s.getListcountry();
        Thread.sleep(10000L)
        var ex = mutableListOf<ListesItem>()
        var max = 9
        var min = 0
        if(!countries.isEmpty()){
        for(i in min..max){
        ex.add(countries[i])}}
        textView2.text = countries.count().toString()
        adapter = countryAdapter(ex, this.applicationContext)
        recyclerView.adapter =  adapter
        print(",")
        rangevalue.text = min.toString() + " - " + max.toString()
        next.setOnClickListener {
            min += 10; max +=10
            if(max < countries.count())
            {ex.clear()
                for(i in min..max){
                ex.add(countries[i])}
            rangevalue.text = min.toString() + " - " + max.toString()}
                adapter.notifyDataSetChanged()
        }

        prev.setOnClickListener {
            min -= 10; max -=10
            if(min >= 0)
            {ex.clear()
                for(i in min..max){
                    ex.add(countries[i])}
                rangevalue.text = min.toString() + " - " + max.toString()}
            adapter.notifyDataSetChanged()
        }
        adapter.setOnClickListener(
            object : countryAdapter.OnItemClickListener{
                override fun onItemClick(position: Int) {
            var inten = Intent(applicationContext, CountryDetails::class.java)
                    inten.putExtra("nameC",ex[position].name.official )
                    startActivity(inten)
                }
            })

    }
}