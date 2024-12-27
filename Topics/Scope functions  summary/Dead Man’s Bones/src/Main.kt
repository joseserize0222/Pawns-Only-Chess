data class Microphone(
    var track: String = "",
    var frequency: Int = 0,
    var effect: String = "",
    var sensitivity: Double = 0.0
)

fun main() {
    val microphone = Microphone()

    // Write scope function that receive new settings from standard input and set up them to the Microphone
    microphone.apply {
        track = readln()
        frequency = readln().toInt()
        effect = readln()
        sensitivity = readln().toDouble()
    }

    println(microphone)
}