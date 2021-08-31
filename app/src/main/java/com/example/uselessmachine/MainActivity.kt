package com.example.uselessmachine

import android.content.IntentSender
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import org.w3c.dom.Text

lateinit var switchUseless: Switch
lateinit var buttonLookBusy: Button
lateinit var buttonSelfDestruct: ImageButton
lateinit var textSelfDestruct : TextView
lateinit var backgroundColor : ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wireWidgets()

        //lambda -- an anonymous function that can be used with no name
        //with interface with only one method
        switchUseless.setOnCheckedChangeListener { buttonView, isChecked ->

            if(isChecked){
                //toast for when it becomes checked
                Toast.makeText(this@MainActivity,"Bruh!", Toast.LENGTH_SHORT).show()
            }
            else{
                //toast for when it is unchecked
                Toast.makeText(this@MainActivity,"Meme!", Toast.LENGTH_SHORT).show()
            }

            startSwitchTimer()


        }


        buttonSelfDestruct.setOnClickListener{
            startSelfDestructTimer()
        }


    }

    private fun startSelfDestructTimer() {
        val uselessTimer = object : CountDownTimer(10000, 500) {
            override fun onTick(millisUntilFinished: Long) {
                textSelfDestruct.text = (millisUntilFinished/1000).toString()
                while(millisUntilFinished/1000 >= 5){
                    if((millisUntilFinished/1000).toInt() % 2 == 1){
                        backgroundColor.setBackgroundColor(
                            Color.argb(0,255,0, 0)
                    }
                }
                while((millisUntilFinished/1000) < 5){
                    if((millisUntilFinished/500).toInt() % 2 == 0)
                        backgroundColor.setBackgroundColor(
                            Color.argb(0,255,0, 0)
                }
            }

            override fun onFinish() {
                //turn app off
                finish()

            }

        }
        uselessTimer.start()

    }

    private fun startSwitchTimer(){
        val uselessTimer = object : CountDownTimer(3000, 500) {
            //callbakcs-- functions that will be called later
            override fun onTick(p0: Long) {
                if(!switchUseless.isChecked){
                    cancel()
                }
            }

            override fun onFinish() {
                //turn the switch off
                switchUseless.isChecked = false

            }

        }
        uselessTimer.start()

    }

    private fun wireWidgets(){
        switchUseless = findViewById(R.id.switch_main_useless)
        buttonLookBusy = findViewById(R.id.button_main_lookbusy)
        buttonSelfDestruct = findViewById(R.id.button_main_busy)
        textSelfDestruct = findViewById((R.id.text_main_selfDestruct))
        backgroundColor = findViewById(R.id.background_main_color)
    }
}


//switch -- purpose: useless
//button -- purpose: busy
//button -- purpose: look busy

//chain useless switch and destruct button vertically, center horizontally
//vertical chain style --whichever does equally spaced

//look busy button horizontally connected to bottom of screen