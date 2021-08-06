package com.example.projetolocalizaentretelas.repository

import com.example.projetolocalizaentretelas.MovieList
import com.example.projetolocalizaentretelas.TheMoviesApi
import com.example.projetolocalizaentretelas.view.MovieModel
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object MovieRepository {
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.themoviedb.org/")
        .build()

    val moviesApi: TheMoviesApi = retrofit.create(TheMoviesApi::class.java)


    fun getPopular(callback: (List<MovieModel>) -> Unit){
        CoroutineScope(GlobalScope.coroutineContext).launch(Dispatchers.Main){
            withContext(Dispatchers.IO){
                val callApi = moviesApi.listPopular()
                callApi.enqueue (object : Callback<MovieList> {
                    override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                        callback(response.body()?.results ?: mutableListOf())
                    }

                    override fun onFailure(call: Call<MovieList>, t: Throwable) {

                    }
                })
            }
        }
    }


 //   fun getMovieById(id: Int, callback: (MovieModel) -> Unit) {
 //      CoroutineScope(GlobalScope.coroutineContext).launch(Dispatchers.Main) {
 //           withContext(Dispatchers.IO) {
 //               val call = moviesApi.getMovieById(id)
 //             call.enqueue(object : Callback<MovieModel>)
 //           }

 //       }
 //   }

    fun getMovie(callback: (MovieModel) -> Unit, id: Int){
        CoroutineScope(GlobalScope.coroutineContext).launch(Dispatchers.Main){
            withContext(Dispatchers.IO){
                val callApi = moviesApi.getMovieById(id)
                callApi.enqueue(object : Callback<MovieModel>{
                    override fun onResponse(call: Call<MovieModel>, response: Response<MovieModel>) {
                        response.body()?.let {movie ->
                            callback(movie)
                        }

                    }

                    override fun onFailure(call: Call<MovieModel>, t: Throwable) {

                    }
                })
            }
        }
    }

 //   fun getAllMovies(): List<MovieModel> {
 //       return List(10) {
 //           MovieModel(
 //               title = "Clube da Luta $it",
    //               id = it,
    //            poster_path = "/fCAyJrkRaCRCTh8GqN30f8oyQF.jpq",
    //            overview = "aqui vai a sinopse"
    //           )
    //    }
    //}

    //private fun dummyMovie(): MovieModel {
    //    return MovieModel(
    //        title = "Clube da Luta",
    //        id = 999,
    //        poster_path = "/fCAyJrkRaCRCTh8GqN30f8oyQF.jpq",
    //        overview = "aqui vai a sinopse"
    //    )
    //}

    //suspend fun asyncFunction() {
    //    withContext(Dispatchers.IO) {
    //        delay(5100)
    //    }
    //}
//}

    //class MeuCallBack : Callback<MoviesList> {
    //override fun OnResponse(call: Call<MoviesList>, response: Response<MoviesList>) {
    //}

    //override fun onFailure(call: Call<MoviesList>, t: Throwable) {
    //   TODO("Not yet implemented")
    //}

}

private fun Any.enqueue(callback: Callback<MovieList>) {

}
