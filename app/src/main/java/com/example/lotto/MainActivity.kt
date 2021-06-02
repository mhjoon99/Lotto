package com.example.lotto

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import java.util.*
import kotlin.collections.ArrayList

fun getRandomLottoNumber () : Int{
    return Random().nextInt(45)+1
}
fun getRandomLottoNumbers(): MutableList<Int> {
    val lottoNumbers = mutableListOf<Int>()
    while(true) {
        var number = getRandomLottoNumber()
        var flag_exist = 0

        if(lottoNumbers.size < 1){
            lottoNumbers.add(number)
            continue
        } else {
            for (j in 0 until lottoNumbers.size) {
                if (number == lottoNumbers[j])
                    flag_exist = 1
                break
            }
        }
        if (flag_exist == 0)
            lottoNumbers.add(number)
        if(lottoNumbers.size >= 6)
            break
    }
    return lottoNumbers
}

fun getShuffledLottoNumbers(): MutableList<Int>{
    val lottoNumbers = mutableListOf<Int>()

    for(number in 1..45){
        lottoNumbers.add(number)
    }
    lottoNumbers.shuffle()

    return lottoNumbers.subList(0,6)
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //변수 선언
        val cardRandom = findViewById<CardView>(R.id.CardRandom)
        val cardConstell = findViewById<CardView>(R.id.CardConstell)
        val cardName = findViewById<CardView>(R.id.CardName)

        //cardView에 버튼 이벤트 추가
        cardRandom.setOnClickListener {
            startActivity(Intent(this@MainActivity, ResultActivity::class.java))
            val intent = Intent(this, ResultActivity::class.java)
//            intent.putIntegerArrayListExtra("result", ArrayList(getRandomLottoNumbers()))
            intent.putIntegerArrayListExtra("result",ArrayList(getShuffledLottoNumbers()))
            startActivity(intent)
        }
        cardConstell.setOnClickListener {
            startActivity(Intent(this@MainActivity, ConstellationActivity::class.java))
        }
        cardName.setOnClickListener {
            startActivity(Intent(this@MainActivity, NameActivity::class.java))
        }


    }
}