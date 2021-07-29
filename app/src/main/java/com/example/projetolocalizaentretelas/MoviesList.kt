package com.example.projetolocalizaentretelas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projetolocalizaentretelas.databinding.MoviesListBinding

class MoviesList: AppCompatActivity() {
    private lateinit var binding: MoviesListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initLayout()
        setupList()
    }
    private fun initLayout() {
        binding = MoviesListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupList() {
        val adapter = MoviesAdapter()
        binding.moviesRV.setAdapter(adapter)
        val list = List(10) {
            "Cidade de Deus ${it}"
        }
        adapter.addItemList(list)
    }

}

