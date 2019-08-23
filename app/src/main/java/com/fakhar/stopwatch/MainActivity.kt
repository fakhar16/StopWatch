package com.fakhar.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Chronometer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mChronometer: Chronometer
    var running = false
    var pauseOffset : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mChronometer = chronometer

        var startbtn = btnStart
        var pausebtn = btnPause
        var resetbtn = btnReset

        startbtn.setOnClickListener(View.OnClickListener {

            if(!running)
            {
                mChronometer.base = SystemClock.elapsedRealtime() - pauseOffset
                mChronometer.start()
                running = true
            }
        })


        pausebtn.setOnClickListener(View.OnClickListener {

            if(running)
            {
                 pauseOffset = SystemClock.elapsedRealtime() - mChronometer.base
                mChronometer.stop()
                running = false
            }
        })

        resetbtn.setOnClickListener(View.OnClickListener {

            mChronometer.base = SystemClock.elapsedRealtime()
            pauseOffset = 0
        })
    }
}
