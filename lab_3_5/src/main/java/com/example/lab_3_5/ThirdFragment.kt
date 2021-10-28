package com.example.lab_3_5

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.lab_3_5.databinding.FirstFragBinding
import com.example.lab_3_5.databinding.ThirdFragBinding

class ThirdFragment :Fragment() {
    private lateinit var binding: ThirdFragBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        binding = ThirdFragBinding.inflate(layoutInflater)
        val navController = findNavController()
        binding.button3To1.setOnClickListener {
            navController.navigate(R.id.action_third_fragment_to_first_fragment)
        }
        binding.button3To2.setOnClickListener {
            navController.navigate(R.id.action_third_fragment_to_second_fragment)
        }
        return binding.root

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.first_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.about) {
            Navigation.findNavController(binding.root).navigate(R.id.global_about)
            true
        } else
            super.onOptionsItemSelected(item)
    }
}