fun main() {
    // Write your code here
    val result = readln().split(" ").let {
        buildList<Int?> {
            it.forEach { item ->
                add(item.toIntOrNull())
            }
        }.filterNotNull()
    }.maxOfOrNull { it }
    println(result)
}