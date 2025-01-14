data class Spell(val name: String, val power: Int)

fun main() {
    val input = readln().split(" ")
    val spells = input.map { Spell(it.split("-")[0], it.split("-")[1].toInt()) }
    // write your code here
    val res = buildList<Spell?> {
        add(spells.maxByOrNull { it.power })
        add(spells.minByOrNull { it.power} )
    }
    println("Most powerful: ${res[0]}-Least powerful: ${res[1]}")
}