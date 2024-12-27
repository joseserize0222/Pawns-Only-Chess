import java.util.*

fun main() {
    val list = readln().split(" ")
    val res =  mutableListOf<String>()

    var index = list.lastIndex
    for (i in list.indices) {
        res.add(list[index])
        index--
    }

    println(res)
}