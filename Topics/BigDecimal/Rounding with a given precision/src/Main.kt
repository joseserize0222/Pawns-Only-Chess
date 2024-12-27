import java.math.BigDecimal
import java.math.RoundingMode

fun main() {             
    // write your code here
    val big = readln().toBigDecimal()
    val digits = readln().toInt()
    println(big.setScale(digits, RoundingMode.HALF_DOWN))

    var number = BigDecimal("2.001")
    number += BigDecimal.ONE
    number = -number
    number.setScale(1, RoundingMode.HALF_DOWN)
    print(number)
}