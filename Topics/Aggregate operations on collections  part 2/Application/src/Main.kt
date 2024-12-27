data class Ship(val name: String, val ammunition: Int)

fun main() {
    val ships = readln().split(" ")
    val shipsList = ships.map { Ship(it.split("-")[0], it.split("-")[1].toInt()) }

    // write your code here

    val distinctElements = shipsList.distinctBy { it.ammunition }.size
    val sumAmmunition = shipsList.sumOf { it.ammunition }
    val aver = shipsList.map { it.ammunition }.average()

    println("$distinctElements:$sumAmmunition:$aver")
}