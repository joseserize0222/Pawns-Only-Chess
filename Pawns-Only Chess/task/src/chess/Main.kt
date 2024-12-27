package chess

import kotlin.math.*

class Game {
    private val table: List<MutableList<Char>> = buildList {
        repeat(8) {
            add(MutableList<Char>(8) { i ->
                if (it == 1) {
                    'B'
                } else if (it == 6) {
                    'W'
                } else
                    ' '
            })
        }
    }
    private val validEnPassant: List<MutableList<Int>> = buildList {
        repeat(8) {
            add(MutableList(8) { -2 })
        }
    }

    private val players: MutableList<String> = mutableListOf("Player 1", "Player 2")
    private var condition: Boolean = true
    private var turn = 0
    private var totalTurn = 0
    private var numberOfWhites = 8
    private var numberOfBlacks = 8

    enum class MoveType {
        SAME_PLAYER_PAW, FORWARD_INVALID_MOVE, CAPTURE_INVALID, FORWARD_TWICE, FORWARD_ONCE, CAPTURE_IN_PASSANT, CAPTURE, NO_VALID_SYNTAX, MISMATCH_TURN, MOVE_BACKWARDS, END_MOVE
    }
    
    open inner class Move(val fromX: Int, val fromY: Int, val toX: Int, val toY: Int) {
        fun isValid(): Pair<Boolean, MoveType> {
            if (fromX !in 0 ..7 || fromY !in 0 ..7 || toX !in 0 ..7 || toY !in 0 ..7) return false to MoveType.NO_VALID_SYNTAX
            if (!((turn == 0 && table[fromX][fromY] == 'W') || (turn == 1 && table[fromX][fromY] == 'B'))) return false to MoveType.MISMATCH_TURN
            if (turn == 0 && fromX < toX) return false to MoveType.MOVE_BACKWARDS
            if (turn == 1 && fromX > toX) return false to MoveType.MOVE_BACKWARDS
            
            if (table[toX][toY] == table[fromX][fromY]) return false to MoveType.SAME_PLAYER_PAW

            if (fromY == toY) {
                if (table[toX][toY] != ' ') return false to MoveType.FORWARD_INVALID_MOVE
                if (fromX == 1 || fromX == 6) {
                    if (abs(fromX - toX) == 2) return true to MoveType.FORWARD_TWICE
                }
                return if (abs(fromX - toX) == 1) true to MoveType.FORWARD_ONCE else false to MoveType.FORWARD_INVALID_MOVE
            }
            if (abs(fromX - toX) != 1 || abs(fromY - toY) != 1) return false to MoveType.CAPTURE_INVALID

            if (table[toX][toY] == ' ') {
                if (totalTurn - validEnPassant[toX][toY] == 1) {
                    return true to MoveType.CAPTURE_IN_PASSANT
                }
                return false to MoveType.CAPTURE_INVALID
            }
            return if (abs(fromX - toX) == 1 && abs(fromY - toY) == 1) true to MoveType.CAPTURE else false to MoveType.CAPTURE_INVALID
        }
        override fun toString(): String {
            return "${fromX} ${fromY} ${toX} ${toY}"
        }
    }

    private val exitMove = object : Move(0, 0, 0, 0) {}

    private fun String.toMove(): Move {
        return Move(fromY = this[0] - 'a', fromX = '8' - this[1], toY = this[2] - 'a', toX = '8' - this[3])//.also { println("${it.fromX} ${ it.fromY}") }
    }

    private fun validateMove(move: String) : Pair<Boolean, MoveType> {
        val regex = Regex("[a-h][1-8][a-h][1-8]")
        if (!move.matches(regex)) return false to MoveType.NO_VALID_SYNTAX
        val m = move.toMove()
        return  m.isValid()
    }

    private fun getMoveFromInput(prompt: String): Pair<Move, MoveType> {
        while (true) {
            println(prompt)
            val aux = readln()
            if (aux == "exit") {
                condition = false
                return exitMove to MoveType.END_MOVE
            }
            val validationResult = validateMove(aux)
            if (validationResult.first)
                return aux.toMove() to validationResult.second
            when (validationResult.second) {
                MoveType.MISMATCH_TURN -> {
                    println("No ${if (turn == 0) "white" else "black"} pawn at ${aux.substring(0, 2)}")
                } else -> {
                println("Invalid Input")
                }
            }
        }
    }

    private fun cannotMove() : Boolean {
        turn = (turn + 1) % 2
        for (i in 0 until 8) {
            for (j in 0 until 8) {
                val movY = listOf(0, 0, -1, 1)
                if (table[i][j] == 'W' && turn == 0) {
                    val movX = listOf(-1, -2, -1, -1)
                    for (k in 0 until 4) {
                        val move = Move(i, j, i + movX[k], j + movY[k])
                        if (move.isValid().first) {
                            return false
                        }
                    }
                } else if (table[i][j] == 'B' && turn == 1) {
                    val movX = listOf(1, 2, 1, 1)
                    for (k in 0 until 4) {
                        val move = Move(i, j, i + movX[k], j + movY[k])
                        if (move.isValid().first) {
                            return false
                        }
                    }
                }
            }
        }
        return true
    }

    private fun handleMove(moveInfo: Pair<Move, MoveType>) {
        val (move, moveType) = moveInfo
        val mx = if (turn == 0) 1 else -1
        when (moveType) {
            MoveType.CAPTURE_IN_PASSANT -> {
                table[move.toX + mx][move.toY] = ' '
                if (turn == 0) {
                    numberOfBlacks--
                } else {
                    numberOfWhites++
                }
            }
            MoveType.FORWARD_TWICE -> {
                validEnPassant[move.toX + mx][move.toY] = totalTurn
            }
            MoveType.CAPTURE -> {
                if (turn == 0) {
                    numberOfBlacks--
                } else {
                    numberOfWhites--
                }
            }
            else -> {}
        }
        table[move.toX][move.toY] = table[move.fromX][move.fromY]
        table[move.fromX][move.fromY] = ' '
        showTable()
        when {
            (turn == 0 && (move.toX == 0 || numberOfBlacks == 0)) -> {
                println("White Wins!")
                condition = false
            }
            (turn == 1 && (move.toX == 7 || numberOfWhites == 0)) -> {
                println("Black Wins!")
                condition = false
            }
            cannotMove() -> {
                println("Stalemate!")
                condition = false
            }
        }
        turn = (turn + 1) % 2
    }

    private fun showTable(rows: Int = 8, columns: Int = 8) {
        val separator = buildString {
            append("  ")
            append("+---".repeat(columns))
            append("+")
        }
        for (i in 1..table.size) {
            println(separator)
            print("${8 - i + 1} | ")
            println(table[i - 1].joinToString(separator = " | ", postfix = " |"))
        }
        println(separator)
        val letters = List<Char>(8) {
            (it + 97).toChar()
        }
        println(letters.joinToString(prefix = "    ", separator = "   ", postfix = "  "))
        println()
    }

    private fun greet() {
        println("Pawns-Only Chess")
        println("First Player's name:")
        players[0] = readln()
        println("Second Player's name:")
        players[1] = readln()
    }

    fun play() {
        greet()
        showTable()

        while (condition) {
            val move = getMoveFromInput("${players[turn]}'s turn:")
            if (move.first === exitMove) break
            handleMove(move)
            turn = (turn + 1) % 2
            totalTurn++
        }
        println("Bye!")
    }
}

fun main() {
    val game = Game()
    game.play()
}
