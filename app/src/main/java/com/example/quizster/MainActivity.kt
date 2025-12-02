package com.example.quizster

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.quizster.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val menuItems = arrayOf("Start New Quiz", "About", "Close the App")
    private val menuIcons = intArrayOf(
        R.drawable.ic_play_arrow,
        R.drawable.ic_info,
        R.drawable.ic_exit
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = object : ArrayAdapter<String>(
            this,
            R.layout.menu_item,
            R.id.tvMenuItem,
            menuItems
        ) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getView(position, convertView, parent)
                val icon = view.findViewById<ImageView>(R.id.ivMenuIcon)
                icon.setImageResource(menuIcons[position])
                return view
            }
        }
        binding.menuList.adapter = adapter

        binding.menuList.setOnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> startActivity(Intent(this, QuizActivity::class.java))
                1 -> startActivity(Intent(this, AboutActivity::class.java))
                2 -> finishAffinity()
            }
        }
    }
}