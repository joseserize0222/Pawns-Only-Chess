fun main() {
    // write your code here
    val a = readln().toBigInteger()
    val b = readln().toBigInteger()

    val (q, remainder) = a.divideAndRemainder(b)
    println("$a = $b * $q + $remainder")
}