package ar.edu.unlam.mobile2.data

object NewsFakeRepo : NewsRepo {
    override fun getNews(): List<News> = listOf(
        News(
            id = 1L,
            title = "Noticia 1",
            subtitle = "Placeholder"
        ),
        News(
            id = 2L,
            title = "Noticia 2",
            subtitle = "Placeholder"
        ),
        News(
            id = 3L,
            title = "Noticia 3",
            subtitle = "Placeholder"
        ),
        News(
            id = 4L,
            title = "Noticia 4",
            subtitle = "Placeholder"
        ),
        News(
            id = 5L,
            title = "Noticia 5",
            subtitle = "Placeholder"
        ),
        News(
            id = 6L,
            title = "Noticia 6",
            subtitle = "Placeholder"
        ),
        News(
            id = 7L,
            title = "Noticia 7",
            subtitle = "Placeholder"
        ),
        News(
            id = 8L,
            title = "Noticia 8",
            subtitle = "Placeholder"
        ),
        News(
            id = 9L,
            title = "Noticia 9",
            subtitle = "Placeholder"
        )
    )
}