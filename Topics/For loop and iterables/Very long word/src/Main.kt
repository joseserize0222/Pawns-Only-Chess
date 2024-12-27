fun findLongestByIterator(strIterator: Iterator<String>): String {
    var result = ""
    while (strIterator.hasNext()) {
        var newString = strIterator.next()
        result = if (newString.length > result.length) newString else result
    }
    return result
}

fun main() {
    val words: List<String> = readLine()!!.split("\\s+".toRegex())
    println(findLongestByIterator(words.iterator()))
}