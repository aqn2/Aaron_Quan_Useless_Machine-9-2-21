package com.example.uselessmachine

import android.content.IntentSender
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Group
import org.w3c.dom.Text

lateinit var switchUseless: Switch
lateinit var buttonLookBusy: Button
lateinit var buttonSelfDestruct: ImageButton
lateinit var textSelfDestruct : TextView
lateinit var backgroundColor : ConstraintLayout
lateinit var groupMainUi: Group
lateinit var progressBar: ProgressBar
lateinit var progressText: TextView
lateinit var groupProgressUi: Group
lateinit var importantText: TextView


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

        buttonLookBusy.setOnClickListener{
            groupMainUi.visibility = View.INVISIBLE
            groupProgressUi.visibility = View.VISIBLE
            progressBar.setProgress(0)
            startLookBusy()
        }


    }

    private fun startLookBusy() {
        var usefullTimer = object : CountDownTimer(10000, 100){
            override fun onTick(millisUntilFinished: Long) {
                progressText.text = (100 - millisUntilFinished/100).toString() + "/100"
                progressBar.setProgress(100 - (millisUntilFinished/100).toInt())

            }

            override fun onFinish() {
                groupProgressUi.visibility = View.INVISIBLE
                groupMainUi.visibility = View.VISIBLE
            }
        }
        usefullTimer.start()
    }

    private fun startSelfDestructTimer() {
        val uselessTimer = object : CountDownTimer(5000, 500) {
            var bananna = false
            override fun onTick(millisUntilFinished: Long) {
                textSelfDestruct.text = (6+ (millisUntilFinished / 1000)).toString()
                    if (bananna) {
                        backgroundColor.setBackgroundColor(
                            Color.argb(255, 255, 0, 0)
                        )
                        bananna = false
                    }
                    else {
                        backgroundColor.setBackgroundColor(
                            Color.argb(255, 255, 255, 255)
                        )
                        bananna = true
                    }
                }
            override fun onFinish() {
                //turn app off
                startSelfDestructTimer2()

            }

        }
        uselessTimer.start()

    }

    private fun startSelfDestructTimer2() {
        val uselessTimer = object : CountDownTimer(5000, 250) {
            var bananna = true
            override fun onTick(millisUntilFinished: Long) {
                textSelfDestruct.text = (1+(millisUntilFinished / 1000)).toString()
                if (bananna) {
                    backgroundColor.setBackgroundColor(
                        Color.argb(255, 255, 0, 0)
                    )
                    bananna = false
                }
                else {
                    backgroundColor.setBackgroundColor(
                        Color.argb(255, 255, 255, 255)
                    )
                    bananna = true
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
        groupMainUi = findViewById(R.id.group_main_main_UI)
        progressBar = findViewById(R.id.main_progressbar_lookbusy)
        progressText = findViewById(R.id.main_progress_text)
        importantText = findViewById(R.id.progress_important_text)
        groupProgressUi = findViewById(R.id.group_progress_UI)

        groupProgressUi.visibility = View.INVISIBLE


    }
}


//switch -- purpose: useless
//button -- purpose: busy
//button -- purpose: look busy

//chain useless switch and destruct button vertically, center horizontally
//vertical chain style --whichever does equally spaced

//look busy button horizontally connected to bottom of screen