package com.example.lab3_4

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.content.Intent.FLAG_ACTIVITY_NO_HISTORY
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.lab3_4.databinding.FirstActivityBinding
//adb shell dumpsys activity activities | grep 'Hist #' | grep 'com.example.lab3_4'

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = FirstActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button1To2.setOnClickListener{toSecondActivity()}
    }

    private fun toSecondActivity() {
        startActivity(Intent(this, SecondActivity::class.java))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.first_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.about) {
            startActivity(Intent(this, AboutActivity::class.java).addFlags(FLAG_ACTIVITY_NO_HISTORY))
            true
        } else
            super.onOptionsItemSelected(item)
    }
}
