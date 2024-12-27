fun main() {
    // write your code here
    val input = readln()
    val regex = """(\b[A-Z][a-z]*(\s[A-Z][a-z]*)?\b)""".toRegex()
    val result = regex.findAll(input)
    for (name in result)
        println(name.value)

}