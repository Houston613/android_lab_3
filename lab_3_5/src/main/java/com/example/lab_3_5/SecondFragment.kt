package com.example.lab_3_5

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.lab_3_5.databinding.FirstFragBinding
import com.example.lab_3_5.databinding.SecondFragBinding

class SecondFragment: Fragment() {
    private lateinit var binding: SecondFragBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        binding = SecondFragBinding.inflate(layoutInflater)
        val navController = findNavController()
        binding.button2To1.setOnClickListener {
            navController.navigate(R.id.action_second_fragment_to_first_fragment)
        }
        binding.button2To3.setOnClickListener {
            navController.navigate(R.id.action_second_fragment_to_third_fragment)
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