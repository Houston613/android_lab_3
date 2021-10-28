package com.example.lab3_4

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.lab3_4.databinding.SecondActivityBinding

class SecondActivity :AppCompatActivity() {

    private val codeFromThird = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = SecondActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button2To1.setOnClickListener { toFirstActivity() }
        binding.button2To3.setOnClickListener { toThirdActivity() }
    }

    private fun toFirstActivity() {
        startActivity(Intent(this, FirstActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
    }

    private fun toThirdActivity() {
        startActivity(Intent(this, ThirdActivity::class.java))
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