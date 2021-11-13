package com.example.lab_3_3

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.lab_3_3.databinding.ThirdActivityBinding

class ThirdActivity :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ThirdActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.button3To1.setOnClickListener { toFirstActivity() }
        binding.button3To2.setOnClickListener { toSecondActivity() }
    }

    private fun toFirstActivity() {
        startActivity(Intent(this, FirstActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
    }

    private fun toSecondActivity() {
        startActivity(Intent(this, SecondActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
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