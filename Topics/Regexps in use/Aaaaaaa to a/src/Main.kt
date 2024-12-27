fun main() {
    val text = readln()
    val regex = """[aA]+""".toRegex()
    val result = text.replace(regex, "a")
    println(result)
}