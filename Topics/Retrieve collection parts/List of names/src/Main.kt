fun main() {
    val list = readln().split(" ")
    // write your code here
    val res = list.takeWhile { it.first() == 'j' }
    println(res)
}