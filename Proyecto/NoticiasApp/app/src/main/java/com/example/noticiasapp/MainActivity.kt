package com.example.noticiasapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listaNoticias= arrayListOf<TempModel>()
        listaNoticias.add(
            TempModel(
                1,
                "Otis Library donors' information part of large cyber attack at fundraising company - theday.com",
                "By Day staff writer Claire Bessette Norwich — The giant fundraising software company Blackbaud, which handles Otis Library’s donor data, was hacked by ransomware cybercriminals earlier this year and paid a ransom to ensure the stolen data was destroyed by the…",
                "https://www.theday.com/Assets/images/facebook/TheDay_Facebook_OG-360px.png",
                "FOX"
            )
        )
        listaNoticias.add(
            TempModel(
                1,
                "Otis Library donors' information part of large cyber attack at fundraising company - theday.com",
                "By Day staff writer Claire Bessette Norwich — The giant fundraising software company Blackbaud, which handles Otis Library’s donor data, was hacked by ransomware cybercriminals earlier this year and paid a ransom to ensure the stolen data was destroyed by the…",
                "https://www.theday.com/Assets/images/facebook/TheDay_Facebook_OG-360px.png",
                "FOX"
            )
        )
        listaNoticias.add(
            TempModel(
                1,
                "Otis Library donors' information part of large cyber attack at fundraising company - theday.com",
                "By Day staff writer Claire Bessette Norwich — The giant fundraising software company Blackbaud, which handles Otis Library’s donor data, was hacked by ransomware cybercriminals earlier this year and paid a ransom to ensure the stolen data was destroyed by the…",
                "https://www.theday.com/Assets/images/facebook/TheDay_Facebook_OG-360px.png",
                "FOX"
            )
        )
        listaNoticias.add(
            TempModel(
                1,
                "Otis Library donors' information part of large cyber attack at fundraising company - theday.com",
                "By Day staff writer Claire Bessette Norwich — The giant fundraising software company Blackbaud, which handles Otis Library’s donor data, was hacked by ransomware cybercriminals earlier this year and paid a ransom to ensure the stolen data was destroyed by the…",
                "https://www.theday.com/Assets/images/facebook/TheDay_Facebook_OG-360px.png",
                "FOX"
            )
        )
        listaNoticias.add(
            TempModel(
                1,
                "Otis Library donors' information part of large cyber attack at fundraising company - theday.com",
                "By Day staff writer Claire Bessette Norwich — The giant fundraising software company Blackbaud, which handles Otis Library’s donor data, was hacked by ransomware cybercriminals earlier this year and paid a ransom to ensure the stolen data was destroyed by the…",
                "https://www.theday.com/Assets/images/facebook/TheDay_Facebook_OG-360px.png",
                "FOX"
            )
        )


        iniciarRecyclerView(listaNoticias,this,rv_cards)
    }
    fun iniciarRecyclerView(lista:List<TempModel>,
                            activity:MainActivity,
                            recycler_view:androidx.recyclerview.widget.RecyclerView
                            ){
        val mi_adaptador=MyAdapter(lista,activity,recycler_view)
        rv_cards.adapter=mi_adaptador
        rv_cards.itemAnimator=androidx.recyclerview.widget.DefaultItemAnimator()
        rv_cards.layoutManager=androidx.recyclerview.widget.LinearLayoutManager(activity)
        mi_adaptador.notifyDataSetChanged()

    }



}