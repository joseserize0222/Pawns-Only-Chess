fun main() {
    val list = readln().split(" ").map { it.toInt() }

    val deque = ArrayDeque(list)

    for (i in deque.indices) {
        if (i % 2 == 0) {
            print("${deque.first()} ")
            deque.removeFirst()
        } else {
            print("${deque.last()} ")
            deque.removeLast()
        }
    }

}