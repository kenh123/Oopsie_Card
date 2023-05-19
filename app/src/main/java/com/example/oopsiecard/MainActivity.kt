package com.example.oopsiecard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    private lateinit var punchedHoles: ArrayList<Int>
    private var holePunchedImages: ArrayList<Int> = ArrayList()
    private var one: ImageButton = findViewById(R.id.button1)
    private var two: ImageButton = findViewById(R.id.button2)
    private var three: ImageButton = findViewById(R.id.button3)
    private var four: ImageButton = findViewById(R.id.button4)
    private var five: ImageButton = findViewById(R.id.button5)
    private var six: ImageButton = findViewById(R.id.button6)
    private var seven: ImageButton = findViewById(R.id.button7)
    private var eight: ImageButton = findViewById(R.id.button8)
    private var nine: ImageButton = findViewById(R.id.button9)
    private var ten: ImageButton = findViewById(R.id.button10)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun holePunch(view: View){
        val button: ImageButton = view as ImageButton
        button.setImageResource(holePunchedImages.random())
        button.isEnabled = false
        if(!one.isEnabled && !two.isEnabled){
            if(!three.isEnabled && !four.isEnabled){
                if(!five.isEnabled && !six.isEnabled){
                    if(!seven.isEnabled && !eight.isEnabled){
                        if(!nine.isEnabled && !ten.isEnabled){
                            reset()
                        }
                    }
                }
            }
        }
    }

    private fun reset(){
        one.isEnabled = true
        two.isEnabled = true
        three.isEnabled = true
        four.isEnabled = true
        five.isEnabled = true
        six.isEnabled = true
        seven.isEnabled = true
        eight.isEnabled = true
        nine.isEnabled = true
        ten.isEnabled = true

        one.setImageResource(0)
        two.setImageResource(0)
        three.setImageResource(0)
        four.setImageResource(0)
        five.setImageResource(0)
        six.setImageResource(0)
        seven.setImageResource(0)
        eight.setImageResource(0)
        nine.setImageResource(0)
        ten.setImageResource(0)
    }
}