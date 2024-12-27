fun main() {
    val title = readln()
    val filmTitle = title
        .removePrefix("he-he-he")
        .let { "$it with great actor Ryan Gosling" }
        .uppercase()
        .run (::println)
}