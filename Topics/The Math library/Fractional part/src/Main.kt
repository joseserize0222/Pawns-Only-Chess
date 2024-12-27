import kotlin.math.*

fun main() {
    val number = readln().toDouble()
    val digit = ((number - number.toInt()) * 10).toInt()
    println(digit)
}