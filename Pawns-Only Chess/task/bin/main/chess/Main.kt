package chess

import javax.swing.table.TableColumn

fun showTable(table: List<List<Char>>, rows: Int, columns: Int) {
    val separator = buildString {
        append("  ")
        append("+---".repeat(columns))
        append("+")
    }

    println("Pawns-Only Chess")
    for (i in 1..table.size) {
        println(separator)
        print("${8-i+1} | ")
        println(table[i-1].joinToString(separator = " | ", postfix = " |"))
    }
    println(separator)
    val letters = List<Char>(8) {
        (it + 97).toChar()
    }
    println(letters.joinToString(prefix = "    ", separator = "   ", postfix = "  "))
}
fun main() {
    val table: List<List<Char>> = buildList {
        repeat(8) {
            add(List<Char>(8) { i ->
                if (it == 1) {
                    'B'
                } else if (it == 6) {
                    'W'
                } else
                    ' '
            })
        }
    }
    showTable(table, 8, 8)
}