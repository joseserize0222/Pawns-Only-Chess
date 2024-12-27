import java.util.*

fun main(args: Array<String>) {
    val mutableMap = mutableMapOf<Int,String>()
    while(true) {
        val input = readln().split(" ")
        when(input[0]) {
            "end" -> break
            "add" -> {
                if (mutableMap.putIfAbsent(input[1].toInt(), input[2]) != null) {
                    println("ID exists")
                }
            }
            "remove" -> {
                mutableMap.remove(input[1].toInt())
            }
        }
    }
    for ((key, name) in mutableMap.entries) {
        println("$key $name")
    }
}