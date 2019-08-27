package com.example.constraintlayoutdemo.motionlayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.motion.MotionLayout
import android.support.constraint.motion.MotionScene
import android.util.Log
import android.widget.SeekBar
import com.example.constraintlayoutdemo.R
import kotlinx.android.synthetic.main.activity_motion_layout.*

class MotionLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion_layout)
        seekbar.max = 100
        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                activity_motion.progress = (progress * 0.01).toFloat()
                MotionLayoutMunu.progress = (progress * 0.01).toFloat()
            }
        })

        activity_motion.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
                Log.d("App", "onTransitionTrigger: p2:$p2 p3 $p3")
            }

            override fun allowsTransition(p0: MotionScene.Transition?): Boolean {
                Log.d("App", "allowsTransition: ")
                return false
            }

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
                Log.d("App", "onTransitionStarted")
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, v: Float) {
                Log.d("App", "onTransitionChange: $v")
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                Log.d("App", "onTransitionCompleted $p1")
            }

        })
    }
}
