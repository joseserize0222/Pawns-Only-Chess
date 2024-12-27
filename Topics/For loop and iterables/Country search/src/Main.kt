import java.util.ArrayDeque

fun main() {
    val map = mapOf(
        "NG" to "Nigeria", 
        "AU" to "Australia", 
        "CA" to "Canada", 
        "BG" to "Bulgaria", 
        "DE" to "Germany"
    )
    val mapIterator = map.iterator()
    val input = readln().uppercase()
    for ((key, value) in mapIterator) {
        if (key == input) {
            println(value)
            break
        }
    }
}