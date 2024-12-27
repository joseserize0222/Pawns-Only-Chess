import java.util.*

fun main() {
    val list = readln().split(" ").map{ it.toDouble() }

    val deque = ArrayDeque(list)
    while (deque.isNotEmpty()) {
        print("${deque.removeLast()} ")
    }

}