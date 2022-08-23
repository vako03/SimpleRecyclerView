package com.example.simplerecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simplerecyclerview.adapters.Book
import com.example.simplerecyclerview.adapters.BooksAdapter
import com.example.simplerecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private  val booksAdapter= BooksAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = booksAdapter

        booksAdapter.updateList(listOf(
            Book("Red, White & Royal Blue","https://covers.openlibrary.org/b/id/9171544-L.jpg"),
            Book("Funny Face","https://ia600606.us.archive.org/view_archive.php?archive=/21/items/olcovers66/olcovers66-L.zip&file=664163-L.jpg"),
            Book("Olfaction","https://ia800609.us.archive.org/view_archive.php?archive=/35/items/olcovers234/olcovers234-L.zip&file=2341517-L.jpg"),
            Book("Winifred Gerin","https://covers.openlibrary.org/b/id/8968056-L.jpg"),
            Book("Tennis Drills","https://covers.openlibrary.org/b/id/10246025-L.jpg"),
            Book("The 48 Laws of Power","https://covers.openlibrary.org/b/id/402210-L.jpg"),
            Book("Dwa szczęścia do wyboru","https://covers.openlibrary.org/b/id/12656202-L.jpg"),
            Book("It","https://covers.openlibrary.org/b/id/12670684-L.jpg"),
            Book("You Know Better","https://ia600802.us.archive.org/view_archive.php?archive=/8/items/olcovers2/olcovers2-L.zip&file=26439-L.jpg"),

        ))
    }
}