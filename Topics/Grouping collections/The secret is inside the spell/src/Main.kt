/* Do not change code below */
fun main() {
    val list = readln().split(" ")
    // write your code here
    val res = list.groupingBy { it.first() }
        .fold(0) { acc, element -> acc + element.length }


    println(res)
}