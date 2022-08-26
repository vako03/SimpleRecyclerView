package com.example.simplerecyclerview

import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.simplerecyclerview.databinding.FragmentBookDetailsBinding
import com.example.simplerecyclerview.databinding.FragmentBookListBinding

class BooksDetailsFragment: Fragment() {
    private  var _binding:FragmentBookDetailsBinding? = null
    val MYANOTHERTAG ="memo"
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val bookName = requireArguments().getString(KEY1)
        val bookPoster = requireArguments().getString(KEY2)

        binding.tvBookName.text = bookName
        Glide.with(requireContext()).load(bookPoster).into(binding.ivBigPoster)

    }
    companion object {
        const val KEY1="ARGUMENT_KEY1"
        const val KEY2="ARGUMENT_KEY2"

        fun newInstance(bookName:String, posterImage:String):BooksDetailsFragment{
            return  BooksDetailsFragment().apply {
                arguments = bundleOf(KEY1 to bookName, KEY2 to posterImage )
            }
        }
    }
}