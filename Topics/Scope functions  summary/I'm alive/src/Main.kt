fun main() {
    val amIAlive: Boolean?
    val aliveFilms = listOf("The Believer", "Half Nelson", "Fracture", "Lars and the Real Girl")
    val deadFilms = listOf("Stay", "The Notebook", "The Place Beyond the Pines", "Blade Runner 2049")
    val currentFilm = readln()

    amIAlive = when (currentFilm) {
        in aliveFilms -> true
        in deadFilms -> false
        else -> null
    }

    val conclude: String = amIAlive?.let {
        if (amIAlive) "I'm alive!" else "I'm dead man, guys ("
    } ?: "Unbelievable! I'm Shroedinger`s Ryan!"

    println(conclude)
}