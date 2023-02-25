package com.example.testlandscapeportraitlayout

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Switch

class MainActivity : AppCompatActivity()
{
    private lateinit var viewBox:View
    private lateinit var resButton:Button
    private lateinit var switchR:Switch
    private lateinit var editTextR:EditText
    private lateinit var barR:SeekBar
    private lateinit var switchG:Switch
    private lateinit var editTextG:EditText
    private lateinit var barG:SeekBar
    private lateinit var switchB:Switch
    private lateinit var editTextB:EditText
    private lateinit var barB:SeekBar


    //If you declared the progress variable inside the onProgressChanged() method,
    // it will be a local variable and cannot be modified outside of that method.
    // You need to declare the progress variable as a property of the class or the activity,
    // so that you can access it from other methods as well.
    var redProgress = 0
    var greenProgress = 0
    var blueProgress = 0

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.viewBox = this.findViewById(R.id.view2)
        this.resButton= this.findViewById(R.id.button)
        this.switchR=this.findViewById(R.id.switchR)
        this.editTextR=this.findViewById(R.id.editTextNumberDecimalR)
        this.barR=this.findViewById(R.id.seekBarR)
        this.switchB=this.findViewById(R.id.switchB)
        this.editTextB=this.findViewById(R.id.editTextNumberDecimalB)
        this.barB=this.findViewById(R.id.seekBarB)
        this.switchG=this.findViewById(R.id.switchG)
        this.editTextG=this.findViewById(R.id.editTextNumberDecimalG)
        this.barG=this.findViewById(R.id.seekBarG)



        barR.max = 255 // progress ends at 255
        barR.progress = 0 // starts from 0 like barR[i]

        barB.max = 255
        barB.progress = 0

        barG.max = 255
        barG.progress = 0




        barR.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(sb: SeekBar?, progress: Int, p2: Boolean)
            {
                //This method will be called when the user moves the thumb on the seek bar
                // The progress parameter will contain the current progress value
                // The fromUser parameter will be true if the progress change was initiated by the user
                // progress is i like progress[i] in color array starting from 0 to 255
                //sb is seekbar
                // alpha represents the color with full opacity or solid not transparent
                //and create new color with the mixture of red, green, and blue
                //then it set the viewBox background with new color from 0-255
                // the equation we divided the progress percentage over 2.55 to get
                // result in 100%  from 255 like if progress is 20/2.55 = 7.843565 then to int
                // will truncate it to become 8 like rounding it then inserting the result in string
                // using $
                var percentage = (progress.toFloat() / 2.55).toInt()

                redProgress = progress
                viewBox.setBackgroundColor(Color.argb(255, redProgress, greenProgress, blueProgress))
                editTextR.setText("$percentage%")

            }


            override fun onStartTrackingTouch(sb: SeekBar?)
            {
                // This method will be called when the user starts interacting with the seek bar

            }

            override fun onStopTrackingTouch(sb: SeekBar?)
            {
                // This method will be called when the user stops interacting with the seek bar
            }


        })


        barB.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(sb: SeekBar?, progress: Int, p2: Boolean)
            {
                //This method will be called when the user moves the thumb on the seek bar
                // The progress parameter will contain the current progress value
                // The fromUser parameter will be true if the progress change was initiated by the user
                // progress is i like progress[i] in color array starting from 0 to 255
                //sb is seekbar
                // alpha represents the color with full opacity or solid not transparent
                //and create new color with the mixture of red, green, and blue
                //then it set the viewBox background with new color from 0-255
                var percentage = (progress.toFloat() / 2.55).toInt()
                blueProgress = progress
                viewBox.setBackgroundColor(Color.argb(255, redProgress, greenProgress, blueProgress))
                editTextB.setText("$percentage%")




            }


            override fun onStartTrackingTouch(sb: SeekBar?)
            {
                // This method will be called when the user starts interacting with the seek bar

            }

            override fun onStopTrackingTouch(sb: SeekBar?)
            {
                // This method will be called when the user stops interacting with the seek bar
            }


        })



        barG.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(sb: SeekBar?, progress: Int, p2: Boolean)
            {
                //This method will be called when the user moves the thumb on the seek bar
                // The progress parameter will contain the current progress value
                // The fromUser parameter will be true if the progress change was initiated by the user
                // progress is i like progress[i] in color array starting from 0-255
                //sb is seekbar
                // alpha represents the color with full opacity or solid not transparent
                //and create new color with the mixture of red, green, and blue
                //then it set the viewBox background with new color from 0-255
                var percentage = (progress.toFloat() / 2.55).toInt()
                greenProgress = progress
                viewBox.setBackgroundColor(Color.argb(255, redProgress, greenProgress, blueProgress))
                editTextG.setText("$percentage%")


            }


            override fun onStartTrackingTouch(sb: SeekBar?)
            {
                // This method will be called when the user starts interacting with the seek bar

            }

            override fun onStopTrackingTouch(sb: SeekBar?)
            {
                // This method will be called when the user stops interacting with the seek bar
            }


        })


        resButton.setOnClickListener {
            // white(R:255, G:255, B:255)
            //black(R:0, G:0, B:0)
            //Red(255, 0, 0)
            redProgress= 0
            greenProgress= 0
            blueProgress= 0
            barR.progress = 0 // it will make seekbar reset to black = 0- 255 = white
            barG.progress = 0
            barB.progress = 0


            viewBox.setBackgroundColor(Color.argb(255, redProgress, greenProgress, blueProgress))



        }


        switchR.setOnCheckedChangeListener { compoundButton, isChecked ->

            if(isChecked) // the color is off
            {
               // barR.max = 0 // we set max to 0 so the seekbar stuck at 0
                barR.isEnabled = false
                resButton.isEnabled = false


            }

            else // the color is on
            {
                barR.isEnabled = true
                resButton.isEnabled = true
                //barR.max = 255 // reset the max to 255
                viewBox.setBackgroundColor(Color.argb(255, redProgress, greenProgress, blueProgress))
            }


        }


        switchG.setOnCheckedChangeListener { compoundButton, isChecked ->

            if(isChecked) // the color is on
            {
                //barG.max = 0
                barG.isEnabled = false
                resButton.isEnabled = false


            }

            else // the color is off
            {
                //barG.max = 255
                barG.isEnabled = true
                resButton.isEnabled = true
                viewBox.setBackgroundColor(Color.argb(255, redProgress, greenProgress, blueProgress))
            }


        }


        switchB.setOnCheckedChangeListener { compoundButton, isChecked ->

            if(isChecked) // the color is on
            {
                barB.isEnabled = false
                resButton.isEnabled = false




            }

            else // the color is off
            {
                barB.isEnabled = true
                resButton.isEnabled = true
                viewBox.setBackgroundColor(Color.argb(255, redProgress, greenProgress, blueProgress))
            }


        }




    }
}