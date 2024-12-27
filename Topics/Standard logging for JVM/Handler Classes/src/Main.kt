fun main() {
    val result: Int? = readln().split(" ").map {
        when {
            it == "info" -> java.util.logging.Level.INFO.intValue()
            it == "warning" -> java.util.logging.Level.WARNING.intValue()
            it == "severe" -> java.util.logging.Level.SEVERE.intValue()
            it == "config" -> java.util.logging.Level.CONFIG.intValue()
            it == "fine" -> java.util.logging.Level.FINE.intValue()
            it == "finer" -> java.util.logging.Level.FINER.intValue()
            it == "finest" -> java.util.logging.Level.FINEST.intValue()
            else -> 0
        }
    }.sumOf { it }
    println(result)
}