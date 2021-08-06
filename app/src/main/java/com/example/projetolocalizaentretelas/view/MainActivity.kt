package com.example.projetolocalizaentretelas.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projetolocalizaentretelas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_ID = "com.example.projetolocaliza.DetailsActivity.EXTRA_ID"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}