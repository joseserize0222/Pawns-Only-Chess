fun main() {
    val text = readLine()!!
    val regexColors = "#[0-9a-fA-F]{6}\\b".toRegex()
    val result = regexColors.findAll(text)
    for (color in result) {
        println(color.value)
    }
}