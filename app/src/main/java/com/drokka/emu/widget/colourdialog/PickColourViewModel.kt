package com.drokka.emu.widget.colourdialog

import androidx.lifecycle.ViewModel

class PickColourViewModel : ViewModel() {
    var rgbValue:IntArray = intArrayOf(0,0,0,255) // red, blue, green, opacity

    var bgClr:IntArray = intArrayOf(0,0,0,255)
    var minClr:IntArray = intArrayOf(0,0,0,255)
    var maxClr:IntArray = intArrayOf(0,0,0,255)

}