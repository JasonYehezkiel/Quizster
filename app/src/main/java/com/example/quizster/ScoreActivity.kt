package com.example.quizster

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quizster.databinding.ActivityScoreBinding

class ScoreActivity: AppCompatActivity() {

    private lateinit var binding: ActivityScoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)

        binding.tvResult.text = getString(R.string.score_total,  score, total)

        if (score >= 6) {
            binding.tvResultMessage.text = getString(R.string.you_won)
            binding.ivResultIcon.setImageResource(R.drawable.ic_trophy)
        } else {
            binding.tvResultMessage.text = getString(R.string.you_lost)
            binding.ivResultIcon.setImageResource(R.drawable.ic_sad)
        }

        binding.btnPlayAgain.setOnClickListener {
            startActivity(Intent(this, QuizActivity::class.java))
            finish()
        }

        binding.btnBackToMenu.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
}