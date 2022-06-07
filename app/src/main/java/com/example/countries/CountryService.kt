package com.example.countries

import com.example.countries.Countries.ListesItem
import com.example.countries.Country.CountryClassItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory

class CountryService {
    var BaseUrl = "https://restcountries.com/v3.1/"
    fun getcountry(name : String="cameroon") : MutableList<CountryClassItem> {
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(CountryInterface::class.java)

        var ite : MutableList<CountryClassItem> = mutableListOf()
        GlobalScope.launch(Dispatchers.IO) {
            val call = retrofit.getaCountry(BaseUrl+"name/"+name)
            if(call.isSuccessful){
                if(call.body()!= null) {
                    if (call.body() != null) {
                        for (its in call.body()!!) {
                            ite.add(its)
                        }
                    }
                }
            }
            delay(300L)
        }
        return ite
    }
    fun getListcountry() : MutableList<ListesItem> {
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(CountryInterface::class.java)

        var ite : MutableList<ListesItem> = mutableListOf()
        GlobalScope.launch(Dispatchers.IO) {
            val call = retrofit.getaCountryList(BaseUrl+"all")
            if(call.isSuccessful){
                if(call.body()!= null){
                    for (its in call.body()!!){
                    ite.add(its)
                }}
            }
            delay(1000L)
        }
        return ite
    }
}