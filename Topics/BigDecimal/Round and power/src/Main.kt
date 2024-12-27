import java.math.BigDecimal
import java.math.RoundingMode     

fun main() {
    // write your code here
    val power = readln().toInt()
    val mode = readln().toInt()
    var number = readln().toBigDecimal()
    number = number.setScale(mode, RoundingMode.FLOOR).pow(power)
    println(number)
}