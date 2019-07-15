package com.example.kotlintictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var xIsNext: Boolean = true
    var counter: Int = 0
    val winnerArray: Array<IntArray> = arrayOf(
        intArrayOf(0, 1, 2),
        intArrayOf(3, 4, 5),
        intArrayOf(6, 7, 8),

        intArrayOf(0, 3, 6),
        intArrayOf(1, 4, 7),
        intArrayOf(2, 5, 8),

        intArrayOf(0, 4, 8),
        intArrayOf(2, 4, 6)
    )
    var actualArray = CharArray(9)
    var finished: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titleTextView = findViewById<TextView>(R.id.titleText)
        titleTextView.text = "Als nächstes: " + if(xIsNext) "X" else "O"
    }

    fun setText(view: View) {

        if(!finished) {
            val titleTextView = findViewById<TextView>(R.id.titleText)

            when (view.id) {
                R.id.textView1 -> actualArray[0] = if (xIsNext) 'X' else 'O'
                R.id.textView2 -> actualArray[1] = if (xIsNext) 'X' else 'O'
                R.id.textView3 -> actualArray[2] = if (xIsNext) 'X' else 'O'
                R.id.textView4 -> actualArray[3] = if (xIsNext) 'X' else 'O'
                R.id.textView5 -> actualArray[4] = if (xIsNext) 'X' else 'O'
                R.id.textView6 -> actualArray[5] = if (xIsNext) 'X' else 'O'
                R.id.textView7 -> actualArray[6] = if (xIsNext) 'X' else 'O'
                R.id.textView8 -> actualArray[7] = if (xIsNext) 'X' else 'O'
                R.id.textView9 -> actualArray[8] = if (xIsNext) 'X' else 'O'
            }

            val textView = findViewById<TextView>(view.id)
            if (textView.text.isEmpty()) {
                if (xIsNext) {
                    textView.text = "X"
                    xIsNext = false
                    titleTextView.text = "Als nächstes: O"
                } else {
                    textView.text = "O"
                    xIsNext = true
                    titleTextView.text = "Als nächstes: X"
                }
            }

            val winnerTextView = findViewById<TextView>(R.id.winnerText)

            if (checkWinner()) {
                winnerTextView.text = "Gewonnen hat: " + if (xIsNext) "O" else "X"
                finished = true
            }

            counter++;
            if (counter == 9) {
                winnerTextView.text = "Unentschieden"
            }
        }

    }

    fun resetGame(view: View) {

        finished = false
        xIsNext = true

        val winnerTextView = findViewById<TextView>(R.id.winnerText)
        winnerTextView.text = ""

        val textView1 = findViewById<TextView>(R.id.textView1)
        val textView2 = findViewById<TextView>(R.id.textView2)
        val textView3 = findViewById<TextView>(R.id.textView3)
        val textView4 = findViewById<TextView>(R.id.textView4)
        val textView5 = findViewById<TextView>(R.id.textView5)
        val textView6 = findViewById<TextView>(R.id.textView6)
        val textView7 = findViewById<TextView>(R.id.textView7)
        val textView8 = findViewById<TextView>(R.id.textView8)
        val textView9 = findViewById<TextView>(R.id.textView9)

        textView1.text = ""
        textView2.text = ""
        textView3.text = ""
        textView4.text = ""
        textView5.text = ""
        textView6.text = ""
        textView7.text = ""
        textView8.text = ""
        textView9.text = ""

        val titleTextView = findViewById<TextView>(R.id.titleText)
        titleTextView.text = "Als nächstes: X"

        actualArray = CharArray(9)

        counter = 0

    }

    private fun checkWinner(): Boolean {

        for(item in winnerArray) {
            val a = item[0]
            val b = item[1]
            val c = item[2]

            if(actualArray[a].isLetter() && actualArray[a] == actualArray[b] && actualArray[a] == actualArray[c]) {
                return true
            }
        }

        return false
    }


}
