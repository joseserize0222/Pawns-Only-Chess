data class Ship(val name: String, val ammunition: Int) {
    override fun toString(): String {
        return "$name-$ammunition"
    }
}

fun fixTheQueue(input: String): ArrayDeque<Ship> {
    // Convert input to list of ships
    val shipsList = input.split(" ").map {
        val parts = it.split("-")
        Ship(parts[0], parts[1].toInt())
    }

    // Use ArrayDeque to reorganize a list
    // Put your code here

    val shipsQueue = ArrayDeque<Ship>()

    for (ship in shipsList) {
        shipsQueue.addFirst(ship)
    }

    return shipsQueue
}