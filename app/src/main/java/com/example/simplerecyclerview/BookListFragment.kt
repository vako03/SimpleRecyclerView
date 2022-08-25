package com.example.simplerecyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.simplerecyclerview.adapters.Book
import com.example.simplerecyclerview.adapters.BooksAdapter
import com.example.simplerecyclerview.databinding.FragmentBookListBinding

class BookListFragment:Fragment() {
    private  var _binding:FragmentBookListBinding? = null
    private  val booksAdapter= BooksAdapter()


    private  val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookListBinding.inflate(inflater, container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
        binding.tvDelete.setOnClickListener{
            booksAdapter.deleteItem(0)
        }
        binding.tvAdd.setOnClickListener{
            val book = Book("Book Lovers","https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1638867089l/58690308.jpg")
            booksAdapter.insertItem(book,1)


        }
        booksAdapter.setOnItemClickListener {
            Toast.makeText(requireContext(),it.bookName, Toast.LENGTH_LONG).show()
        }
        binding.tvUpdate.setOnClickListener {
            booksAdapter.updateItemAt(0,booksAdapter.bookList[0].copy(posterImage ="data:image/jpeg;base64,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" ))
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}