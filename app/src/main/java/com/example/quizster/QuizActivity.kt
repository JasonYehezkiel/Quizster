package com.example.quizster

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.quizster.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizBinding
    private lateinit var questions: List<Questions>
    private var index = 0
    private var score = 0
    private var helpUsed = 0
    private var helpLimit = 3

    private var helpUsedOnCurrentQuestion = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)


        questions = QuizBanks.getRandomQuestions(10)

        savedInstanceState?.let {
            index = it.getInt("index", 0)
            score = it.getInt("score", 0)
            helpUsed = it.getInt("helpUsed", 0)
            helpUsedOnCurrentQuestion = it.getBoolean("helpUsedOnCurrentQuestion", false)
        }

        showQuestions()

        binding.btnTrue.setOnClickListener { checkAnswer(true) }
        binding.btnFalse.setOnClickListener { checkAnswer(false) }
        binding.btnHelp.setOnClickListener { showHelp() }

    }

    private fun showQuestions() {
        if (index < questions.size) {
            val q = questions[index]
            binding.tvQuestions.text = q.text
            binding.tvProgress.text = getString(R.string.quiz_progress, index + 1, questions.size)
        }
    }

    private fun nextQuestion() {
        index++
        helpUsedOnCurrentQuestion = false

        if (index >= questions.size) {
            val intent = Intent(this, ScoreActivity::class.java)
            intent.putExtra("score", score)
            intent.putExtra("total", questions.size)
            startActivity(intent)
            finish()
        } else {
            showQuestions()
        }
    }

    private fun animateFeedback(message: String, colorRes: Int, next: Boolean = true) {
        binding.tvFeedback.text = message
        binding.tvFeedback.setTextColor(getColor(colorRes))
        binding.tvFeedback.alpha = 0f

        binding.tvFeedback.animate().alpha(1f).setDuration(250).withEndAction {
            binding.tvFeedback.postDelayed({
                binding.tvFeedback.animate().alpha(0f).setDuration(250).withEndAction {
                    if (next) nextQuestion()
                }.start()
            }, 500)
        }.start()
    }


    private fun checkAnswer(userAnswer: Boolean) {
        if (index  >= questions.size) return
        val correct = questions[index].answer
        if (userAnswer == correct) {
            score++
            animateFeedback("Benar!", R.color.soft_mint)
        } else {
            animateFeedback("Salah!", R.color.red)
        }
    }

    private fun showHelp() {

        if (helpUsedOnCurrentQuestion) {
            animateFeedback("Bantuan sudah digunakan untuk soal ini!", R.color.cyan_blue, next = false)
            return
        }

        if (helpUsed >= helpLimit) {
            animateFeedback("Kesempatan bantuan sudah habis.", R.color.cyan_blue, next = false)
            return
        }
        helpUsed++
        helpUsedOnCurrentQuestion = true

        val correct = questions[index].answer
        val answerText = if (correct)"True (T)" else "False (F)"
        AlertDialog.Builder(this)
            .setTitle("Bantuan Jawaban")
            .setMessage("Jawaban: $answerText\n\nSisa bantuan: ${helpLimit - helpUsed}")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("index", index)
        outState.putInt("score", score)
        outState.putInt("helpUsed", helpUsed)
        outState.putBoolean("helpUsedOnCurrentQuestion", helpUsedOnCurrentQuestion)
        super.onSaveInstanceState(outState)
    }

}
