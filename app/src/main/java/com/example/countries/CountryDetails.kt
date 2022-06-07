package com.example.countries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_country_details.*
import com.example.countries.Countries.ListesItem
import com.example.countries.Country.CountryClassItem
import com.example.countries.adapters.languageAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class CountryDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_details)

        var c_s = CountryService();
        var country : MutableList<CountryClassItem> = mutableListOf()
        var nameC = intent.getSerializableExtra("nameC") as String ?: " "
        country = c_s.getcountry(nameC)
        Thread.sleep(5000L)
        var ex = country
        print(",")

var sts = country[0].languages.toString()

        val picasso =
            Picasso.Builder(this)
                .listener { picasso, uri, exception ->
                    Toast.makeText(this,exception.message, Toast.LENGTH_LONG).show()
                    Log.e("picasso", exception.message ?:"")
                }
                .build()
        picasso.load(country[0].coatOfArms.png)
            .centerCrop().fit()
            .into(coatofArmsJpg)
        val picassocoat =
            Picasso.Builder(this)
                .listener { picasso, uri, exception ->
                    Log.e("picasso coat",exception.message?:"")
                }
                .build()
        picassocoat.load(country[0].flags.png)
            .centerCrop().fit()
            .into(c_detail_flag)
        var rep = ""
        if(country[0].altSpellings.count() == 1){rep = country[0].altSpellings[0]}else {rep = country[0].altSpellings[1].replace(" ", "")}
        c_republic.text = rep
        c_regiontxt.text = country[0].region.replace(" ", "")
        c_Areatxt.text = country[0].area.replace(" ", "")
        c_Populationtxt.text = country[0].population.replace(" ", "")
        c_Phonecodetxt.text = (country[0].idd.root + country[0].idd.suffixes[0]).replace(" ", "")
        c_ISOcodetxt.text = country[0].altSpellings[0].replace(" ", "")
        c_Capitaltxt.text = country[0].capital[0].replace(" ", "")
        var listelang = mutableListOf<String>()
        var stri = sts.replace("}","")
        listelang.add(stri.replace("{","")); //listelang.add(country[0].languages.eng)
        var adapter = languageAdapter(listelang)
       c_languages.adapter = adapter
        var curr = country[0].currencies.toString()
        //if(country[0].currencies.toString().contains("symbol"))
        var eqpos = curr.lastIndexOf("=")
        var sub = curr.subSequence((eqpos +1),(curr.length-2))
        c_Currencytxt.text = sub
       // {XAF={name=Central African CFA franc, symbol=Fr}}
        c_latitudetxt.text = country[0].latlng[0].toString()
        c_longitudetxt.text = country[0].latlng[1].toString()
        adapter.setOnClickListener(
            object : languageAdapter.OnItemClickListener{
                override fun onItemClick(position: Int) {
                    Toast.makeText(applicationContext,listelang[position],
                        Toast.LENGTH_SHORT).show()
                }
            })
    }
}