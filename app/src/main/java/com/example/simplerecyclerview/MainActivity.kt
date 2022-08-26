package com.example.simplerecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.simplerecyclerview.adapters.Book
import com.example.simplerecyclerview.adapters.BooksAdapter
import com.example.simplerecyclerview.databinding.ActivityMainBinding
import com.example.simplerecyclerview.databinding.LayoutBookItemBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bookListFragment = BookListFragment()
        val booksDetailsFragment = BooksDetailsFragment()

        binding.buttonFragmentList.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragments,bookListFragment)
                addToBackStack(bookListFragment::class.java.name)
                commit()
            }
        }

        binding.buttonFragmentDetails.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragments,booksDetailsFragment)
                addToBackStack("fragment 2")

                commit()
    }
        }
        }
}
