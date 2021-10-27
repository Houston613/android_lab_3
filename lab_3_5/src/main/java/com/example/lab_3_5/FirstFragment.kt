package com.example.lab_3_5
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.lab_3_5.databinding.FirstFragBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FirstFragBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        binding = FirstFragBinding.inflate(layoutInflater)
        val navController = findNavController()
        binding.button1To2.setOnClickListener {
            navController.navigate(R.id.action_first_fragment_to_second_fragment)
        }
        return binding.root

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.first_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.about) {
            Navigation.findNavController(binding.root)
            true
        } else
            super.onOptionsItemSelected(item)
    }
}