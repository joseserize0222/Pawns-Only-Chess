import java.math.BigInteger

fun main() {
    // write your code here
    val a = readln().toBigInteger()
    val b = readln().toBigInteger()

    val result = (a + b + (a - b).abs()).divide(2.toBigInteger())

    println(result)
}