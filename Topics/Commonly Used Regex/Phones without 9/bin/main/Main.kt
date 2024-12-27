fun main() {
    // write your code here
    val input = readln()
    val regex = Regex("""\(?[0-8]{3}\)?-?[0-8]{3}-?[0-8]{4}""")
    val result = regex.findAll(input)
    for (phone in result)
        println(phone.value)
}