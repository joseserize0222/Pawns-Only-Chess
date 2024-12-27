

fun main() {
     /*val list = readln().split(" ").toMutableList()
    // write your code here
    val res = list.sumOf { it.length }
    println(res)*/

    val listOfMaps = listOf(
        mapOf(1 to "one", 2 to "two"),
        mapOf(3 to "three", 4 to "four"),
    )

    val resMapFlatten = listOfMaps.flatMap { it.entries }.associate { it.key to it.value }
    println(resMapFlatten)
}