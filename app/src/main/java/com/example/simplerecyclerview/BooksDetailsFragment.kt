package com.example.simplerecyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.simplerecyclerview.databinding.FragmentBookDetailsBinding
import com.example.simplerecyclerview.databinding.FragmentBookListBinding

class BooksDetailsFragment: Fragment() {
    private  var _binding:FragmentBookDetailsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }
}