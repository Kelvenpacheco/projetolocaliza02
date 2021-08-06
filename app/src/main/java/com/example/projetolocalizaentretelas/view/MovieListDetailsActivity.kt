package com.example.projetolocalizaentretelas.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.projetolocalizaentretelas.MovieList
import com.example.projetolocalizaentretelas.R
import com.example.projetolocalizaentretelas.databinding.ActivityMainBinding
import com.example.projetolocalizaentretelas.repository.MovieRepository

class MovieListDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list_details)

    val idMovie = intent.getIntExtra("idMovie", -1)

    binding.buttonreturn.setOnClickListener {
        val mudaTela = Intent(this, MovieList::class.java)
        startActivity(mudaTela)
    }
    MovieRepository.getMovie({

        binding.textsinopse.text = it.overview
        binding.titlemoviedescription.text = it.title
        binding.genero.text = it.genres.toString()
        binding.faixaetaria.text = if (it.adult) "+18" else "-18"
        binding.data.text = it.release_date
        binding.movieDuration.text = "${it.runtime} minute"
        binding.textcompany.text = "Company: ${it.production_companies}"

        Glide.with(binding.root)
            .load("https://image.tmdb.org/t/p/w500${it.poster_path}")
            .into(binding.capa)

        Glide.with(binding.root)
            .load("https://image.tmdb.org/t/p/w500${it.backdrop_path}")
            .into(binding.poster)
    }, idMovie)

}


}