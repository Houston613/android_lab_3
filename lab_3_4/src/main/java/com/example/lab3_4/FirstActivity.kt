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

import kotlin.random.Random.Default.nextInt

//adb shell dumpsys activity activities | grep 'Hist #' | grep 'com.example.lab3_4'

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = FirstActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.random.setOnClickListener{toRandom()}
    }

    private fun toRandom(){
        val random = nextInt(3)
        when(random){
            0 -> startActivity(Intent(this,
                FirstActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP))
            1 -> startActivity(Intent(this, SecondActivity::class.java))
            2 -> startActivity(Intent(this,ThirdActivity::class.java))

        }
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
