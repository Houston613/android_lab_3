package com.example.lab3_4

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.lab3_4.databinding.ThirdActivityBinding

class ThirdActivity :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ThirdActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button3To1.setOnClickListener { toFirstActivity() }
        binding.button3To2.setOnClickListener { toSecondActivity() }
    }

    private fun toFirstActivity() {
        setResult(RESULT_OK)
        finish()
    }

    private fun toSecondActivity() {
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.first_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.about) {
            startActivity(Intent(this, AboutActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY))
            return true
        }
        else
            return super.onOptionsItemSelected(item)
    }
}