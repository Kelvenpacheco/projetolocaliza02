package com.example.projetolocalizaentretelas

import com.example.projetolocalizaentretelas.ApiConsts.DEFAULT_QUERY
import com.example.projetolocalizaentretelas.ApiConsts.PATH_MOVIE_ID
import com.example.projetolocalizaentretelas.view.MovieModel
import com.example.projetolocalizaentretelas.view.MoviesList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TheMoviesApi{

    @GET("3/movie/popular?$DEFAULT_QUERY")
    fun listPopular(): Call<MoviesList>
    @GET("3/movie/{$PATH_MOVIE_ID}?$DEFAULT_QUERY")
    fun getMovieById(@Path(PATH_MOVIE_ID)id:Int): Call<MovieModel>
}

object ApiConsts {

    private const val API_KEY = "0f7ce2297a949ef31cf740ce1853994f"
    const val PATH_MOVIE_ID = "id"
    const val DEFAULT_QUERY = "api_key=$API_KEY&language=en-US&page=1"
}

class MovieList(val page: Int, val results: List<MovieModel>)