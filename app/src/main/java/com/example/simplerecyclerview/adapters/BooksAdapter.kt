package com.example.simplerecyclerview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SortedList
import com.bumptech.glide.Glide
import com.example.simplerecyclerview.databinding.LayoutBookItemBinding

class BooksAdapter:RecyclerView.Adapter<BooksViewHolder>() {
     var bookList = mutableListOf<Book>()

    private  var onItemClickListener:((Book)->Unit)? = null

    fun updateList(list: List<Book>){
        bookList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        return BooksViewHolder(LayoutBookItemBinding.inflate(LayoutInflater.from(parent.context),
        parent,false))
    }
    fun deleteItem(position: Int){
        bookList.removeAt(position)
        notifyItemRemoved(position)
    }
    fun insertItem(item:Book,position:Int){
        bookList.add(position,item)
        notifyItemInserted(position)

    }

    fun setOnItemClickListener(listener:((Book)->Unit)?){
        onItemClickListener=listener
    }
    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        val bookItem = bookList[position]
        holder.binding.tvBookName.text = bookItem.bookName
        Glide.with(holder.binding.root).load(bookItem.posterImage).into(holder.binding.ivPoster)
        holder.binding.root.setOnClickListener{
            onItemClickListener?.invoke(bookItem)
        }
    }

    override fun getItemCount(): Int {
        return  bookList.size
    }
}

class BooksViewHolder(val binding:LayoutBookItemBinding):RecyclerView.ViewHolder(binding.root)

data class Book(val bookName:String, val posterImage:String)