package com.example.quizapp

object setData {

    const val name:String = "Name"
    const val score:String = "0"

    fun getQuestion():ArrayList<QuestionData>{
        var que:ArrayList<QuestionData> = arrayListOf()
        var q1 = QuestionData(
            "What is the capital of India?",
            1,
            "Tamil Nadu",
            "New Delhi",
            "Madhya Pradesh",
            "Gujarat",
            2
        )
        var q2 = QuestionData(
            "What is the National Animal of India?",
            2,
            "Lion",
            "Elephant",
            "Tiger",
            "Kangaroo",
            3
        )
        var q3 = QuestionData(
            "What is the National Bird of India?",
            3,
            "Peacock",
            "Sparrow",
            "Eagle",
            "Parrot",
            1
        )
        var q4 = QuestionData(
            "Which place is the Silicon Valley of India?",
            4,
            "Chennai",
            "Mumbai",
            "Hyderabad",
            "Bangalore",
            4
        )
        var q5 = QuestionData(
            "Who is the first Prime Minister of India?",
            5,
            "Mahatma Gandhi",
            "Jawaharlal Nehru",
            "Sardar Vallabhai Patel",
            "Dr.A.P.J.Abdul Kalam",
            2
        )

        que.add(q1)
        que.add(q2)
        que.add(q3)
        que.add(q4)
        que.add(q5)
        return que
    }
}