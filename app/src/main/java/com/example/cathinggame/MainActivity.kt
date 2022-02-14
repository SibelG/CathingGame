package com.example.cathinggame



import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.*
import kotlin.collections.ArrayList
import androidx.cardview.widget.CardView
import kotlin.collections.RandomAccess


class MainActivity : AppCompatActivity() {

    var score = 0
    var score2=0
    lateinit var list:List<ImageView>
    var imageArray = ArrayList<ImageView>()
    var tomArray=ArrayList<ImageView>()




    var handler = Handler(Looper.getMainLooper())
    var runnable = Runnable {  }
    lateinit var imageView:ImageView
    lateinit var imageView2:ImageView
    lateinit var imageView3:ImageView
    lateinit var imageView4:ImageView
    lateinit var imageView5:ImageView
    lateinit var imageView6:ImageView
    lateinit var imageView7:ImageView
    lateinit var imageView8:ImageView
    lateinit var imageView9:ImageView
    lateinit var imageView10:ImageView
    lateinit var imageView11:ImageView
    lateinit var imageView12:ImageView
    lateinit var imageView13:ImageView
    lateinit var imageView14:ImageView
    lateinit var imageView15:ImageView
    lateinit var imageView16:ImageView
    lateinit var imageView17:ImageView
    lateinit var imageView18:ImageView
    lateinit var imageView19:ImageView
    lateinit var imageView20:ImageView
    lateinit var imageView21:ImageView
    lateinit var imageViewPc:ImageView
    lateinit var imageView23:ImageView
    lateinit var imageView24:ImageView
    lateinit var imageView25:ImageView
    lateinit var winPlayer:TextView

    lateinit var timeText:TextView
    lateinit var scoreText:TextView
    lateinit var scoreText2:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ImageArray


        initializer()

        hideImages()

        //CountDown Timer


        object : CountDownTimer(25500,1000){
            override fun onFinish() {

                timeText.text = "Time: 0"

                handler.removeCallbacks(runnable)

                for (image in imageArray) {
                    image.visibility = View.INVISIBLE
                }
                for (img in tomArray) {
                    img.visibility = View.INVISIBLE
                }

                val alert = AlertDialog.Builder(this@MainActivity)

                alert.setTitle("Game Over")
                alert.setMessage("Restart The Game?")

                winPlayer.visibility=View.VISIBLE
                if(score>score2)
                    winPlayer.text="You are won!!"
                else if(score<score2)
                    winPlayer.text="Computer won!!"
                else
                    winPlayer.text="Quits"

                alert.setPositiveButton("Yes") {dialog, which ->
                    //Restart
                    val intent = intent
                    finish()
                    startActivity(intent)



                }

                alert.setNegativeButton("No") {dialog, which ->
                    Toast.makeText(this@MainActivity,"Game Over",Toast.LENGTH_LONG).show()



                }

                alert.show()


            }

            override fun onTick(millisUntilFinished: Long) {
                timeText.text = "Time: " + millisUntilFinished/1000
            }

        }.start()

    }

    fun initializer(){
        imageView=findViewById(R.id.imageView)
        imageView2=findViewById(R.id.imageView2)
        imageView3=findViewById(R.id.imageView3)
        imageView4=findViewById(R.id.imageView4)
        imageView5=findViewById(R.id.imageView5)
        imageView6=findViewById(R.id.imageView6)
        imageView7=findViewById(R.id.imageView7)
        imageView8=findViewById(R.id.imageView8)
        imageView9=findViewById(R.id.imageView9)
        imageView10=findViewById(R.id.imageView10)
        imageView11=findViewById(R.id.imageView11)
        imageView12=findViewById(R.id.imageView12)
        imageView13=findViewById(R.id.imageView13)
        imageView14=findViewById(R.id.imageView14)
        imageView15=findViewById(R.id.imageView15)
        imageView16=findViewById(R.id.imageView16)
        imageView17=findViewById(R.id.imageView17)
        imageView18=findViewById(R.id.imageView18)
        imageView19=findViewById(R.id.imageView19)
        imageView20=findViewById(R.id.imageView20)
        imageView21=findViewById(R.id.imageView21)
        imageViewPc=findViewById(R.id.imageView22)
        imageView23=findViewById(R.id.imageView23)
        imageView24=findViewById(R.id.imageView24)
        imageView25=findViewById(R.id.imageView25)

        timeText=findViewById(R.id.timeText)
        scoreText=findViewById(R.id.scoreText)
        scoreText2=findViewById(R.id.scoreText2)
        winPlayer=findViewById(R.id.WinPlayer)

        imageArray.add(imageViewPc)
        imageArray.add(imageView)
        imageArray.add(imageView2)
        imageArray.add(imageView3)
        imageArray.add(imageView4)
        imageArray.add(imageView5)
        imageArray.add(imageView6)
        imageArray.add(imageView7)
        imageArray.add(imageView8)
        imageArray.add(imageView9)
        imageArray.add(imageView10)
        imageArray.add(imageView11)
        imageArray.add(imageView12)
        imageArray.add(imageView13)
        imageArray.add(imageView14)
        imageArray.add(imageView15)
        imageArray.add(imageView16)
        imageArray.add(imageView17)
        imageArray.add(imageView18)
        imageArray.add(imageView19)
        imageArray.add(imageView20)
        imageArray.add(imageView21)
        imageArray.add(imageView23)
        imageArray.add(imageView24)
        imageArray.add(imageView25)
        imageArray.add(imageView21)

        val rng = Random()
        val generated: MutableList<Int> = ArrayList()
        for (i in 0..24) {
                val next = rng.nextInt(15)
                if (!generated.contains(next)) {
                    generated.add(next)
                    val iv = imageArray[i] as ImageView
                    tomArray.add(iv)

          }
        }

        System.out.println("tomt"+tomArray)

 }

    fun hideImages() {

        runnable = object : Runnable {
            override fun run() {
                for (image in imageArray) {
                    image.visibility = View.INVISIBLE
                }
                for (image in tomArray) {
                    image.visibility = View.INVISIBLE
                }



                val random = Random()
                val randomIndex = random.nextInt(25)
                imageArray[randomIndex].visibility = View.VISIBLE

                val randomTom = random.nextInt(15)
                for((x,deger)in tomArray.withIndex()) {
                    if(tomArray[x]==imageArray[randomIndex]){
                        tomArray[x].visibility = View.VISIBLE
                        tomArray[x].setImageResource(R.drawable.tom1)
                        score2+=3
                        scoreText2.text="Score:$score2"

                    }

                }

                handler.postDelayed(runnable,1000)


            }

        }

        handler.post(runnable)

    }



    fun increaseScore(view: View){

        score+=3
        scoreText.text = "Score: $score"



    }




}






