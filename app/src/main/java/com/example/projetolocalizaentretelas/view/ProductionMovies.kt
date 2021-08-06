package com.example.projetolocalizaentretelas.view

data class ProductionMovies(val name: String, val logo_path: String, val origin_country: String){
    override fun toString(): String {
        return name
    }


}
