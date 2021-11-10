package com.example.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val marvel= mutableListOf<Marvel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycle:RecyclerView=findViewById(R.id.recyclerVieww)
        val adabtar=marvel_adaptar(marvel)
        recycle.adapter=adabtar
        val retro=Retrofit.Builder().baseUrl("https://simplifiedcoding.net/").addConverterFactory(GsonConverterFactory.create()).build()
        val retroapi=retro.create(MarvelApi::class.java)
        retroapi.get(5).enqueue(object:Callback<List<Marvel>>{
            override fun onResponse(call: Call<List<Marvel>>, response: Response<List<Marvel>>) {
                response.body()?.run {
                    marvel.addAll(this)
                    adabtar.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<Marvel>>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })

    }
}