package com.example.countries

import com.example.countries.Countries.ListesItem
import com.example.countries.Country.CountryClassItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

import retrofit2.http.Url

interface CountryInterface {
    @GET
    suspend fun getaCountry(@Url uri : String) : Response<List<CountryClassItem>>
    @GET
    suspend  fun getaCountryList(@Url uri : String) : Response<List<ListesItem>>
}