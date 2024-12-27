fun main() {
    val nameList = readln().split(" ").toMutableList()
    val nameSet = nameList.toMutableSet()
    val name = readln()

    println(checkElements(nameList, name))
    println(checkElements(nameSet, name))
}

fun checkElements(list: Collection<String>, name: String) = list.contains(name)

