package com.example.projetolocalizaentretelas.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projetolocalizaentretelas.MoviesAdapter
import com.example.projetolocalizaentretelas.databinding.MoviesListBinding
import com.example.projetolocalizaentretelas.repository.MovieRepository
import com.example.projetolocalizaentretelas.view.MovieListDetailsActivity


class MoviesList: AppCompatActivity() {
    private lateinit var binding: MoviesListBinding

    private lateinit var adapter: MoviesAdapter

 //   val viewModel: MovieModel = ViewModelProvider(this).get(    MovieModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initLayout()
        setupList()
     //   addObservers()
    // viewModel.poster_path

    }

    private fun initLayout() {
        binding = MoviesListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

        private fun setupList() {
         adapter = MoviesAdapter(){id -> openDetailsActivity(id)}
        binding.moviesList.setAdapter(adapter)
        val list = List(10) {
            "Luca ${it}"
        }
        adapter.addItemList(list)

            MovieRepository.getPopular {
                    list ->
                adapter.addItemList(list)
            }
    }

    private fun openDetailsActivity(id: Int) {
        val intent = Intent(this, MovieListDetailsActivity::class.java)
        intent.putExtra("idMovie", id)

        startActivity(intent)
    }

  //  private fun addObservers() {

    //  viewModel.getLiveDataList().observe( this){
    //if (it !=null){
      //        binding.progress.visibility = View.GONE
      //        adapter.setItems(it)
       //   }
      //}
    //}

}

private fun Any.addItemList(list: List<String>) {

}

