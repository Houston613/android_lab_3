package com.example.lab_3_2

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.lab_3_2.databinding.FirstActivityBinding
//adb shell dumpsys activity activities | grep 'Hist #' | grep 'com.example.lab32'

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = FirstActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1To2.setOnClickListener{toSecondActivity()}
    }

    private fun toSecondActivity() {
        startActivity(Intent(this, SecondActivity::class.java))//возращает класс
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.first_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.about) {
            startActivity(Intent(this, AboutActivity::class.java))
            true
        } else
            super.onOptionsItemSelected(item)
    }
}
