package com.emanuelfuentes.evlab2_pdm_00159817

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.emanuelfuentes.evlab2_pdm_00159817.fragmentos.Dinamico
import com.emanuelfuentes.evlab2_pdm_00159817.fragmentos.Estatico
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_estatico.*

class MainActivity : AppCompatActivity(), Estatico.OnFragmentInteractionListener, Dinamico.OnFragmentInteractionListener {
    var cont = 0


    override fun onClickButton2() {

    }



    override fun onClickButton(text: String) {
        Toast.makeText(this, "MJM", Toast.LENGTH_SHORT).show()
        if(text == "next"){
            cont++
        }
        if(text == "next" && cont > 2){
            cont = 0
        }
        if(text=="previous"){
            cont--
        }
        if(text== "previous" && cont < 0 ){
            cont = 2

        }

        //estatico.lineal.setBackgroundColor(Color.BLACK)

        initfrag(cont)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initfrag(0)
    }


    fun initfrag(n : Int){
        val dinamico = Dinamico.newInstance(n)
        supportFragmentManager.beginTransaction().replace(R.id.dinamico, dinamico).commit()
    }
}
