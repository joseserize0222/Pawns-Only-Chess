fun processIterator(list: List<String>): List<String> {
    val mutableIteratorList = list.toMutableList()
    val mutableIterator = mutableIteratorList.listIterator()
    while (mutableIterator.hasNext()) {
        if (!mutableIterator.next().contains("hyper")) {
            mutableIterator.remove()
        }
    }
    return mutableIteratorList.reversed()
}

fun main() {
    var list = processIterator(readln().split(" "))
    // output the list
    list.forEach {
        println(it)
    }
}