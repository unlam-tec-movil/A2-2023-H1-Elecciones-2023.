package ar.edu.unlam.mobile2.data

interface NewsRepo {
    fun getNews(): List<News>
}