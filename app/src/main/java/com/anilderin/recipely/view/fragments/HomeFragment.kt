package com.anilderin.recipely.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.anilderin.recipely.R
import com.anilderin.recipely.adapter.RecipelyAdapter
import com.anilderin.recipely.databinding.FragmentHomeBinding
import com.anilderin.recipely.viewmodel.RecipelyViewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var viewModel: RecipelyViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private var recipelyAdapter = RecipelyAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[RecipelyViewModel::class.java]



        binding.apply {
            rvFoodList.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            rvFoodList.adapter = recipelyAdapter

            button1.setOnClickListener {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment())
            }



        }

        viewModel.foodSearchLiveData.observe(viewLifecycleOwner) {
            it.meals?.let { it1 -> recipelyAdapter.setItems(it1) }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}