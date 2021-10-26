package com.example.lab_3_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab_3_2.databinding.AboutActivityBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: AboutActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AboutActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}