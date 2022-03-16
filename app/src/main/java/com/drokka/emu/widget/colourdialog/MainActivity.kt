package com.drokka.emu.widget.colourdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    var pickColourFragment:PickColourFragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(pickColourFragment == null){
            pickColourFragment = PickColourFragment.newInstance()
        }

        setContentView(R.layout.activity_main)
    }
}