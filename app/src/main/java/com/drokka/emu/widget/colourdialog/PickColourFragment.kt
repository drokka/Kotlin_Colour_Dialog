package com.drokka.emu.widget.colourdialog

import android.graphics.Color
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import android.view.Display
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar

class PickColourFragment : Fragment() {

    companion object {
        fun newInstance() = PickColourFragment()
    }


    private lateinit var viewModel: PickColourViewModel
    private lateinit var redSeekBar:SeekBar
    private lateinit var greenSeekBar: SeekBar
    private lateinit var blueSeekBar: SeekBar
    private lateinit var colourDisplay: View
    private lateinit var bgColourView: View
    private lateinit var minColourView: View
    private lateinit var maxColourView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pick_colour, container, false)
        redSeekBar = view.findViewById(R.id.redSeekBar)
        blueSeekBar = view.findViewById(R.id.blueSeekBar)
        greenSeekBar = view.findViewById(R.id.greenSeekBar)
        colourDisplay = view.findViewById(R.id.colourDisplayView)
        bgColourView = view.findViewById(R.id.viewBgClr)
        minColourView = view.findViewById(R.id.viewMinClr)
        maxColourView = view.findViewById(R.id.viewMaxClr)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(PickColourViewModel::class.java)

        redSeekBar.setOnSeekBarChangeListener( object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                viewModel.rgbValue[0] =i
                setColourDisplay(colourDisplay)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
         //       viewModel.rgbValue[0] = p0.get
            }
        }
        )

        greenSeekBar.setOnSeekBarChangeListener( object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                viewModel.rgbValue[1] =i
                setColourDisplay(colourDisplay)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        }
        )

        blueSeekBar.setOnSeekBarChangeListener( object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                viewModel.rgbValue[2] =i
                setColourDisplay(colourDisplay)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        }
        )
        bgColourView.setOnClickListener {viewModel.bgClr = viewModel.rgbValue; setColourDisplay(it) }
        minColourView.setOnClickListener { viewModel.minClr = viewModel.rgbValue; setColourDisplay(it) }
        maxColourView.setOnClickListener { viewModel.maxClr = viewModel.rgbValue; setColourDisplay(it) }
    }

    fun setColourDisplay(view: View){
        viewModel.let {
            val intArray = viewModel.rgbValue
            view.setBackgroundColor(Color.argb(intArray[3],
                intArray[0],intArray[1], intArray[2]))
            Log.d("setColourDisplay",String.format("Called, rgb is %d %d %d" ,intArray[0], intArray[1], intArray[2] ))
        }
    }

}