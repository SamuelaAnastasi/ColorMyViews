package com.example.android.colormyviews

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

   lateinit var colorsList : List<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        colorsList = listOf(R.color.redM, R.color.yellowM, R.color.greenM, R.color.blueM,
                R.color.violet, R.color.aqua, R.color.grass, R.color.sand, R.color.brightRed,
                R.color.brightYellow, R.color.brightBlue, R.color.brightViolet, R.color.darkGreen,
                R.color.grey, R.color.lightGrey)
        setListeners()

    }

    private fun setListeners() {
        val clickableViews : List<View> =
                listOf(box1, box2, box3, box4, box5, box6, box7,
                        buttonRed, buttonGreen, buttonBlue, buttonYellow, buttonReset)
//
        for(item in clickableViews) {
            val rand = Random().nextInt(15)
            item.setOnClickListener {makeColored(it, rand)}
        }
    }

    private fun makeColored(view: View, rand: Int) {

        when(view.id) {
            R.id.box1 -> view.setBackgroundResource(colorsList[rand])
            R.id.box2 -> view.setBackgroundResource(colorsList[rand])
            R.id.box3 -> view.setBackgroundResource(colorsList[rand])
            R.id.box4 -> view.setBackgroundResource(colorsList[rand])
            R.id.box5 -> view.setBackgroundResource(colorsList[rand])
            R.id.box6 -> view.setBackgroundResource(colorsList[rand])
            R.id.box7 -> view.setBackgroundResource(colorsList[rand])

            R.id.buttonRed -> box3.setBackgroundResource(R.color.redM)
            R.id.buttonBlue -> box4.setBackgroundResource(R.color.blueM)
            R.id.buttonYellow -> box7.setBackgroundResource(R.color.yellowM)
            R.id.buttonReset -> makeBulkColored()
            else -> {
                box1.setBackgroundResource(R.color.greenM)
                box2.setBackgroundResource(R.color.greenM)
                box5.setBackgroundResource(R.color.greenM)
                box6.setBackgroundResource(R.color.greenM)
            }
        }
    }

    private fun makeBulkColored() {
        val clickableViews : List<View> =
                listOf(box1, box2, box3, box4, box5, box6, box7)
        for (view:View in clickableViews) {
            view.setBackgroundResource(R.color.grey)
        }
    }
}
