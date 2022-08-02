package com.example.recyapp

import retrofit2.Call
import retrofit2.http.POST

public interface ApiInterface {

    @POST("E1Pn7khWG")
    fun getHospitalsList(): Call<ArrayList<Hospitals>>
}
