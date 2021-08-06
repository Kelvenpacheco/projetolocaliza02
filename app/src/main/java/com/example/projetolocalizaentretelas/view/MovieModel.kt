package com.example.projetolocalizaentretelas.view

data class MovieModel(val title: String, val id: Int, val poster_path: String, val production_companies: List<ProductionMovies>?, val overview: String, val genres: List<GenreModel>?, val vote_average: Double, val adult: Boolean, val release_date: String, val backdrop_path: String, val runtime: Int?)


