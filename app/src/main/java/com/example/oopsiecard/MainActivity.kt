package com.example.oopsiecard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    private lateinit var punchedHoles: ArrayList<Int>
    private var one: ImageButton? = findViewById(R.id.button1)
    private var two: ImageButton? = findViewById(R.id.button2)
    private var three: ImageButton? = findViewById(R.id.button3)
    private var four: ImageButton? = findViewById(R.id.button4)
    private var five: ImageButton? = findViewById(R.id.button5)
    private var six: ImageButton? = findViewById(R.id.button6)
    private var seven: ImageButton? = findViewById(R.id.button7)
    private var eight: ImageButton? = findViewById(R.id.button8)
    private var nine: ImageButton? = findViewById(R.id.button9)
    private var ten: ImageButton? = findViewById(R.id.button10)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun holePunch(button: ImageButton){
        button
    }
}