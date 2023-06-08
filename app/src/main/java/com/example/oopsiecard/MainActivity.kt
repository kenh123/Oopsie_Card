package com.example.oopsiecard

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    private lateinit var repository: Repository
    private var allHoles: ArrayList<Int>? = null
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
    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repository = Repository(Application())
        allHoles = repository.allPunchedHoles as ArrayList<Int>?

        if(allHoles == null){

            repository.insert(PunchedHoles(one.id, R.drawable.number1))
            repository.insert(PunchedHoles(two.id, R.drawable.number2))
            repository.insert(PunchedHoles(three.id, R.drawable.number3))
            repository.insert(PunchedHoles(four.id, R.drawable.number4))
            repository.insert(PunchedHoles(five.id, R.drawable.number5))
            repository.insert(PunchedHoles(six.id, R.drawable.number6))
            repository.insert(PunchedHoles(seven.id, R.drawable.number7))
            repository.insert(PunchedHoles(eight.id, R.drawable.number8))
            repository.insert(PunchedHoles(nine.id, R.drawable.number9))
            repository.insert(PunchedHoles(ten.id, R.drawable.number10))
            repository.insert(PunchedHoles(11, 0))
            allHoles = repository.allPunchedHoles as ArrayList<Int>

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

    fun holePunch(view: View){
        val button: ImageButton = view as ImageButton
        val buttonId: Int = button.id
        val newPicture: Int = holePunchedImages.random()
        button.setImageResource(newPicture)
        repository.update(PunchedHoles(buttonId, newPicture))
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
    //TODO find images to use, find confetti animation, add encouraging texts
}