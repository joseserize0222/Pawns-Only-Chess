fun checkHeight(iterator: Iterator<Int>) {
    while(iterator.hasNext()) {
        val height = iterator.next()
        println( if (height in 145..210) "You can go!" else "Sorry, not today")
    }
}

fun main() {
    val list = readln().split(" ").map(Integer::parseInt).toList()
    checkHeight(list.iterator())
}