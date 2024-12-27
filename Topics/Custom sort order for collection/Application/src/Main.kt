data class Ship(val name: String, val ammunition: Int)

fun main() {
    /*val ships = readln().split(" ")
    val shipsList = ships.map { Ship(it.split("-")[0], it.split("-")[1].toInt()) }

    // write your code here
    val res = shipsList.sortedBy { it.ammunition }
    

    println(res)
    */
    val names = listOf("John", "Jane", "Mary", "Peter", "John", "Jane", "Mary", "Peter")

    val groupedNames = names.groupingBy { it.first() }
        .aggregate { key, accumulator, element, first ->  }
}
