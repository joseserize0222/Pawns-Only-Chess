data class Spell(val name: String, val power: Int)

fun main() {
    val input = readln().split(" ")
    val spells = input.map { Spell(it.split("-")[0], it.split("-")[1].toInt()) }
    val spellNames = spells.map { spell -> spell.name }
    val spellPowers = spells.map { spell -> spell.power }

    val resultList = spellNames.zip(spellPowers).joinToString(
        separator = "-",
        prefix = "|",
        postfix = "|"
    )
    println(resultList)
}