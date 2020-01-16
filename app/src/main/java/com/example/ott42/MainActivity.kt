package com.example.ott42

import android.animation.AnimatorInflater
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.AnimatedVectorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var avd: AnimatedVectorDrawable
    private lateinit var avd1: AnimatedVectorDrawable
    private lateinit var avd2: AnimatedVectorDrawable
    private lateinit var avd3: AnimatedVectorDrawable
    private lateinit var avd4: AnimatedVectorDrawable
    private lateinit var avd5: AnimatedVectorDrawable
    private lateinit var avd6: AnimatedVectorDrawable
    var counter = 0


    private val coroutineScope = CoroutineScope(Dispatchers.Main)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initSystem()

        prepareImageview(0)

        writeWord()

        //   AnimareWord()
    }

    private fun initSystem() {
        val width=150
        val height=150

        mainLayout.setBackgroundColor(Color.BLACK)
        setGodel(imageView1,height,width)
        setGodel(imageView2,height,width)
        setGodel(imageView3,height,width)
        setGodel(imageView4,height,width)
        setGodel(imageView5,height,width)
        setGodel(imageView6,height,width)

        setMarginsInDp(word1Layout,0,0,0,450)
        secialSetup()

        setMarginsInDp(imageView1,0,0,125,0)
        setMarginsInDp(imageView2,0,0,185,0)
        setMarginsInDp(imageView3,0,0,240,0)
        setMarginsInDp(imageView4,0,0,280,0)
        setMarginsInDp(imageView5,0,0,335,0)
        setMarginsInDp(imageView6,0,0,385,0)



    }

    private fun secialSetup() {
        // imageView6.scaleX=0.7f
    }

    fun setGodel(view: View, height:Int, width:Int){
        view.layoutParams.height=height.toPx()
        view.layoutParams.width=width.toPx()
        view.requestLayout()
    }

    fun setMarginsInDp(view: View, left: Int, top: Int, right: Int, bottom: Int){
        if(view.layoutParams is ViewGroup.MarginLayoutParams){
            val screenDesity: Float = view.context.resources.displayMetrics.density
            val params: ViewGroup.MarginLayoutParams = view.layoutParams as ViewGroup.MarginLayoutParams
            params.setMargins(left*screenDesity.toInt(), top*screenDesity.toInt(), right*screenDesity.toInt(), bottom*screenDesity.toInt())
            view.requestLayout()
        }
    }




    fun Int.toPx():Int=(this* Resources.getSystem().displayMetrics.density).toInt()

    private fun AnimareWord() {
        val anim = AnimatorInflater.loadAnimator(this, R.animator.set)
        GlobalScope.launch(Dispatchers.Main) {
            // moveWord()
            delay(10000)

            anim?.apply {
                setTarget(word1Layout)
                start()
            }
        }
    }

    fun writeWord() {
        GlobalScope.launch {letter1()}
        GlobalScope.launch {letter2()}
        GlobalScope.launch {letter3()}
        GlobalScope.launch {letter4()}
        GlobalScope.launch {letter5()}
        GlobalScope.launch {letter6()}
        // GlobalScope.launch {moveWord()}

    }

    suspend fun letter1(){
        delay(1)
        GlobalScope.launch(Dispatchers.Main) {
            imageView1.visibility = View.VISIBLE
            imageView1.setImageResource(R.drawable.bet0)
            avd1 = imageView1.drawable as AnimatedVectorDrawable
            avd1.start()
        }
    }

    suspend fun letter2(){
        delay(1000)
        GlobalScope.launch(Dispatchers.Main) {
            imageView2.visibility = View.VISIBLE
            imageView2.setImageResource(R.drawable.yod0)
            avd2 = imageView2.drawable as AnimatedVectorDrawable
            avd2.start()
        }
    }
    suspend fun letter3(){
        delay(2000)
        GlobalScope.launch(Dispatchers.Main) {
            imageView3.visibility = View.VISIBLE
            imageView3.setImageResource(R.drawable.non0)
            avd3 = imageView3.drawable as AnimatedVectorDrawable
            avd3.start()
        }
    }
    suspend fun letter4(){
        delay(3000)
        GlobalScope.launch(Dispatchers.Main) {

            imageView4.setImageResource(R.drawable.yod0)
            avd4 = imageView4.drawable as AnimatedVectorDrawable
            imageView4.visibility = View.VISIBLE
            avd4.start()
        }
    }
    suspend fun letter5(){
        delay(4000)
        GlobalScope.launch(Dispatchers.Main) {
            imageView5.visibility = View.VISIBLE
            imageView5.setImageResource(R.drawable.non0)
            avd5 = imageView5.drawable as AnimatedVectorDrawable
            avd5.start()
        }
    }

    suspend fun letter6(){
        delay(5000)
        GlobalScope.launch(Dispatchers.Main) {
            imageView6.setImageResource(R.drawable.vav00)
            avd6 = imageView5.drawable as AnimatedVectorDrawable
            imageView6.visibility = View.VISIBLE
            avd6.start()

        }
    }

    private suspend fun moveWord() {
        delay(7000)
        val anim = AnimatorInflater.loadAnimator(this, R.animator.set)
        GlobalScope.launch(Dispatchers.Main) {
            anim?.apply {
                setTarget(word1Layout)
                start()
            }
        }

    }



    private fun prepareImageview(ind: Int) {
        if (ind == 0) {
            imageView1.visibility = View.INVISIBLE
            imageView2.visibility = View.INVISIBLE
            imageView3.visibility = View.INVISIBLE
            imageView4.visibility = View.INVISIBLE
            imageView5.visibility = View.INVISIBLE
            imageView6.visibility = View.INVISIBLE
        } else {
            imageView1.visibility = View.VISIBLE
            imageView2.visibility = View.VISIBLE
            imageView3.visibility = View.VISIBLE
            imageView4.visibility = View.VISIBLE
            imageView5.visibility = View.VISIBLE
            imageView6.visibility = View.VISIBLE
        }
    }


}
