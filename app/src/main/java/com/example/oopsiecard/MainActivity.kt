package com.example.oopsiecard

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import nl.dionsegijn.konfetti.xml.KonfettiView

class MainActivity : AppCompatActivity() {
    private lateinit var repository: Repository
    private var allHoles: ArrayList<Int>? = null
    private var holePunchedImages: ArrayList<Int> = ArrayList()
    private var titles: ArrayList<CharSequence> = ArrayList()
    private lateinit var one: ImageButton
    private lateinit var two: ImageButton
    private lateinit var three: ImageButton
    private lateinit var four: ImageButton
    private lateinit var five: ImageButton
    private lateinit var six: ImageButton
    private lateinit var seven: ImageButton
    private lateinit var eight: ImageButton
    private lateinit var nine: ImageButton
    private lateinit var ten: ImageButton
    private lateinit var popupMessage: TextView
    private lateinit var confetti: KonfettiView
    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        application.onCreate()
        setContentView(R.layout.activity_main)

        one = findViewById(R.id.button1)
        two = findViewById(R.id.button2)
        three = findViewById(R.id.button3)
        four = findViewById(R.id.button4)
        five = findViewById(R.id.button5)
        six = findViewById(R.id.button6)
        seven = findViewById(R.id.button7)
        eight = findViewById(R.id.button8)
        nine = findViewById(R.id.button9)
        ten = findViewById(R.id.button10)

        holePunchedImages.add(R.drawable.heart)
        holePunchedImages.add(R.drawable.kite)
        holePunchedImages.add(R.drawable.smileyface)
        holePunchedImages.add(R.drawable.shootingstar)
        holePunchedImages.add(R.drawable.star)

        titles.add("You did it!")
        titles.add("Awesome job")
        titles.add("That's my little guy!")
        titles.add("Good job bud!")
        titles.add("I knew you could do it!")
        titles.add("Keep it up!")


        repository = Repository(application)
        allHoles = repository.allPunchedHoles as ArrayList<Int>?

        if(allHoles == null){

            repository.insert(PunchedHoles(1, R.drawable.number1))
            repository.insert(PunchedHoles(2, R.drawable.number2))
            repository.insert(PunchedHoles(3, R.drawable.number3))
            repository.insert(PunchedHoles(4, R.drawable.number4))
            repository.insert(PunchedHoles(5, R.drawable.number5))
            repository.insert(PunchedHoles(6, R.drawable.number6))
            repository.insert(PunchedHoles(7, R.drawable.number7))
            repository.insert(PunchedHoles(8, R.drawable.number8))
            repository.insert(PunchedHoles(9, R.drawable.number9))
            repository.insert(PunchedHoles(10, R.drawable.number10))
            repository.insert(PunchedHoles(11, 0))
            repository.allHoles()
            allHoles = repository.allPunchedHoles as ArrayList<Int>?
        }

        one.setImageResource(allHoles!![0])
        two.setImageResource(allHoles!![1])
        three.setImageResource(allHoles!![2])
        four.setImageResource(allHoles!![3])
        five.setImageResource(allHoles!![4])
        six.setImageResource(allHoles!![5])
        seven.setImageResource(allHoles!![6])
        eight.setImageResource(allHoles!![7])
        nine.setImageResource(allHoles!![8])
        ten.setImageResource(allHoles!![9])
        counter = allHoles!![10]
    }

    fun useOopsie(view:View){
        counter--
        repository.update(PunchedHoles(11, counter))

    }

    fun holePunch(view: View) {
        val button: ImageButton = view as ImageButton
        val buttonId: Int = button.id
        val newPicture: Int = holePunchedImages.random()
        button.setImageResource(newPicture)
        repository.update(PunchedHoles(buttonId, newPicture))
        button.isEnabled = false

        val inflater: LayoutInflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView: View = inflater.inflate(R.layout.popup, null)

        val width: Int = LinearLayout.LayoutParams.WRAP_CONTENT
        val height: Int = LinearLayout.LayoutParams.WRAP_CONTENT
        val focusable = true
        val popupWindow = PopupWindow(popupView, width, height, focusable)
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)
        //confetti = findViewById(R.id.confetti)

        popupView.setOnTouchListener(object : View.OnTouchListener{
            override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
                popupWindow.dismiss()
                return true
            }
        })
        //TODO figure out how to change pop up message later
        //popupMessage = findViewById(R.id.popupMessage)
        //popupMessage.text = titles.random()

        if (!one.isEnabled && !two.isEnabled) {
            if (!three.isEnabled && !four.isEnabled) {
                if (!five.isEnabled && !six.isEnabled) {
                    if (!seven.isEnabled && !eight.isEnabled) {
                        if (!nine.isEnabled && !ten.isEnabled) {
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

        one.setImageResource(R.drawable.number1)
        two.setImageResource(R.drawable.number2)
        three.setImageResource(R.drawable.number3)
        four.setImageResource(R.drawable.number4)
        five.setImageResource(R.drawable.number5)
        six.setImageResource(R.drawable.number6)
        seven.setImageResource(R.drawable.number7)
        eight.setImageResource(R.drawable.number8)
        nine.setImageResource(R.drawable.number9)
        ten.setImageResource(R.drawable.number10)

        counter++
        repository.update(PunchedHoles(11, counter))
        repository.update(PunchedHoles(1, R.drawable.number1))
        repository.update(PunchedHoles(2, R.drawable.number2))
        repository.update(PunchedHoles(3, R.drawable.number3))
        repository.update(PunchedHoles(4, R.drawable.number4))
        repository.update(PunchedHoles(5, R.drawable.number5))
        repository.update(PunchedHoles(6, R.drawable.number6))
        repository.update(PunchedHoles(7, R.drawable.number7))
        repository.update(PunchedHoles(8, R.drawable.number8))
        repository.update(PunchedHoles(9, R.drawable.number9))
        repository.update(PunchedHoles(10, R.drawable.number10))

    }
    //TODO add confetti animation
}