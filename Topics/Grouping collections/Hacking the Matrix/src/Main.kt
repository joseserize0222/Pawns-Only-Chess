fun main() {
     val list = readln().split(" ")
    // write your code here
    val res = list.groupingBy { it.length }.eachCount()

    println(res)
}