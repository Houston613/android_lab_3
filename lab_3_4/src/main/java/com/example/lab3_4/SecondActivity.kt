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
        setResult(RESULT_OK)
        finish()
    }

    private fun toThirdActivity() {
        startActivityForResult(Intent(this, ThirdActivity::class.java), codeFromThird)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == codeFromThird) {
            if (resultCode == RESULT_OK) {
                finish()
            }
        }
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