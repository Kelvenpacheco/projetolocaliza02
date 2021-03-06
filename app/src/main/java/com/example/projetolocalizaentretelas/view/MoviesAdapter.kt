package com.example.projetolocalizaentretelas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projetolocalizaentretelas.databinding.MoviesItemBinding
import com.example.projetolocalizaentretelas.view.MovieModel

class MoviesViewHolder(val binding: MoviesItemBinding) : RecyclerView.ViewHolder(binding.root)

class MoviesAdapter(val movieClickListener: (Int) -> Unit) : RecyclerView.Adapter<MoviesViewHolder>() {


    val listMovies: MutableList<MovieModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MoviesItemBinding.inflate(inflater, parent, false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {

        val item = listMovies[position]
        Glide.with(holder.binding.root)
            .load("https://image.tmdb.org/t/p/w500${item.poster_path}")
            .into(holder.binding.poster)
        holder.binding.titlefilm.text = item.title
        holder.binding.setaListFordescription.setOnClickListener{
            movieClickListener(item.id)
        }
    }


    private fun movieClickListener(id: Any) {

    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

    fun addItemList(list: List<MovieModel>){
        listMovies.addAll(list)
        notifyDataSetChanged()
    }

}

private fun <E> MutableList<E>.addAll(elements: List<String>) {

}
