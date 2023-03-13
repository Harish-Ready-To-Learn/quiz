package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quizapp.Result
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {

    private var Name:String ?= null
    private var score:Int = 0
    private var current_position: Int = 1
    private var questionList:ArrayList<QuestionData> ?= null
    private var selected_option: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        Name = intent.getStringExtra(setData.name)
        questionList = setData.getQuestion()

        setQuestion()

        tvOption_1.setOnClickListener{
            selectedOptionStyle(tvOption_1 , 1)
        }
        tvOption_2.setOnClickListener{
            selectedOptionStyle(tvOption_2 , 2)
        }
        tvOption_3.setOnClickListener{
            selectedOptionStyle(tvOption_3 , 3)
        }
        tvOption_4.setOnClickListener{
            selectedOptionStyle(tvOption_4 , 4)
        }

        btnSubmit.setOnClickListener {
            if(selected_option != 0)
            {
                val question = questionList!![current_position - 1]
                if(selected_option != question.correct_ans )
                {
                    setColor(selected_option , R.drawable.wrong_option)
                }else{
                    score++
                }
                setColor(question.correct_ans , R.drawable.correct_option)
                if(current_position == questionList!!.size)
                {
                    btnSubmit.text = "FINISH"
                }else{
                    btnSubmit.text = "GO TO NEXT"
                }
            }else{
                current_position++
                when{
                    current_position <= questionList!!.size -> {
                        setQuestion()
                    }
                    else -> {
                        var intent = Intent(this, Result::class.java)
                        intent.putExtra(setData.name , Name.toString())
                        intent.putExtra(setData.score , score.toString())
                        intent.putExtra("total_question" , questionList!!.size.toString())
                        startActivity(intent)
                        finish()
                    }
                }
            }
            selected_option = 0

        }

    }



    fun setQuestion(){
        val  question = questionList!![current_position - 1]
        setOptionStyle()
        progress_bar.progress = current_position
        progress_bar.max = questionList!!.size
        progress_text.text = "${current_position}"+"/"+"${questionList!!.size}"
        tvQuestion.text = question.question
        tvOption_1.text = question.option_one
        tvOption_2.text = question.option_two
        tvOption_3.text = question.option_three
        tvOption_4.text = question.option_four
    }

    fun setOptionStyle(){
        var optionList:ArrayList<TextView> = arrayListOf()
        optionList.add(0,tvOption_1)
        optionList.add(1,tvOption_2)
        optionList.add(2,tvOption_3)
        optionList.add(3,tvOption_4)

        for(op in optionList){
            op.setTextColor(Color.parseColor("#555151"))
            op.background = ContextCompat.getDrawable(this,R.drawable.question_option)
            op.typeface = Typeface.DEFAULT
        }
    }

    fun selectedOptionStyle(view:TextView, option:Int){
        setOptionStyle()
        selected_option = option
        view.background = ContextCompat.getDrawable(this, R.drawable.selected_option)
        view.typeface = Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))
    }

    fun setColor(opt : Int , color : Int){
        when(opt){
            1 -> {
                tvOption_1.background = ContextCompat.getDrawable(this, color)
            }
            2 -> {
                tvOption_2.background = ContextCompat.getDrawable(this, color)
            }
            3 -> {
                tvOption_3.background = ContextCompat.getDrawable(this, color)
            }
            4 -> {
                tvOption_4.background = ContextCompat.getDrawable(this, color)
            }
        }
    }
}